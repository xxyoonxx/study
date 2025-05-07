import { Route, Routes } from "react-router-dom"
import { Layout } from "./components/shared"
import { HomePage, ProductCreatePage, ProductPage, PurchasePage, CartPage, NotFound } from "./pages"

function App() {
    return (
        <Layout>
            <Routes>
                <Route index element={<HomePage/>}/>
                <Route path="create" element={<ProductCreatePage/>}/>
                <Route path="cart" element={<CartPage/>} />
                <Route path="product/:productId" element={<ProductPage/>}/>
                <Route path="purchase/:productId" element={<PurchasePage/>}/>
                <Route path="*" element={<NotFound/>} />
            </Routes>
        </Layout>
    )
}

export default App;