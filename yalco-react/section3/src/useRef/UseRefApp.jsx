import React, { useState, useRef } from 'react'

import Counter from './Counter'

const UseRefApp = () => {
    const inputRef = useRef(null)

    const handleFocus = () => {
        console.log(inputRef.current)
        inputRef.current.focus()
    }
    return (
        <>
            <Counter/>
            <Counter/>
            <div>
                <input ref={inputRef}
                       type="text" placeholder='Type...'/>
                <button onClick={handleFocus}>
                    Focus Input
                </button>
            </div>
        </>
    )
}

export default UseRefApp