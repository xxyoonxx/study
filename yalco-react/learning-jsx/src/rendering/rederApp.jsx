import '../App.css'

const isLoggedIn = false

function getUserContent(userStatus) {
    return (
        userStatus === "admin" ? (
            <>
                <h2>Admin Dashboard</h2>
            </>
        ) : (
            <h2>Welcome to the community!</h2>
        )
    )
}

const hasMessages = true
const message = "Hello, World!"

function RenderingApp() {

    const fruits = ["Apple", "Banana", "Cherry"]

    return(
        <>
            {isLoggedIn ? <h1>Hello!</h1> : <h1>Sign in</h1>}
            {isLoggedIn ? (<h1>Welcome back!</h1>) : (<h1>Hello, Guest!</h1>)}
            {getUserContent("member")}
            {hasMessages && <h2>you have new message!</h2>}
            {message && <p>Message: {message}</p>}
            <p>
                Message: {message ?? <em>No message</em>}
            </p>
            <p>
                Message: {message || <em>Empty</em>}
            </p>
            {[0,123,'A','Hello',true,false]}
            <ul>
                {fruits.map((fruit, test) => (
                    <li key={test} > {test} {fruit}</li>
                ))}
            </ul>
        </>
    )
}
export default RenderingApp;