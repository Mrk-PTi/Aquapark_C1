import React from "react";
import * as actions from '../action/GuestActions';
import ErrorMessageWell from "./ErrorMessageWell";
class GuestRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            watchId : 0
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
                <label htmlFor={"watchId"} >Watch</label>
                <input type={"number"} id={"watchId"} name={"watchId"} value={this.state.watchId} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordGuest(this.state)}>Submit</button>
                <button onClick={()=> actions.fetchGuests(this.state)}>List</button>
                <button onClick={()=> actions.deleteGuest(this.state)}>Delete</button>
            </div>
        );
    }
}

export default GuestRecordingForm
