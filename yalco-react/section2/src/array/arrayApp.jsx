import '../App.css'

function ArrayApp() {

    const books = [
        {id:1, title:'title1', published: true, publisher: 'Manning'},
        {id:2, title:'title2', published: false, publisher: 'Packt'},
        {id:3, title:'title3', published: true, publisher: 'OReilly'}
    ]

    const published = books.filter(book => book.published)

    return (
        <>
            {published.length > 0 && <h2>Published Books</h2>}
            {published.length ?
                published.map(book =>
                <article key={book.id}>
                    <strong>{book.title}</strong>
                    <em> - {book.publisher}</em>
                </article>
                ) : <p>No published books found.</p>
            }
        </>
    )
}
export default ArrayApp