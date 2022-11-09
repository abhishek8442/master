import styled from "styled-components"
import { useState } from "react"
import axios from "axios"
import EmployeeService from "./services/EmployeeService"
import { useNavigate } from "react-router-dom"
export default function AdminLogin(){
    let navigate = useNavigate();
    let url = 'http://localhost:8080/loginadmin';
    const[user,setUser]= useState({
        email: '',
        password: ''
    })
    const{email,password} = user;
    function onInputChange(event){
        setUser({...user,email: event.target.value})
    }
    function onPassChange(event){
        setUser({...user,password: event.target.value})
    }
    function Submit(event){
        event.preventDefault();
        url = url + '/user=' + email + '&password=' + password;
        console.log(url)
         axios.post(url,{
            headers: { 
                'Access-Control-Allow-Origin' : '*',
                'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS',
              }
         });
         console.log(event)
        //  navigate('/admin');
    }
    
    return(
        <Form>
        <div id="title">
                <h1>Welcome Admin</h1>
        </div>
        <form onSubmit={(event) => Submit(event)} id="m_form" target="_blank">
            <div class="m_form-control">
                <label for="m_name" id="m_label-name">
                    Username
                </label>
                <input onChange={(event) =>onInputChange(event)} type="email" id="m_name" placeholder="'Enter Your Username'" required/>
            </div>
    
            <div class="m_form-control">
                <label for="m_email" id="m_label-email">
                    Password
                </label>
                <input onChange={ (event) => onPassChange(event)} type="password" id="m_email" placeholder="'Enter Your Password'" required/>
            </div>
    
         <Buttons>
                <button type="submit" value="submit">
                        Login
                </button>
         </Buttons>
            
        </form>

    </Form>
    )
}
// import React, { Component } from 'react';

// class AdminLogin extends Component {
//     constructor(props) 
//     {
//         super(props)

//         this.state = {
//                 email: '',
//                 password: ''
//         }
        
//         this.updateName = this.updateName.bind(this);
//         // this.addEmployee = this.addEmployee.bind(this);
//         // this.editEmployee = this.editEmployee.bind(this);
//         // this.deleteEmployee = this.deleteEmployee.bind(this);

//     }
//     function updateName(event) {
//         const newdata = { ...data }
//         newdata[event.target.id] = event.target.value
//         this.setState({email: newdata});
//         console.log(props)
        
//     }
//     function updateName(event) {
//         const newdata1 = { ...data }
//         newdata1[event.target.id] = event.target.value
//         this.setState({password: newdata1});
//     }
//     render() {
//         return (
//             <div>
//      <Form>
//         <div id="title">
//                 <h1>Welcome Admin</h1>
//         </div>
//     <form onSubmit={} id="m_form" target="_blank">
//             <div class="m_form-control">
//                 <label for="m_name" id="m_label-name">
//                     Username
//                 </label>
//                 <input  onChange={(event) => updateName(event)} type="email" id="m_name" placeholder="'Enter Your Username'" required/>
//             </div>
    
//             <div class="m_form-control">
//                 <label for="m_email" id="m_label-email">
//                     Password
//                 </label>
//                 <input  onChange={(event) => updatePass(event)} type="password" id="m_email" placeholder="'Enter Your Password'" required/>
//             </div>
    
//          <Buttons>
//                 <button type="submit" value="submit">
//                         Login
//                 </button>
//          </Buttons>
            
//      </form>

//     </Form>
//             </div>
//         );
//     }
// }

// export default AdminLogin;


    
const Buttons = styled.div`
display:flex;
flex-direction:column;
align-item:center;

padding: 0 20px;
`

const Form = styled.div`
padding-top:2.5rem;


#title{
    padding-top:2.5rem;
    
    width:100vw;
    display:flex;
    flex-direction:column;
    align-items:center;
}
#title p{
    font-weight:600;
    color: rgba(0,0,0,.50);
    font-size:15px;
    font-style:italic;
    
}


h1{
    
    
    font-size:50px;
}
top:10vh;
height:100vh;
width:100vw;
background-color: #ffe9b4;
background-repeat: no-repeat;
background-position:center;
background-size: cover;

align-items:center;
justify-content:center;
text-align:start;

.m_form-control{
    font-size:20px;
    margin:20px auto;
    display: flex;
    flex-direction:column;
    padding: 0 30px;
    
}
.m_form-control label{
    margin-bottom: 5px;
    font-weight:500;
}
.m_form-control input{
    width: 100%;
    font-size:20px;
    padding:4px;
    font-size:15px;
    
    
}

form {
    background-color: #fff;
    max-width: 500px;
    margin: 50px auto;
    padding: 20px;
    border-radius:1rem;
    box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
}








button {
    background-color: green;
    border: none;
    border-radius: 0.5rem;
    font-family: inherit;
    font-size: 21px;
    color : white;
    font-weight:500;
    cursor:pointer;
    
    padding : 2px 30px;
    
    margin-top: 50px;
    margin-left: 10px;
    margin-bottom: 5px;
}
`