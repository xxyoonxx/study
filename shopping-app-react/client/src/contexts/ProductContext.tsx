import {createContext, useContext, useState} from "react"

interface ProductType {
    id: number;
    name: string;
    explanation: string;
    price: number;
}

type ProductContextType = [
    ProductType[],
    React.Dispatch<React.SetStateAction<ProductType[]>>
]

// Context
const ProductContext = createContext<ProductContextType | null>(null);

const initialValue: ProductType[] = [
    {
        id:0,
        name: "계란",
        explanation: "신선한 계란",
        price: 9000,
    }
]

// Provider
export function ProductProvider({children}: {children: React.ReactNode}) {
    const productState = useState<ProductType[]>(initialValue)

    return (
        <ProductContext.Provider value={productState}>
            {children}
        </ProductContext.Provider>
    )
}

// Consumer
export function useProductContext() {
    return useContext(ProductContext) as ProductContextType;
}