import React, { useEffect, useState } from 'react'
import { listEmployees, deleteEmployee } from '../Services/temp.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';

const EmployeeList = () => {
const [employees, setEmployees] = useState([]);
const navigator = useNavigate();

useEffect(() => {
 getAllEmployees();
}, []);

function getAllEmployees() {
   listEmployees().then(response => {
    setEmployees(response.data);
  }).catch(error => {
    console.error('Error fetching employee data:', error);
  })
}

function addNewEmployee() {
  navigator('/add-employee');
}

function updateEmployee(id) {
  navigator(`/update-employee/${id}`);
}

function removeEmployee(id) {
  if (window.confirm("Are you sure you want to delete this employee?")) {
    deleteEmployee(id)
      .then(() => getAllEmployees()) // refresh table after deletion
      .catch(error => console.error('Error deleting employee:', error));
  }
}

  return (
    <div className='container d-flex flex-column align-items-center mt-5'>
      <h2>Employee List</h2>
      <button className='btn btn-primary mb-3' onClick={addNewEmployee}>Add Employee</button>
      <table className='table table-striped'>
        <thead>
          <tr>
            <th>ID</th> 
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(employee => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.f_name}</td>
              <td>{employee.l_name}</td>
              <td>{employee.email}</td>
              <td>
                <button className='btn btn-info me-2' onClick={()=>updateEmployee(employee.id)}>Update</button>
                <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)} style={{marginLeft:'10px'}}>
                  
                  Delete</button>
                {/* <button className='btn btn-danger'>Delete</button> */}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default EmployeeList
