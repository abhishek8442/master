import styled from "styled-components"
import Dashboard from "./AdminDashboard"
import { BrowserRouter as Router, Routes,Route, BrowserRouter, Link } from "react-router-dom";
import { useState } from "react";
import Fade from 'react-reveal/Fade';
import {FaAngleDown, FaEye, FaPen, FaPlus} from "react-icons/fa";
import ListOfEmployee from "./component/ListOfEmployee";
import AdminOldNotice from "./component/AdminOldNotice";
export default function AdminSection(){
    const [open,setOpen] = useState(false);
    return(
        <Router>
        <MainSection>
            <SideBar>
                
                <ul id="list">
                    <li><Link to={"/admin/dashboard"}>Dashboard</Link></li>
                   <li ><a onClick={() => setOpen(!open)} > Employees</a>   </li>
                   
                   
                    <ul className={open ? "sub-menu-open":"sub-menu"} >
                        <li><Link to={"/admin/employeelist"}><FaEye className="smallicon"/> View Employees</Link></li>
                        <li><a href=""> <FaPlus className="smallicon"/> Add Employees</a></li>
                    </ul>
                   
                   <li><a href=""> New Signups</a></li>
                   <li><a href=""> Assign Roles</a></li>
                   <li><a href=""> Staff Leave </a></li>
                   <li><a href=""> List of Complaints</a></li>
                   <li><a  > Staff Notice</a> </li>
                   <ul className="sub-menu-open">
                        <li><a href=""><FaPen className="smallicon"/> New Notice</a></li>
                        <li><Link to={"/admin/oldnotice"}>Old Notices</Link></li>
                    </ul>

                </ul>
            </SideBar>
            <MiddleSection>
                <Routes>
                
                       <Route path="/admin/dashboard" element={<Dashboard/>}/> 
                       <Route path="/admin/employeelist" element={<ListOfEmployee/>}/>
                       <Route path="/admin/oldnotice" element={<AdminOldNotice/>}/>

                  
                </Routes>
                

                
                
            </MiddleSection>
        
        </MainSection> 
        </Router>
        

    )
}
// function DownArrow(){
//     return(
//         <span><img src="images/downarrow.svg" ></img> </span>
//     )
// }

const MiddleSection=styled.div`

margin: 5px 20px;
pad
border:1px solid red;
position:relative;

width:60%;

`

const MainSection=styled.div`
padding-top:3.7rem;
height:100vh;
width:100vw;

position:absolute;

display: flex;




`
const SideBar=styled.div`
background-color:black;
opacity:0.90;
overflow:auto;
width:30%;


.icon{
     margin-left:50px;
     cursor:pointer;
     
    
}


height:100vh;
width:200px;
left:0;
#list{
    padding-top:50px;
    cursor:pointer;
}
.smallicon{
    margin-top:2px;
    cursor:pointer;
    
    
}
#list ul li{
    font-size:12px;
    padding-left:2rem;
    padding-bottom:0.5em;
    display:flex;
}

#list li{
    padding-left:10px;
    border-bottom: 1px solid rgba(255,255,255,0.2);
    margin: 10px 10px;
    opacity:0.80;
    a{
        color:white;
    }
}


a{
    color:white;
    text-decoration:none;
    
    
}
.sub-menu{
height:0;
overflow:hidden;

}

.sub-menu-open{
    height:1;
    overflow:none
    transition:1s;
}

`