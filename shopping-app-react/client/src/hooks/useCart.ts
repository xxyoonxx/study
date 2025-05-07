import { useCookies } from "react-cookie"
import { ProductType } from "../types"

const COOKIE_KEY = 'cart'

const useCart = () => {
    const [cookies, SetCookies] = useCookies([COOKIE_KEY]);
    const cart = cookies.cart as ProductType[] ?? [];

    const addCart = (newCart: ProductType | ProductType[]) => {
        const nextCarts = newCart instanceof Array
        ? [...cart, ...newCart]
        : [...cart, newCart];

        SetCookies(COOKIE_KEY, nextCarts)
    }

    return {
        cart,
        addCart
    }
};

export default useCart;r