import Child from './Child.jsx'
import {ClassComp, FunctionComp, ArrowFunctionCompt} from "./Component.jsx";

function Hello() {
  return <h1>Hello</h1>
}

function App() {
  return (
      <>
          <Hello/>
          <h2>world</h2>
          <Child />
          <ClassComp/>
          <FunctionComp/>
          <ArrowFunctionCompt/>
      </>
  )
}

export default App