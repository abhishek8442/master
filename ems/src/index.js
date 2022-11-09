// import React from 'react';
// import ReactDOM from 'react-dom/client';
// import './index.css';
// import App from './App';
// import reportWebVitals from './reportWebVitals';

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>
// );

// // If you want to start measuring performance in your app, pass a function
// // to log results (for example: reportWebVitals(console.log))
// // or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals();

import React from 'react';
import ReactDOM from 'react-dom/client';

 import Home from './home'
 
 
import UserHome from './userhome';
import AdminHome from './AdminHome';
import StateButton from './State';
import UserSignup from './UserSignup';
import Header from './header';
import { Link } from 'react-router-dom';
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom';

 ReactDOM.createRoot(document.querySelector("#root")).render(<Home/>);