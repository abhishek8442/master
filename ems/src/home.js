import React from 'react';
import Header from './header'
import Section from './section';
import Admin from './admin';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import UserSignup from './UserSignup';
import AdminHome from './AdminHome';

export default function Home(){
    return(
        <>
         <Router>
            <Header/>
            
            <Routes>
                <Route  path='/adminlogin' element={<Admin title ="Welcome Admin"/>}/>
                <Route  path='/' element={<Section title="Welcome to ECRUD" tagline=""/>}/>
                <Route  path='/signup' element={<UserSignup />}/>
                <Route  path='/admin' element={<AdminHome />}/>
            </Routes>
            
         </Router>
        
        

    
        </>
        
        
    )
}
