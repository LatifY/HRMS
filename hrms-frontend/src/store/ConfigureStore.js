import { createStore } from 'redux'
import RootReducer from '../reducers/RootReducer'

export default function configureStore(initialState) {
  const store = createStore(RootReducer);
  return store
}