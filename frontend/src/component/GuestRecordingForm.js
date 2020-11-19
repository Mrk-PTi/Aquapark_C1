import React from "react";
import * as actions from '../action/GuestActions';
import ErrorMessageWell from "./ErrorMessageWell";
class GuestRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            guestName : "",
            watchId : 0,
            payId : 0,
            arrivalDateTime : null
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
                <label htmlFor={"guestName"} >Guest</label>
                <input type={"text"} id={"guestName"} name={"guestName"} value={this.state.guestName} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"watchId"} >Watch</label>
                <input type={"number"} id={"watchId"} name={"watchId"} value={this.state.watchId} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"payId"} >Pay</label>
                <input type={"number"} id={"payId"} name={"payId"} value={this.state.payId} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"arrivalDateTime"} >Arrival</label>
                <input type={"datetime-local"} id={"arrivalDateTime"} name={"arrivalDateTime"} value={this.state.arrivalDateTime} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordGuest(this.state)}>Submit</button>
                <button onClick={()=> actions.fetchGuests(this.state)}>List</button>
                <button onClick={()=> actions.deleteGuest(this.state)}>Delete</button>
            </div>
        );
    }
}

export default GuestRecordingForm
