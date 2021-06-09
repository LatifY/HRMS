import axios from "axios"
import * as constants from "../constants/constantsApi"

export class EmployerService{
  

  getAll(){
    return axios.get(constants.EMPLOYERS)
  }
}