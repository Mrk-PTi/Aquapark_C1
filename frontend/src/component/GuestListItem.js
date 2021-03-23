import React from "react";

function GuestListItem({ guestName, watchId, payId }) {
  return (
    <span>
      Guest name: {guestName}, Watch id: {watchId}, Pay id: {payId}
      {"; "}
    </span>
  );
}

export default GuestListItem;
