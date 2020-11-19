import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/GuestActionConstants'

export const recordGuest = ({watchId}) =>{
    axios.post('/Guest/record',
        {
            questName : questName,
            watchId : watchId,
            payId : payId,
            arrivalDateTime : arrivalDateTime
        })
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

export const fetchGuests = () =>{

    axios.get('/guest/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteGuest = (watchId) =>{
    axios.delete(`/guest/${watchId}`)
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
