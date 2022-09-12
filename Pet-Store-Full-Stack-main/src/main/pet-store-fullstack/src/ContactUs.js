import {useState, useEffect} from "react";
import React from "react";
import Navbar from "./Navbar";
import './ContactUs.css';

function ContactUs() {

    const vals = {fullName: "", email: "", phone: "", message: ""};
    const [values, setValues] = useState(vals);
    const [errors, setErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);
  
    const handleChange = (e) => {
      const {name, value} = e.target;
      setValues({...values, [name]: value});
    };
  
    const handleSubmit = (e) => {
      e.preventDefault();
      setErrors(validate(values));
      setIsSubmit(true);
    };
  
    useEffect(() => {
      if (Object.keys(errors).length === 0 && isSubmit)
      {
          alert("Message sent successfully");
      }
      // eslint-disable-next-line
    }, [errors]);
  
    const validate = (values) => {
      const errors = {};
      const regName = /^([\w]{3,})+\s+([\w\s]{3,})+$/i;
      const regEmail = /^[a-zA-Z0-9]+@(?:[a-zA-Z0-9]+\.)+[A-Za-z]+$/;
      // eslint-disable-next-line
      const regPhone = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;
  
      if (!values.fullName)
      {
        errors.fullName = "Full name is required";
      }
      else if (!regName.test(values.fullName))
      {
        errors.fullName = "Full name is invalid";
      }
      else if (!values.email)
      {
        errors.email = "E-mail Address is required";
      }
      else if (!regEmail.test(values.email))
      {
        errors.email = "E-mail Address is invalid";
      }
      else if (!values.phone)
      {
        errors.phone = "Phone number is required";
      }
      else if (!regPhone.test(values.phone))
      {
        errors.phone = "Phone number is invalid";
      }
      else if (!values.message)
      {
        errors.password = "Message is required";
      }
      return errors;
    }

    return (
        <div className="ContactUs">
            <header className="ContactUs-header">
                <h2>Contact Us</h2>
            </header>
            <Navbar />
            <div className="Form">
                <form onSubmit={handleSubmit}>
                <label for="fullName">
                    Full name: 
                    <input type="text" name="fullName" value={values.fullName} onChange={handleChange}/>
                </label><br/>
                <p className="Error">{errors.fullName}</p>
                <label for="email">
                    E-mail Address: 
                    <input type="text" name="email" value={values.email} onChange={handleChange}/>
                </label><br/>
                <p className="Error">{errors.email}</p>
                <label for="phone">
                    Phone number: 
                    <input type="text" name="phone" value={values.phone} onChange={handleChange}/>
                </label><br/>
                <p className="Error">{errors.phone}</p>
                <label for="password">
                    Message: 
                    <textarea name="message" value={values.message} onChange={handleChange}/>
                </label><br/>
                <p className="Error">{errors.password}</p>
                <button>Confirm</button>
                </form>
            </div>
        </div>
    );
}

export default ContactUs;