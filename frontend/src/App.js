import React from "react";
import "./App.scss";
import "./App.css";
import About from "./component/About/About";
import WatchRecordingForm from "./component/WatchRecordingForm";
import WatchList from "./component/WatchList";
import SlideRecordingForm from "./component/SlideRecordingForm";
import SlideList from "./component/SlideList";
import bg from "./video/bg.mp4";
import GuestRecordingForm from "./component/GuestRecordingForm";
import GuestList from "./component/GuestList";
import PayRecordingForm from "./component/PayRecordingForm";
import PayList from "./component/PayList";
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";

function App() {
  function refreshPage() {
    window.location.reload();
  }
  return (
    <div className={["App", "container"]}>
      <video src={bg} autoPlay="true" loop="true" muted="true" />
      <Router history>
        <div className="header">
          <Link to="/">Aquapark</Link>

          <div className="header-right">
            <a href="#contact">Contact</a>
            <Link to="/about">About</Link>
          </div>
        </div>
        <Switch>
          <Route exact path="/">
            <div className="round content">
              <button id="refresh" onClick={() => refreshPage()}>
                ↺
              </button>
              <div id="firstdiv">
                <GuestRecordingForm />
              </div>
              <div id="firstdiv">
                <WatchRecordingForm />
              </div>
              <div id="firstdiv">
                <SlideRecordingForm />
              </div>
              <div id="firstdiv">
                <PayRecordingForm />
              </div>
              <div id="messagediv">
                <GuestList />
                <WatchList />
                <SlideList />
                <PayList />
              </div>
            </div>
            <footer className="round">
              <p>Made by Group 1</p>
              <p>All rights reserved.</p>
            </footer>
          </Route>
          <Route path="/about">
            <About />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
