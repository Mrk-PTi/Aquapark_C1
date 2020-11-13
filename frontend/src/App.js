import React from 'react';
import './App.scss';
import WatchRecordingForm from "./component/WatchRecordingForm";
import WatchList from "./component/WatchList";

function App() {
  return (
    <div className={["App","container"]}>
        <div className={"row"}>
            <div className={"col-md-3"}></div>
            <div className={"col-md-6"}>
                <WatchRecordingForm/>
                <WatchList/>
            </div>
            <div className={"col-md-3"}></div>
        </div>
    </div>
  );
}

export default App;
