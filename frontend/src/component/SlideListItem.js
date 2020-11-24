import React from 'react';

function SlideListItem({slideId, slideExpense}){
    return (
        <span>({slideExpense}, {slideId })</span>

    );
}

export default SlideListItem;
