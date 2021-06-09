import axios from "axios"
import * as constants from "../constants/constantsApi"

export class LanguageService{

  getAll(){
    return axios.get(constants.LANGUAGES)
  }
}