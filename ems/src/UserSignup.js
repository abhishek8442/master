
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import styled from "styled-components";
import Header from "./header";
import'./index.css';
import { Link, BrowserRouter as Router } from 'react-router-dom'
export default function UserSignup(){
    return(
        <>
        
                <Header/>
                
                <Form>
                <div id="title">
                     <h1>SignUp</h1>
                
                 </div>
                    <div id="m_form" target="_blank">
                    <form className="container" method="get">
                        <div className="mb-3">
                            <label for="exampleInputEmail1" className="form-label">Email address</label>
                            <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email"/>
                            <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
                        </div>
                        <div className="mb-3">
                            <label for="exampleInputPassword1" className="form-label">Password</label>
                            <input type="password" className="form-control" id="exampleInputPassword1" name="pass"/>
                        </div>
                        <div className="mb-3 form-check">
                            <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                            <label className="form-check-label" for="exampleCheck1">Check me out</label>
                        </div>
                        <button type="submit" className="btn btn-primary">Submit</button>
                        </form>
                    </div>
                
                </Form>
        
          
                
        </>
    )
}

const Form =styled.div`
background-color: #ffe9b4;
height:100vh;
width:100vw;
padding-top:10%;

justify-content:center;
#title{
    text-align:center;
    width:100vw;
}



form {
    background-color: #fff;
    max-width: 500px;
    margin: 50px auto;
    padding: 20px;
    border-radius:1rem;
    box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
}
`