import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/PayActionConstants'

export const recordPay = ({payId, expense}) =>{
    axios.post('/Pay/record',
        {
            payId : payId,
            expense : expense
        })
        .then(() => {
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
        });
}

export const fetchPays = () =>{

    axios.get('/Pay/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deletePay = (payId) =>{
    axios.delete(`/Pay/${payId}`)
        .then(() => {

            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });

        });
}
