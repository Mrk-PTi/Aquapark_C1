import React from 'react';

function PayListItem({payId, expense}){
    return (
        <span>({payId})</span>,
        <span>({expense})</span>
    );
}

export default PayListItem;
