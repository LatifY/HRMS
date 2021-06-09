import axios from "axios"
import * as constants from "../constants/constantsApi"

export class JobAdvertisementService{
  

  getAll(){
    return axios.get(constants.JOB_ADVERTISEMENTS)
  }
}