import React from "react";

import { Container } from "semantic-ui-react";
import "../assets/css/App.css";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Dashboard from "./Dashboard";
import Navi from "./Navi";
import Home from "./Home";
import Login from "./Login";
import Register from "./Register";

export default function App() {
  return (
    <Router>
      <div className="App">
        <Navi />
        <Container className="main">
          <Switch>
            <Route exact path="/"> <Home/> </Route>
            <Route exact path="/home"> <Home /> </Route>
            <Route exact path="/dashboard"> <Dashboard /> </Route>
            <Route exact path="/login"> <Login /> </Route>
            <Route exact path="/register"> <Register /> </Route>
          </Switch>
        </Container>
      </div>
    </Router>
  );
}
