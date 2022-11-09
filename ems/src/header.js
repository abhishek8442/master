import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import"./index.css";

export default function Header(){
    return(
    <MainSection>
            <Logo>
                
                <h1><a href='/'>ECRUD</a></h1>

            </Logo>
            <Menu>
                     <Link to='/adminlogin'> Admin</Link>
            </Menu>
        </MainSection>
    )
}

const MainSection = styled.header`
background-color: black;
position:fixed;
color : white;
display: flex;
height : 10vh;
width:100vw;
align-items:center;
justify-content:space-between;
a{ 
    color:white;
    text-decoration:none;
}
`
const Menu = styled.header`
padding-right: 2vw;

a{
    font-weight:600;
}
`
const Logo = styled.header`
padding-left: 2vw;

`