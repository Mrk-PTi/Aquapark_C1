import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/GuestActionConstants'

export const recordGuest = ({guestName, watchId, payId, arrivalDateTime}) =>{
    axios.post('/guest/record',
        {
            guestName : guestName,
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

    axios.get('/guest/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteGuest = ({guestName}) =>{
    axios.delete(`/guest/${guestName}`)
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
