import { Box } from "@mui/material";
import { useEffect, useState } from "react"
import { API_SERVER_DOMAIN } from "../constants"
import { useParams } from 'react-router-dom'
import { ProductType } from "../types"

function ProductPage() {
    const {productId} = useParams<{ productId: string }>()
    const [product, setProduct] = useState<ProductType | null>(null)
    
    useEffect(()=> {
        fetch(`/product/${productId}`)
            .then((response) => response.json())
            .then((data) => setProduct(data.product))
    },[productId])

    if(!product) {
        return <h1>존재하지 않는 상품입니다.</h1>
    }

    return (
        <div>
            <Box sx={{ display: "flex", justifyContent: "center", mb: 4 }}>
                {product?.thumbnail && (
                    <img
                        src={`${API_SERVER_DOMAIN}/${product.thumbnail}`}
                        alt={product?.name}
                        style={{ width: "100%", maxWidth: 400 }}
                    />
                )}
            </Box>
            <h1>{product?.name}</h1>
            <p>{product?.explanation}</p>
            <span>{product?.price}</span>
        </div>
    )
}

export default ProductPage