import { useState, useEffect } from 'react'

const Timer = () => {
    const [seconds, setSeconds] = useState(0)

    useEffect(() => {
        const interval = setInterval(() => {
            setSeconds((prev) => prev + 1)
        }, 1000)

        return () => {
            clearInterval(interval)
            console.log('Timer cleaned up')
        }
    }, [])

    return <p>Timer: {seconds} seconds</p>
}

export default Timer