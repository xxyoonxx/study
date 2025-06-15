import './App.css'
import useCounter from './useCounter'
import useWindowSize from './useWindowSize.jsx'

const HookApp = () => {
    const {
        count, increment, decrement
    } = useCounter(0)
    const {width, height}
        = useWindowSize()


    return (
        <>
            <h2>Counter: {count}</h2>
            <button onClick={increment}>
                Increment
            </button>
            <button onClick={decrement}>
                Decrement
            </button>
            <div>
                <h2>Window Size</h2>
                <p>Width: {width}</p>
                <p>Height: {height}</p>
            </div>
        </>
    )
}

export default HookApp