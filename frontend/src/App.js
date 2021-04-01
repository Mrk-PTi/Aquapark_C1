import React from "react";
import "./App.scss";
import "./App.css";
import About from "./component/About/About";
import Events from "./component/Events/Events";
import Navbar from "./component/Navbar/Navbar";
import Home from "./component/Home/Home";
import bg from "./video/bg.mp4";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

function App() {
  return (
    <div className={["App", "container"]}>
      <video src={bg} autoPlay="true" loop="true" muted="true" />
      <Router history>
        <Navbar />
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route path="/about">
            <About />
          </Route>
          <Route path="/events">
            <Events />
          </Route>
        </Switch>
        <footer className="round">
          <p>Made by Group 1</p>
          <p>All rights reserved.</p>
        </footer>
      </Router>
    </div>
  );
}

export default App;
