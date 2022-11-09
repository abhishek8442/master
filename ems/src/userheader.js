import styled from "styled-components";
import { useNavigate } from "react-router-dom";
export default function UserHeader(){
    // const navigate = useNavigate()
    // function logOut(){
    //        navigate.push('/')

    // }
      return(
        <>
        <Header>
            <Logo>
                <h1>ECRUD</h1>
            </Logo>
            <Menu>
                <h3>
                    Welcome, User.
                </h3>
                    <button id="logout" > Logout</button>
            </Menu>
        </Header>
        </>
        
        
      )
}
const Header=styled.header`
background-color: black;
position:fixed;
color : white;
display: flex;
height : 10vh;
width:100vw;
align-items:center;
justify-content:space-between;
z-index:10;
`
const Logo=styled.div`
padding-left: 2vw;
`
const Menu=styled.div`
padding-right: 2vw;
display:flex;
align-items:center;
width:25%;
justify-content:space-between;
#logout{
    color:white;
    font-weight:600;
    background-color:black;
}


a{
    font-weight:600;
    color: white;
}`