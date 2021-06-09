import axios from "axios"
import * as constants from "../constants/constantsApi"

export class SchoolService{
  

  getAll(){
    return axios.get(constants.SCHOOLS)
  }
}