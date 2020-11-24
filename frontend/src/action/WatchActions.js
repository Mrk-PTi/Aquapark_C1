import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/WatchActionConstants'

export const recordWatch = ({watchId}) =>{
    axios.post('/Watch/record',
        {
            watchId : watchId
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

export const fetchWatches = () =>{

    axios.get('/Watch/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteWatch = ({watchId}) =>{
    axios.delete(`/Watch/${watchId}`)
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
