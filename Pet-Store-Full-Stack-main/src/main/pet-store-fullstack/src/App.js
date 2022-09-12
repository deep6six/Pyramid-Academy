import './App.css';

import Navbar from './Navbar';
import React from 'react';
import cat from './img/cat.jpg';


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h2>Pet Store</h2>
      </header>
      <Navbar />
      <p>Welcome to the Pet Store. Feel free to have a look around, contact us about any questions you have, or buy something when you're ready.</p>
      <img src={cat} alt="Cat"/>   
      <button type="button" class="btn btn-warning">Warning</button>
    </div>
  );
}

export default App;
