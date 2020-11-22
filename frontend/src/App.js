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
import PayRecordingForm from "./component/PayRecordingForm";
import PayList from "./component/PayList";

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

                <div id="firstdiv">
                    <GuestRecordingForm/>
                    <GuestList/>
                </div>
                <div id="firstdiv">
                    <WatchRecordingForm/>
                    <WatchList/>
                </div>
                <div id="firstdiv">
                    <SlideRecordingForm/>
                    <SlideList/>
                </div>
                <div id="firstdiv">
                    <PayRecordingForm/>
                    <PayList/>
                </div>
                <div id="messagediv">
                </div>
            </div>
            <footer className="round">
                <p>Made by Group 1</p>
                <p>All rights reserved.</p>
            </footer>
        </div>
    );
}

export default App;
