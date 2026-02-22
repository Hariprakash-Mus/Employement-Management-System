import axios from "axios";

const REST_API_URL='http://localhost:8081/api/employees';

export const listEmployees = () =>axios.get(REST_API_URL);
export const CreateEmployee=(employee)=>axios.post(REST_API_URL,employee);
export const getEmployeeById = (id) => axios.get(`${REST_API_URL}/${id}`);
export const updateEmployee = (id, employee) =>
  axios.put(`${REST_API_URL}/${id}`, employee);
export const deleteEmployee = (id) => axios.delete(`${REST_API_URL}/${id}`);
