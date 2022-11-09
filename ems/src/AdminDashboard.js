import styled from "styled-components";
import { Link } from "react-router-dom";
import {FaMailBulk, FaUserAlt, FaUserPlus} from "react-icons/fa";
export default function Dashboard(){
    return(
        <>
             <h1>Dashboard</h1>
           <MainSection>
            
            <Link to={"/admin/employeelist"} className="mainpanel" style={{ textDecoration: 'none' }} >
                <div id ="panel1">
                    <h3>Users</h3>
                    <FaUserAlt className="bigicon"/>
                    
                </div>
            </Link>
            <Link to={""} className="mainpanel" >
                <div id ="panel2">
                    <h3>New Signups</h3>
                    <FaUserPlus className="bigicon" />
                </div>
            </Link>
            <Link to={"/admin/oldnotice"} className="mainpanel" >
            <div  id ="panel3">
                <h3>Notice</h3>
                <FaMailBulk className="bigicon" />
            </div>
            </Link>
            
           </MainSection>
        </>
    )
}

const MainSection=styled.div`
display:flex;
z-index:1;
h3{
    padding:5px;
    margin:3px;
}
.bigicon{
    height:100px;
    width:100px;
    margin:10px 0;
    
}
.mainpanel{
    color:black;
    text-decoration:none;
}
#panel1{
    
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
    box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
    border-radius:1rem;
    margin:10px 10px;
    opacity:0.95;
    height: 200px;
    width:200px;
    background-color:red;


}
#panel2{
    justify-content:center;
    
    box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
    display:flex;
    flex-direction:column;
    align-items:center;
    border-radius:1rem;
    margin:10px 10px;
    opacity:0.95;
    height: 200px;
    width:200px;
    background-color:yellow;
   
   
   }
   #panel3{
    box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5) ;
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
    border-radius:1rem;
    margin:10px 10px;
   opacity:0.95;
   height: 200px;
   width:200px;
   background-color:green;
   
   
   }
`
