import React from "react";
import "./App.css";

// Function Component
function FunctionComponent() {
  return (
    <div className="box">
      <h2>Function Component</h2>
      <h1 className="name">Your Name</h1>
    </div>
  );
}

// Class Component
class ClassComponent extends React.Component {
  render() {
    return (
      <div className="box">
        <h2>Class Component</h2>
        <h1 className="name">Your Name</h1>
      </div>
    );
  }
}

// Main App Component
function App() {
  return (
    <div className="container">
      <FunctionComponent />
      <ClassComponent />
    </div>
  );
}

export default App;
