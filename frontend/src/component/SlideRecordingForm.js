import React from "react";
import * as actions from '../action/SlideActions';
import ErrorMessageWell from "./ErrorMessageWell";
class SlideRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            slideId : 0,
            slideExpense : 0
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
                <label htmlFor={"slideId"} >Slide Id</label>
                <input type={"number"} id={"slideId"} name={"slideId"} value={this.state.slideId} onChange={this.formOnChange}/>
                <br/>
                <label htmlFor={"slideExpense"} >Cost</label>
                <input type={"number"} id={"slideExpense"} name={"slideExpense"} value={this.state.slideExpense} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordSlide(this.state)}>Submit</button>
                <button onClick={()=> actions.fetchSlides(this.state)}>List</button>
                <button onClick={()=> actions.deleteSlide(this.state)}>Delete</button>
            </div>
        );
    }
}

export default SlideRecordingForm
