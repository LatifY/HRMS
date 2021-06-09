import axios from "axios"
import * as constants from "../constants/constantsApi"

export class CityService{
  

  getAll(){
    return axios.get(constants.CITIES)
  }
}