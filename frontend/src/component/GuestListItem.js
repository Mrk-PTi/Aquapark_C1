import React from 'react';

function GuestListItem({questName}, {watchId}, {payId}, {arrivalDateTime}){
    return (
        <span>({questName} {watchId} {payId} {arrivalDateTime})</span>
    );
}

export default GuestListItem;
