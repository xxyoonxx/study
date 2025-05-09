import { ProductType } from '../types'

export function getProducts() {
    return fetch("/product")
        .then((response) => response.json())
        .then((response) => response.products)
}

export function getProduct(id: string) {
    return fetch('/product/${id}')
        .then((response) => response.json())
        .then((response) => response.products)
}

export const createProduct = (newProduct: Omit<ProductType, "id">) => {
    return fetch("/product", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(newProduct),
    })
}

export const modifyThumbnail = (productId: string, thumbnail: File) => {
    const formData = new FormData()
    formData.append("thumbnail", thumbnail)
    return fetch(`/product/thumbnail/${productId}`, {
        method: "PATCH",
        body: formData,
    })
}

export const deleteProduct = (id:string) => {
    fetch('/product/${id}', {
        method: "DELETE",
    })
}

export const modifyProduct = (updateProduct: ProductType) => {
    fetch('/product/${updateProduct.id}', {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(updateProduct)
    })
}