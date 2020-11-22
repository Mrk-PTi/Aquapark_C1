import React from 'react';
import './App.scss';
import './App.css';
import WatchRecordingForm from "./component/WatchRecordingForm";
import WatchList from "./component/WatchList";
import SlideRecordingForm from "./component/SlideRecordingForm";
import SlideList from "./component/SlideList";
import bg from "./video/bg.mp4";
import GuestRecordingForm from "./component/GuestRecordingForm";
import GuestList from "./component/GuestList";

function App() {
  return (
    <div className={["App","container"]}>

        <video src={bg} autoPlay="true" loop="true" muted="true"/>
        <div className="header">
            <a href="#default" className="logo">Aquapark</a>
            <div className="header-right">
                <a className="active" href="#home">Home</a>
                <a href="#contact">Contact</a>
                <a href="#about">About</a>
            </div>
        </div>
        <div id="content" className="round">
    <<<<<<< 36-guest-komponensek-megirasa
            <div id="firstdiv">
                <WatchRecordingForm/>
                <WatchList/>
            </div>
            <hr id="firsthr"/>
            <div id="seconddiv">
                <GuestRecordingForm/>
                <GuestList/>
            </div>
        <footer className="round">
            <p>Made by Group 1</p>
        </footer>
    </div>
  );
}

export default App;
