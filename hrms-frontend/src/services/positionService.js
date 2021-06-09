import axios from "axios"
import * as constants from "../constants/constantsApi"

export class PositionService{
  

  getAll(){
    return axios.get(constants.POSITIONS)
  }
}