import React from 'react';
import {useState, useRef} from "react";

interface ProductType {
  id: number
  name: string
  explanation: string
  price: number
}

interface ProductItemProps {
  product: ProductType
}

function App() {
  const [products, setProducts] = useState<ProductType[]>([
    {
      id:0,
      name: "IPhone",
      explanation: `좋아보이네
      좋아보여`,
      price: 1000000,
    },
  ])
  const [name, setName] = useState('')
  const [explanation, setExplanation] = useState('')
  const [price, setPrice] = useState(0)

  const fakeId = useRef(0)
  const handleCreate = (newProduct: Omit<ProductType, 'id'>) => {
    fakeId.current += 1
    setProducts([...products,{
      ...newProduct,
      id: fakeId.current,
    }])
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
          {products.map(({id, name, price, explanation})=>(
              <div key={id}>
                <div>{id}</div>
                <div>{name}</div>
                <div>{price}</div>
                <div>{explanation}</div>
                <button type="button"
                        onClick={()=>
                          setProducts(products.filter(product=>product.id!==id))
                        }
                >삭제하기</button>
                <button
                  type="button"
                  onClick={()=>{console.log('수정하기')}}
                >수정하기</button>
                <br/>
              </div>
          ))}
      </>
  );
}

export default App;
