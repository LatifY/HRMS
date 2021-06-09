import axios from "axios"
import * as constants from "../constants/constantsApi"

export class JobExperienceService{
  

  getAll(){
    return axios.get(constants.JOB_EXPERIENCES)
  }
}