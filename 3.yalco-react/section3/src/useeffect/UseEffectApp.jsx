import './App.css'
import { useState, useEffect } from 'react'
import Timer from './Timer'

const UseEffectApp = () => {
    const [books, setBooks] = useState([])
    const [loading, setLoading] = useState(true)
    const [showTimer, setShowTimer] = useState(false)

    useEffect(() => {
        const fetchBooks = async () => {
            try {
                const response = await fetch('/data/books.json')
                const data = await response.json()
                setBooks(data)
            } catch (error) {
                console.error('Failed to fetch books:', error)
            } finally {
                setLoading(false)
            }
        }

        fetchBooks()
    }, [])

    if (loading) return <p>Loading...</p>

    return (
        <>
            <div>
                <h2>Book List</h2>
                <ul>
                    {books.map((book) => (
                        <li key={book.id}>
                            <strong>{book.title}</strong> by {book.author}
                        </li>
                    ))}
                </ul>
            </div>
            <label>
                <input
                    type="checkbox"
                    checked={showTimer}
                    onChange={
                        (e) => setShowTimer(
                            e.target.checked
                        )}/>
                Show Timer
            </label>
            {showTimer && <Timer />}
        </>
    )
}

export default UseEffectApp