import axios from "axios"
import * as constants from "../constants/constantsApi"

export class AbilityService{
  

  getAll(){
    return axios.get(constants.ABILITIES)
  }
}