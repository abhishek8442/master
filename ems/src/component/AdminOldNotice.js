import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class AdminOldNotice extends Component {
    constructor(props) 
    {
        super(props)

        this.state = {
            
                notice:[]
        }
        //this.viewNotice=this.viewNotice.bind(this)
        // this.addEmployee = this.addEmployee.bind(this);
        // this.editEmployee = this.editEmployee.bind(this);
        // this.deleteEmployee = this.deleteEmployee.bind(this);

    }
    componentDidMount(){
        EmployeeService.getNotice().then((res) =>{
            this.setState({notice:res.data});
        });

    }
    render() {
        return (
            <div>
                     <h2 className="text-center">Existing Notice</h2>
            {/* <div className = "row">
               <button className="btn btn-primary" onClick={this.addEmployee}> Add Employee</button>
            </div> */}
            <br></br>
            <div className = "row">
                   <table className = "table table-striped table-bordered">

                       <thead>
                           <tr>
                               <th> Date</th>
                               <th> Description</th>
                               <th> Actions</th>
                           </tr>
                       </thead>
                       <tbody>
                           {
                               this.state.notice.map(
                                   notice => 
                                   <tr key = {notice.id}>
                                        <td> { notice.Date} </td>   
                                        <td> {notice.Notice}</td>
                                        
                                        <td>
                                            
                                            <button style={{marginLeft: "10px"}}  className="btn btn-danger">Delete </button>
                                            
                                        </td>
                                   </tr>
                               )
                           }
                       </tbody>
                   </table>

            </div>
                
            </div>
        );
    }
}

export default AdminOldNotice;