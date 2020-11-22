import React from 'react';

function SlideListItem({slideId, slideExpense}){
    return (
        <span>({slideId})</span>,
        <span>({slideExpense})</span>
    );
}

export default SlideListItem;
