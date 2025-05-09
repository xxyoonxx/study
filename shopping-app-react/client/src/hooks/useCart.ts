import { useEffect, useState, useMemo } from "react"
import { useCookies } from "react-cookie"
import { ProductType } from "../types"

type CartType = ProductType & {count:number}

const COOKIE_KEY = 'cart'

const useCart = () => {
    const [cookies, setCookies] = useCookies([COOKIE_KEY]);
    const [carts, setCarts] = useState<ProductType[]>([]);

    const productIds = useMemo(() =>
        (cookies[COOKIE_KEY] as string[]) ?? [],  
        [cookies]
    )

    const addCarts = (id: string) => {
        const nextCartIds = [...productIds, id]
        setCookies(COOKIE_KEY, nextCartIds, {
            path: "/",
        })
    }

    const getProductById = (id: string) => {
        return fetch('/product/${id}')
            .then(response => response.json())
    }

    const changeCount = (productId: string, mode: "increase" | "decrease") => {
        const index = productIds.indexOf(productId)
        if(index === -1) {
            return;
        }

        if (mode === "decrease") {
            const tempArr = [...productIds]
            tempArr.splice(index, 1)

            if (!tempArr.includes(productId)) {
                return;
            }

            setCookies(COOKIE_KEY, tempArr, {
                path: "/",
            })
        }

        if (mode === "increase") {
            setCookies(COOKIE_KEY, [...productIds, productId], {
                path: "/"
            })
        }
    }

    useEffect(() => {
        if (productIds && productIds.length) {
            const requestList: Array<Promise<any>> = []
            const requestIds = productIds.reduce(
                (acc, cur) => acc.set(cur, (acc.get(cur) || 0) +1),
                new Map<String, number> ()
            )

            // 배열화
            Array.from(requestIds.keys()).forEach((id) => {
                requestList.push(getProductById(id))
            })

            Promise.all(requestList)
            .then((responseList) => {
                const cartsData: CartType[] = responseList.map((response) => ({
                    ...response.data.product,
                    count: requestIds.get(response.data.product.id)
                }));
                setCarts(cartsData)
            })
        }
    }, [productIds])

    return {
        carts,
        addCarts,
        changeCount
    }

};

export default useCart;