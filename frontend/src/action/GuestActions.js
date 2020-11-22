import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/GuestActionConstants'

export const recordGuest = ({questName, watchId, payId, arrivalDateTime}) =>{
    axios.post('/Guest/record',
        {
            questName : questName,
            watchId : watchId,
            payId : payId,
            arrivalDateTime : arrivalDateTime
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

export const fetchGuests = () =>{

    axios.get('/Guest/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteGuest = (questName) =>{
    axios.delete(`/Guest/${questName}`)
        .then(() => {
            fetchGuests();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchGuests();
        });
}
