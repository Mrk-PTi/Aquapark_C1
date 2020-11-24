import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/SlideActionConstants'

export const recordSlide = ({slideId, slideExpense}) =>{
    axios.post('/Slide/record',
        {
            slideId : slideId,
            slideExpense : slideExpense
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

export const fetchSlides = () =>{

    axios.get('/Slide/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

export const deleteSlide = ({slideId}) =>{
    axios.delete(`/Slide/${slideId}`)
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
