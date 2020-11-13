import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/WatchActionConstants'

export const recordWatch = ({watch_id}) =>{
    axios.post('/Watch/record',
        {
            watch_id : watch_id
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
