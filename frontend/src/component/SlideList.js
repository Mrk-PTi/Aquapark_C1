import React from 'react';
import {default as store} from '../store/SlideStore'
import SlideListItem from "./SlideListItem";

class SlideList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {slides : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({slides : store._slides});
    }

    render() {
        return(
            <div>
                {this.state.slides.map(({slideId, slideExpense}, index)=>{
                    return(
                        <SlideListItem key={index} slideId={slideId} slideExpense={slideExpense}/>
                    );
                })}
            </div>
        );
    }
}

export default SlideList;
