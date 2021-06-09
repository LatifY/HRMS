import React from "react";
import ReactDOM from "react-dom";
//import { Router, Route } from "react-router";
//import { Provider } from "react-redux";
//import { createBrowserHistory } from "history"

import "semantic-ui-css/semantic.min.css";
import "./assets/css/index.css";
//import configureStore from './store/ConfigureStore';

//Pages
import App from "./containers/App";
//import Dashboard from "./containers/Dashboard";


//Config
//const history = createBrowserHistory();
//const store = configureStore();

ReactDOM.render(
  /*Redux kullanılmayacağından store ve reducer desteği yorum satırı haline getirildi.
  (
  <Provider store={store}>
    <Router history={history}>
      <Route exact path="/" component={App} />
      <Route path="/home" component={App} />
      <Route path="/dashboard" component={Dashboard} />
    </Router>
  </Provider>
  )
  */
<App />, document.getElementById('root'));

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals();
