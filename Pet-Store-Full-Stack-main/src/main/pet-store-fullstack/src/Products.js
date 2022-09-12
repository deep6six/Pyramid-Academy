import './Products.css';

import Navbar from './Navbar';
import React from 'react';
import Search from './Search';

function Products() {
    return (
        <div className='Products'>
            <header className='Products-header'>
                <h2>Products</h2>
            </header>
            <Navbar />
            <Search />
            <a href='http://localhost:4000/animals'>Animals</a> <br />
                <a href='http://localhost:4000/items'>Accessories</a>
        </div>
    );
}

export default Products;