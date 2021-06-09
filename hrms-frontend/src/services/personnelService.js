import axios from "axios"
import * as constants from "../constants/constantsApi"

export class PersonnelService{
  

  getAll(){
    return axios.get(constants.PERSONNELS)
  }
}