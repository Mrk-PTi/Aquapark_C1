import {EventEmitter} from 'events'
import dispatcher from "../dispatcher/Dispatcher";
import {refresh} from '../dispatcher/PayActionConstants';

class PayStore extends EventEmitter{

    _pays = [];

    emitChange(){
        this.emit('Change');
    }

    addChangeListener(callback){
        this.addListener('Change',callback);
    }

    removeChangeListener(callback){
        this.removeListener('Change',callback);
    }
}

const store = new PayStore();
export default store;

dispatcher.register(({action,payload})=>{
    if(action !== refresh ) return;
    store._pays = payload;
    store.emitChange();
})