import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';
class ListOfEmployee extends Component {
    constructor(props) 
    {
        super(props)

        this.state = {
                employees: [],
                notice:[]
        }
        
        // this.addEmployee = this.addEmployee.bind(this);
        // this.editEmployee = this.editEmployee.bind(this);
        // this.deleteEmployee = this.deleteEmployee.bind(this);

    }
   
    componentDidMount(){
        EmployeeService.getEmployees().then((res) => {
            this.setState({ employees: res.data});
        });
    }

    render() {
        return (
            <div>
            <h2 className="text-center">Employees List</h2>
            {/* <div className = "row">
               <button className="btn btn-primary" onClick={this.addEmployee}> Add Employee</button>
            </div> */}
            <br></br>
            <div className = "row">
                   <table className = "table table-striped table-bordered">

                       <thead>
                           <tr>
                               <th> Employee First ID</th>
                               <th> Employee Name</th>
                               <th> Employee Email Id</th>
                               <th> Actions</th>
                           </tr>
                       </thead>
                       <tbody>
                           {
                               this.state.employees.map(
                                   employee => 
                                   <tr key = {employee.id}>
                                        <td> { employee.employee_id} </td>   
                                        <td> {employee.name}</td>
                                        <td> {employee.email}</td>
                                        <td>
                                            {/* <button onClick={ () => this.editEmployee(employee.id)} className="btn btn-info">Update </button>
                                            <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEmployee(employee.id)} className="btn btn-danger">Delete </button>
                                            <button style={{marginLeft: "10px"}} onClick={ () => this.viewEmployee(employee.id)} className="btn btn-info">View </button> */}
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

export default ListOfEmployee;