import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/WatchActionConstants'

export const recordWatch = ({watchId}) =>{
    axios.post('/Watch/record',
        {
            watchId : watchId
        })
        .then(() => {
            fetchWatches();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchWatches();
        });
}

export const fetchWatches = () =>{

    axios.get('/watch/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteWatch = (watchId) =>{
    axios.delete(`/watch/${watchId}`)
        .then(() => {
            fetchWatches();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchWatches();
        });
}
