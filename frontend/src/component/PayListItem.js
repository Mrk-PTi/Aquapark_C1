import React from "react";

function PayListItem({ payId, expense }) {
  return (
    <span>
      Pay id: {payId}, Expense: {expense}
      {"; "}
    </span>
  );
}

export default PayListItem;
