import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/PayActionConstants'

export const recordPay = ({payId}) =>{
    axios.post('/Pay/record',
        {
            payId : payId
        })
        .then(() => {
            fetchPays();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchPays();
        });
}

export const fetchPays = () =>{

    axios.get('/pay/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deletePay = (payId) =>{
    axios.delete(`/pay/${payId}`)
        .then(() => {
            fetchPays();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchPays();
        });
}
