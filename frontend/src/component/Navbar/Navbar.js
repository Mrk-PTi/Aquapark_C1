import React from "react";
import "./Navbar.css";
import { Link } from "react-router-dom";
class Navbar extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="header">
        <Link to="/">Aquapark</Link>

        <div className="header-right">
          <Link to="/events">Events</Link>
          <Link to="/about">About</Link>
        </div>
      </div>
    );
  }
}

export default Navbar;
