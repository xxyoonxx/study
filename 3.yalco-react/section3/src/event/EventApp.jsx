import './App.css'
import Button from './Button.jsx'

function EventApp() {
    function handleClick() {
        console.log('Event 1')
    }

    return (
        <>
            <button onClick={handleClick}>
                Button 1
            </button>
            <button onClick={() => {console.log('Event 2')}}>
                Button 2
            </button>
            <div>
                <Button name={'Home'} />
                <Button name={'Store'} />
                <Button name={'Contact'} />
            </div>
            <div>
                <input
                    onFocus={() => console.log('Focus')}
                    onBlur={() => console.log('Blur')}
                    onChange={(e) => console.log(e.target.value)}
                    onKeyDown={(e) => {
                        console.log(e.key, 'DOWN')
                        if (e.key === 'Enter' && e.shiftKey) {
                            console.log('Shift + Enter DOWN');
                        }
                    }}
                    onKeyUp={(e) => {
                        console.log(e.key, 'UP')
                    }}
                />
            </div>
        </>
    )
}

export default EventApp