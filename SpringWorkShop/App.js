import axios from "axios"
import { useState } from "react"
function App(){
    const [name,setName]=useState("")
    const [phone,setPhone]=useState("")
    const [email,setEmail]=useState("")
    const [password,setPassword]=useState("")
    const handleSubmit=(event)=>{
      const user={name,phone,password,email};
      axios.post("http://localhost:8080/users",user).then(()=>{console.log("Data has been added")})
      event.preventDefault();
    }
    return(
      <form >
        <label > Enter Your name:<input type="text"value={name}onChange={(e)=>setName(e.target.value)} /></label><br /><br />
  
        <label >Enter your phone:<input type="tel" value={phone} onChange={(e)=>setPhone(e.target.value)} /></label><br /><br />
  
        <label >Enter your email: <input type="email" value={email} onChange={(e)=>setEmail(e.target.value)} /></label><br /><br />
        
        <label >Enter your Password:<input type="password" value={password}onChange={(e)=>setPassword(e.target.value)} /></label><br />
        <br />
        <input type="submit" onClick={handleSubmit}/>
      </form>
    )
  }
  export default App
