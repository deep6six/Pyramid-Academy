import React from 'react'
import './LogIn.css'
import Navbar from './Navbar'
const LogIn = () => {
  return (
    <div>
        <Navbar />
        <form className='logInForm'>
            <h1>Log in</h1>
            <div className='email'>
            <label>Email: </label>
            <input type="email"></input>
            </div><br />
            <div className='password'>
            <label>Password: </label>
            <input type="password"></input>
            </div><br />
            <input type="submit" value="Submit"></input>
        </form>
    </div>
  )
}

export default LogIn