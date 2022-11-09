import styled from "styled-components";
import { BrowserRouter as Router, Link, }  from "react-router-dom";
export default function Section(){
    return(
        
        <Form>
                <div id="title">
                        <h1>Welcome to ECRUD</h1>
                        <p>Focus on workforce management, not repetitive processes</p>
                </div>
                <form id="m_form" target="_blank">
                    <div class="m_form-control">
                        <label for="m_name" id="m_label-name">
                            Email
                        </label>
                        <input type="email" id="m_name" placeholder="'Enter Your Name'" required/>
                    </div>
            
                    <div class="m_form-control">
                        <label for="m_email" id="m_label-email">
                            Password
                        </label>
                        <input type="password" id="m_email" placeholder="Enter Your Password" required/>
                    </div>
                <Buttons>
                        <button type="submit" value="submit">
                                Login
                        </button>
                        <button type="submit" value="submit">
                               <Link to='/signup' style={{ textDecoration: 'none' }}> <MenuItem style={{ paddingLeft: 13, color: "white" }}>SignUp</MenuItem>
                               </Link> 
                        </button>

                </Buttons>
                    
                </form>

            </Form>
        

    
    )
}
const Buttons = styled.div`
display: flex;
justify-content:space-between;
padding: 0 20px;
 
`
const MenuItem=styled.div`
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