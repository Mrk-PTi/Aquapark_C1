import React from "react";
import "./Home.css";
import WatchRecordingForm from "../WatchRecordingForm";
import WatchList from "..//WatchList";
import SlideRecordingForm from "../SlideRecordingForm";
import SlideList from "../SlideList";
import GuestRecordingForm from "../GuestRecordingForm";
import GuestList from "../GuestList";
import PayRecordingForm from "../PayRecordingForm";
import PayList from "../PayList";
class Home extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
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
    );
  }
}

export default Home;
