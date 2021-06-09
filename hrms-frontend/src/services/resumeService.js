import axios from "axios"
import * as constants from "../constants/constantsApi"

export class ResumeService{
  

  getAll(){
    return axios.get(constants.RESUMEES)
  }
}