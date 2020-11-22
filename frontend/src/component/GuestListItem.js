import React from 'react';

function GuestListItem({guestName}, {watchId}, {payId}, {arrivalDateTime}){
    return (
        <span>({guestName}, {watchId}, {payId}, {arrivalDateTime})</span>
    );
}

export default GuestListItem;
