import './App.css'
import {useState} from 'react'
import Profile from "./Profile.jsx";
import TempInput from './TempInput'
import UnitSelector from './UnitSelector'

function StateApp2() {
    const users = ['Alice', 'Bob', 'Clark']
    const [user, setUser] = useState(users[0])
    const [status, setstatus] = useState(true)
    const [temperature, setTemperature] = useState("")
    const [unit, setUnit] = useState("Celsius")

    const convertedTemp = unit === "Celsius"
        ? (temperature * 9/5 + 32).toFixed(1)
        : ((temperature - 32) * 5/9).toFixed(1)

    const [username, setUsername] = useState('')
    const [isSubscribed, setSubscribed]
        = useState(false)
    const [role, setRole] = useState('user')
    const roles = ['user', 'admin', 'guest']

    const [formData, setFormData] = useState({
        username: '',
        isSubscribed: false,
        role: 'user'
    })

    const handleChange = (e) => {
        const { name, value, type, checked }
            = e.target
        setFormData({
            ...formData,
            [name]:  type === 'checkbox' ? checked : value
        })
    }

    console.log('App Rendered')

    return (
        <>
            <h2>User Profile</h2>
            <button onClick={() => setstatus(!status)}>
                Toggle Status
            </button>
            <button onClick={
                () => setUser(
                    users[(users.indexOf(user) + 1) % users.length]
                )}>
                Switch User
            </button>
            <p>
                <b>{user}</b> | {status ? 'Active' : 'Inactive'}
            </p>

            <Profile name={user}/>

            <div>
                <h2>Temperature Converter</h2>
                <p>
                    Converted: {temperature ? convertedTemp : "--"}
                    {unit === "Celsius" ? "°F" : "°C"}
                </p>
                <TempInput
                    value={temperature}
                    unit={unit}
                    onChange={setTemperature}
                />
                <UnitSelector
                    unit={unit}
                    onUnitChange={setUnit}
                />
            </div>
            <form>
                <p>
                    Name: {username}
                    {isSubscribed && ' (Subscribed)'}
                </p>
                <p>Role: {role}</p>
                <input
                    type="text" placeholder="Username"
                    value={username}
                    onChange={
                        (e) => setUsername(e.target.value)
                    }/>
                <input
                    type="checkbox"
                    checked={isSubscribed}
                    onChange={
                        (e) => setSubscribed(e.target.checked)
                    }/>
                <label>Subscribe</label>

                <select value={role} onChange={
                    (e) => setRole(e.target.value)}>
                    {roles.map((r) => (
                        <option key={r} value={r}>
                            {r}
                        </option>
                    ))}
                </select>
            </form>
        </>
    )
}

export default StateApp2;