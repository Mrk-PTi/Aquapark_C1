import React from "react";

function SlideListItem({ slideId, slideExpense }) {
  return (
    <span>
      Slide expense: {slideExpense}, Slide id: {slideId} {"; "}
    </span>
  );
}

export default SlideListItem;
