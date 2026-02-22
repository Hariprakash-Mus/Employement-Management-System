import React, { useEffect, useState } from 'react';
import { CreateEmployee, getEmployeeById, updateEmployee } from '../Services/temp';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeeComponent = () => {

  const [f_name, setF_name] = useState('');
  const [l_name, setL_name] = useState('');
  const [email, setEmail] = useState('');
  const [error, setError] = useState({ f_name: '', l_name: '', email: '' });

  const { id } = useParams(); // id will exist if updating
  const navigate = useNavigate();

  // Load employee data if updating
  useEffect(() => {
    if(id){
      getEmployeeById(id)
        .then(response => {
          setF_name(response.data.f_name);
          setL_name(response.data.l_name);
          setEmail(response.data.email);
        })
        .catch(error => {
          console.error('Error fetching employee data:', error);
        });
    }
  }, [id]);

  // Form validation
  const validateForm = () => {
    let isValid = true;
    const errorsCopy = { ...error };

    if (!f_name.trim()) { errorsCopy.f_name = 'First name is required'; isValid = false; } 
    else { errorsCopy.f_name = ''; }

    if (!l_name.trim()) { errorsCopy.l_name = 'Last name is required'; isValid = false; } 
    else { errorsCopy.l_name = ''; }

    if (!email.trim()) { errorsCopy.email = 'Email is required'; isValid = false; } 
    else { errorsCopy.email = ''; }

    setError(errorsCopy);
    return isValid;
  };

  // Save employee (add or update)
  const saveEmployee = (e) => {
    e.preventDefault();
    if(!validateForm()) return;

    const employee = { f_name, l_name, email };

    if(id){
      // Update existing employee
      updateEmployee(id, employee)
        .then(response => {
          console.log('Employee updated:', response.data);
          navigate('/employees');
        })
        .catch(error => console.error('Error updating employee:', error));
    } else {
      // Create new employee
      CreateEmployee(employee)
        .then(response => {
          console.log('Employee created:', response.data);
          navigate('/employees');
        })
        .catch(error => console.error('Error creating employee:', error));
    }
  };

  return (
    <div className='ms-4 container'>
      <div className='row'>
        <div className='card col-md-12'>
          <h2 className='text-center'>{id ? 'Update Employee' : 'Add Employee'}</h2>
          <div className='card-body'>
            <form onSubmit={saveEmployee}>
              <div className='form-group mb-2'>
                <label className='form-label'>First Name</label>
                <input
                  type='text'
                  className={`form-control ${error.f_name ? 'is-invalid' : ''}`}
                  value={f_name}
                  onChange={(e) => setF_name(e.target.value)}
                />
                {error.f_name && <div className='invalid-feedback'>{error.f_name}</div>}
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Last Name</label>
                <input
                  type='text'
                  className={`form-control ${error.l_name ? 'is-invalid' : ''}`}
                  value={l_name}
                  onChange={(e) => setL_name(e.target.value)}
                />
                {error.l_name && <div className='invalid-feedback'>{error.l_name}</div>}
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Email</label>
                <input
                  type='text'
                  className={`form-control ${error.email ? 'is-invalid' : ''}`}
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
                {error.email && <div className='invalid-feedback'>{error.email}</div>}
              </div>

              <button type='submit' className='btn btn-success'>Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
