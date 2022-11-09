
import { BrowserRouter } from "react-router-dom"
import UserHeader from "./userheader"

import UserSection from "./UserSection"
export default function UserHome(){
      return(
        <>
        <BrowserRouter>
            <UserHeader/>
            <UserSection/>
        </BrowserRouter>
            
        </>
        
        
      )
}
