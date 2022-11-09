import styled from "styled-components"
import ListOfEmployee from "./component/ListOfEmployee"

export default function UserSection(){
    return(
        <>
        <MainSection>
        <SideBar>
                    
                    <ul>
                    <li><a href=""> View Profile</a></li>
                    <li><a href=""> Update Profile</a></li>
                    <li><a href=""> Mark Attendance</a></li>
                    <li><a href=""> View Attendance</a></li>
                    <li><a href=""> Notice</a></li>
                    <li><a href=""> Leave Application</a></li>
                    <li><a href=""> Register Complaint</a></li>

                    </ul>
                </SideBar>
                <RightSection>
                    <ListOfEmployee/>
                </RightSection>
         
            
            
        </MainSection> 
          
        </>
    )
}
const MainSection=styled.div`
padding-top:3.7rem;
display:flex;
justify-content:start;

height:100vh;
`
const RightSection=styled.div`
margin: 5px 20px;

width:60%;

`
const SideBar=styled.div`
background-color:black;
opacity:0.90;
height:100vh;
width:200px;
overflow:auto;
left:0;

ul{
    padding-top:40px;

}
ul li{
    padding-left:10px;
    border-bottom: 1px solid white;
    margin: 10px 10px;
    opacity:0.80;
}

a{
    color:white;
    text-decoration:none;
    
    
}

`