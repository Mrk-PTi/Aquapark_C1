import React from "react";
import * as actions from '../action/PayActions';
import ErrorMessageWell from "./ErrorMessageWell";
class PayRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            payId : 0
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
                <label htmlFor={"payId"} >Pay</label>
                <input type={"number"} id={"payId"} name={"payId"} value={this.state.payId} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordPay(this.state)}>Submit</button>
                <button onClick={()=> actions.fetchPays(this.state)}>List</button>
                <button onClick={()=> actions.deletePay(this.state)}>Delete</button>
            </div>
        );
    }
}

export default PayRecordingForm
