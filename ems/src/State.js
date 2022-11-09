import { useState } from "react"
import { FaMinus, FaPlus } from "react-icons/fa"

export default function StateButton(){
    const state = useState();
    const [count,setCount] = useState(0)
    function incState(){
        return(
            setCount(count+1)
        )
    }
    return(
        <> 
        <button onClick={incState}>
            <FaPlus/>
        </button>
          
          <p>{count}</p>
          <button>
             <FaMinus/>
          </button>
          
        </>
    )
}
