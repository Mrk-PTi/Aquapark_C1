import React from "react";
import "./App.scss";
import "./App.css";
import About from "./component/About/About";
import Events from "./component/Events/Events";
import Navbar from "./component/Navbar/Navbar";
import WatchRecordingForm from "./component/WatchRecordingForm";
import WatchList from "./component/WatchList";
import SlideRecordingForm from "./component/SlideRecordingForm";
import SlideList from "./component/SlideList";
import bg from "./video/bg.mp4";
import GuestRecordingForm from "./component/GuestRecordingForm";
import GuestList from "./component/GuestList";
import PayRecordingForm from "./component/PayRecordingForm";
import PayList from "./component/PayList";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

function App() {
  return (
    <div className={["App", "container"]}>
      <video src={bg} autoPlay="true" loop="true" muted="true" />
      <Router history>
        <Navbar />
        <Switch>
          <Route exact path="/">
            <div className="round content">
              <button id="refresh" onClick={() => window.location.reload()}>
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
          <Route path="/events">
            <Events />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
