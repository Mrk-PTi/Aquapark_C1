import React from 'react';
import {default as store} from '../store/PayStore'
import PayListItem from "./PayListItem";

class PayList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {pays : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({pays : store._pays});
    }

    render() {
        return(
            <div>
                {this.state.pays.map(({payId}, index)=>{
                    return(
                        <PayListItem key={index} payId={payId}/>
                    );
                })}
            </div>
        );
    }
}

export default PayList;
