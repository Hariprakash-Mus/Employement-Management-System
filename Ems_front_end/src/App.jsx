import { useState } from 'react'

import 'bootstrap/dist/css/bootstrap.min.css';
import EmployeeList from './Components/EmployeeList';
import EmployeeComponent from './Components/EmployeeComponent';
// import Header from './Components/Header';
import {BrowserRouter, Route, Routes} from 'react-router-dom';

function App() {
 

  return (
    <>
     <BrowserRouter>
     <Routes>
      <Route path='/' element={<EmployeeList />} />
      <Route path='/employees' element={<EmployeeList/>}/>
      <Route path='/add-employee' element={<EmployeeComponent/>}/>
      <Route path='/update-employee/:id' element={<EmployeeComponent/>}/>
     </Routes>
     
     </BrowserRouter>
      
    </>
  )
}

export default App
