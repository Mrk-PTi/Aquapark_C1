import React from "react";
import "./About.css";
class About extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="about container">
        <h1>About</h1>
        <p>Telephone: 123</p>
        <p>Email: 123@123.123</p>
      </div>
    );
  }
}

export default About;
