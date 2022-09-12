import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";
//import * as ReactBootStrap from "react-bootstrap"

const Navbar = () => {
    return (
        <div className="Navbar">
            <div className="btn"><Link to="/">Home</Link></div>
            <div className="btn1"><Link to="/products">Products</Link></div>
            <div className="btn2"><Link to="/contact">Contact Us</Link></div>
            <div className="btn3"><Link to="/LogIn">Log In</Link></div>
            <div className="btn4"><Link to="/Create">Create Account</Link></div>
        </div>


        

    );
}

export default Navbar;