import axios from "axios"
import * as constants from "../constants/constantsApi"

export class EmployeeService{

  getAll(){
    return axios.get(constants.EMPLOYEES)
  }

  save(employee){
    axios.post(constants.EMPLOYEES, employee)
  }
}