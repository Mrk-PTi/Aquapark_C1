import React from "react";
import * as actions from '../action/WatchActions';
import ErrorMessageWell from "./ErrorMessageWell";
class WatchRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            watch_id : 0
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    render() {
        return(
            <div>
                <ErrorMessageWell/>
                <label htmlFor={"watch_id"} >Watch_id</label>
                <input type={"number"} id={"watch_id"} name={"watch_id"} value={this.state.watch_id} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordWatch(this.state)}>Submit</button>
            </div>
        );
    }
}

export default WatchRecordingForm
