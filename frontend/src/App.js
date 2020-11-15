import React from 'react';
import './App.scss';
import './App.css';
import WatchRecordingForm from "./component/WatchRecordingForm";
import WatchList from "./component/WatchList";
import bg from "./video/bg.mp4";

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
            <WatchRecordingForm/>
            <WatchList/>
        </div>
        <footer className="round">
            <p>Made by group1</p>
        </footer>
    </div>
  );
}

export default App;
