import React, { useContext, useEffect, useState } from 'react';

import { CartContext } from '../context/CartContext';

const Cart = () => {
const{
  cartState: { cart },
  cartDispatch,
}=useContext(CartContext);

const[total, setTotal] = useState();

useEffect(() => {
  let calculatedTotal = 0;
  cart.map(cartItem => {
    return calculatedTotal += Number (cartItem.price);
  });
  setTotal(calculatedTotal);
}, [cart])

  
  return (
    <div>This is the Cart Screen</div>
  )
}

export default Cart;
