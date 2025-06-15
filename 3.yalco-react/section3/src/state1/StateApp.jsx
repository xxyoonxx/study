import './App.css'
import { useState } from 'react'

function StateApp() {
    const [count, setCount] = useState(0)
    const [isPinned, setPinned] = useState(false)

    const togglePinned = () => {
        setPinned(p => !p)
    }

    const [todos, setTodos] = useState(
        ['Learn React', 'Build a project']
    )

    const [newTodo, setNewTodo] = useState('')

    const addTodo = (newTodo) => {
        setTodos([...todos, newTodo])
        setNewTodo('')
    }
    const deleteTodo = (index) => {
        setTodos(
            todos.filter(
                (_, i) => i !== index)
        );
    }

    return (
        <>
            <h2>Count: {count}</h2>
            <button onClick={() => setCount(c => c + 1)}>
                +
            </button>
            <button onClick={() => setCount(c => c - 1)}>
                -
            </button>
            <button onClick={togglePinned}>
                {isPinned && '📌'} Pinn This!
            </button>
            <div>
                <h3>Todo List</h3>
                <ul>
                    {todos.map((todo, index) => (
                        <li key={index}>
                            {todo}
                            <button onClick={
                                () => deleteTodo(index)}>
                                Delete
                            </button>
                        </li>
                    ))}
                </ul>
                <p>Typing: {newTodo}</p>
                <input type='text' value={newTodo}
                       onChange={
                           (e) => setNewTodo(e.target.value)}/>
                <button onClick={() => addTodo(newTodo)}>
                    Add New Task
                </button>
            </div>
        </>
    )
}

export default StateApp