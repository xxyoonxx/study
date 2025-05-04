import React from 'react';
import {useProductContext} from "../contexts/ProductContext"
import {useState, useRef} from "react";
import { Link } from "react-router-dom"

interface ProductType {
    id: number
    name: string
    explanation: string
    price: number
}

interface ProductItemProps {
    product: ProductType
    onDelete: (id:number) => void
    onUpdate: (product: ProductType) => void
}

const ProductItem = ({product, onDelete, onUpdate}: ProductItemProps)=> {
    const {id, name, price, explanation} = product
    const [isEditMode, setIsEditMode] = useState(false)
    const [editName, setEditName] = useState(product.name)
    const [editExplanation, setEditExplanation] = useState(product.explanation)
    const [editPrice, setEditPrice] = useState(product.price)

    return(
        <div>
            <div>{id}</div>
            <div>
                <Link to={`/${id}`}>{name}</Link>
            </div>
            <div>{price}</div>
            <div>{explanation}</div>
            <button type="button" onClick={()=>onDelete(id)}>
                삭제하기
            </button>
            <button
                type="button"
                onClick={()=>setIsEditMode((prev)=>!prev)}>
                수정하기
            </button>

            {isEditMode && (
                <form
                    onSubmit={(event) => {
                        event.preventDefault()
                        onUpdate({
                            id,
                            name: editName,
                            price: editPrice,
                            explanation: editExplanation
                        })
                    }}
                >
                    <input
                        type="text"
                        placeholder="상품 이름"
                        value={editName}
                        onChange={(event)=>setEditName(event.target.value)}/>
                    <input
                        type="text"
                        placeholder="상품 설명"
                        value={editExplanation}
                        onChange={(event)=>setEditExplanation(event.target.value)}/>
                    <input
                        type="number"
                        placeholder="상품 가격"
                        value={editPrice}
                        onChange={(event)=>setEditPrice(parseInt(event.target.value,10))}/>
                    <input type="submit" placeholder="상품 수정하기"/>
                </form>
            )}
        </div>
    )
}

function HomePage() {
    const [products, setProducts] = useProductContext()
    const [name, setName] = useState('')
    const [explanation, setExplanation] = useState('')
    const [price, setPrice] = useState(0)

    const fakeId = useRef(0)
    const handleCreate = (newProduct: Omit<ProductType, 'id'>) => {
        fakeId.current += 1
        setProducts([...products, {
            ...newProduct,
            id: fakeId.current,
        }])
    }

    const handleDelete = (id: number) =>
        setProducts(products.filter((product)=>product.id !== id))

    const handleUpdate = (updateProduct:{
        id:number
        name:string
        explanation:string
        price:number
    }) => {
        setProducts(products.map((product)=>(
            product.id===updateProduct.id ? updateProduct : product
        )))
    }

    return (
        <>
            <form onSubmit={(event)=>{
                event.preventDefault()
                handleCreate({
                    name,
                    explanation,
                    price,
                })
            }}>
                <input value={name}
                       onChange={(event)=> setName(event.target.value)}
                       type="text" placeholder="상품 이름" />
                <input value={explanation}
                       onChange={(event)=> setExplanation(event.target.value)}
                       type="text" placeholder="상품 설명" />
                <input value={price.toString()}
                       onChange={(event)=> setPrice(parseInt(event.target.value, 10))}
                       type="number" placeholder="상품 가격" />
                <input type="submit" placeholder="상품 만들기" />
            </form>
            {products.map((product)=>(
                <ProductItem
                    key={product.id}
                    product={product}
                    onDelete={handleDelete}
                    onUpdate={handleUpdate}
                />
            ))}
        </>
    );
}

export default HomePage;