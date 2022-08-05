import React, {useState} from "react";
import Form from "./components/Form";
import Header from "./components/Header";
import Footer from "./components/Footer";

function App() 
{

  const adminUser = { email: "admin@admin.net", password: "adminpw00" }
  const [user, setUser] = useState( { name:"", email:"" } );
  const [error, setError] = useState("");

  const Login = details => {
    console.log(details)
    if (details.email == adminUser.email && details.password == adminUser.password) 
    { 
      console.log("Logged in");
      setUser( {name: details.name, email: details.email} );
    }
    else 
    { 
      console.log("Incorrect login information");
      setError("Incorrect login information");
    }
  };

  const Logout = () => { console.log("Logged out"); setUser( {name:"", email:""} ); }


  return (
    <div className="App">
      <header><Header/></header>
      { (user.email != "") ? (
        <div className="wecome"> 
          <h2>Welcome, <span>{user.name}</span></h2>
          <button onClick={Logout}>Logout</button>
        </div> 
        ) : ( <Form Login={Login} error={error}/>)
      }
      <footer><Footer/></footer>
      </div>  
  )
}
      
export default App;
