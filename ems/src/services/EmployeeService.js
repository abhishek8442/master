import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/admin/employeelist";
const ADMIN_OLD_NOTICE_API_BASE_URL = "http://localhost:8080/admin/get_notice";
const ADMIN_LOGIN_BASE_URL ="http://localhost:8080/loginadmin";
class EmployeeService {
    
    // postAdmin(){
    //     return axios.post(ADMIN_LOGIN_BASE_URL,admin)
    // }
    getNotice(){
        return axios.get(ADMIN_OLD_NOTICE_API_BASE_URL);
    }
    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

    // createEmployee(employee){
    //     return axios.post(EMPLOYEE_API_BASE_URL, employee);
    // }

    // getEmployeeById(employeeId){
    //     return axios.get(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    // }

    // updateEmployee(employee, employeeId){
    //     return axios.put(EMPLOYEE_API_BASE_URL + '/' + employeeId, employee);
    // }

    // deleteEmployee(employeeId){
    //     return axios.delete(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    // }
}

export default new EmployeeService()
