import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav>
        <Link class="item" to='/'>Home</Link>
        <Link class="item" to='/content'>Content</Link>
        <Link class="item" to='/about'>About</Link>
        <Link class="item" to='/contact'>Contact</Link>
    </nav>
  )
}

export default Navbar