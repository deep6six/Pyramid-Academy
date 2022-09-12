import React from 'react'
import Navbar from './Navbar'

const CreateAccount = () => {
  return (
    <div>
        <Navbar />
        <form className='createAccountForm'>
        <h1>Create Account</h1>
            <div>
                <label className='name'>Full Name: </label>
                <input type="text"></input>
            </div><br />
            <div>
                <label className='createEmail'>Email: </label>
                <input type="email"></input>
            </div><br />
            <div>
                <label className='createPass'>Password: </label>
                <input type="password"></input>
            </div><br />
            <div>
                <label className='verifyPass'> Re-Enter Password: </label>
                <input type="password"></input>
            </div><br />
            <div>
                <label className='phone'>Phone Number: </label>
                <input type="text"></input>
            </div><br />
            <input type="submit" value="Submit"></input>
        </form>
    </div>
  )
}

export default CreateAccount