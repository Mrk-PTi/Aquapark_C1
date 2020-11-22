import React from 'react';

function PayListItem({payId, expense}){
    return (
        <span>({payId }, {expense})</span>

    );
}

export default PayListItem;
