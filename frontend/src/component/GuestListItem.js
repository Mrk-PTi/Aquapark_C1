import React from 'react';

function GuestListItem({guestName, watchId, payId}){
    return (
        <span>({guestName}, {watchId}, {payId})</span>

    );
}

export default GuestListItem;
