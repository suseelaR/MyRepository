import React, { Component } from "react";
import "./App.css";

// Function Component using Props
function Display(props) {
  return (
    <input
      type="text"
      value={props.result}
      readOnly
      className="display"
    />
  );
}

// Class Component
class App extends Component {
  constructor() {
    super();
    this.state = {
      result: ""
    };
  }

  handleClick = (value) => {
    this.setState({
      result: this.state.result + value
    });
  };

  clearDisplay = () => {
    this.setState({
      result: ""
    });
  };

  calculateResult = () => {
    try {
      this.setState({
        result: eval(this.state.result).toString()
      });
    } catch {
      this.setState({
        result: "Error"
      });
    }
  };

  render() {
    return (
      <div className="calculator">
        <h1>React Calculator</h1>

        {/* Function Component with Props */}
        <Display result={this.state.result} />

        <div className="buttons">
          <button onClick={() => this.handleClick("7")}>7</button>
          <button onClick={() => this.handleClick("8")}>8</button>
          <button onClick={() => this.handleClick("9")}>9</button>
          <button onClick={() => this.handleClick("/")}>/</button>

          <button onClick={() => this.handleClick("4")}>4</button>
          <button onClick={() => this.handleClick("5")}>5</button>
          <button onClick={() => this.handleClick("6")}>6</button>
          <button onClick={() => this.handleClick("*")}>*</button>

          <button onClick={() => this.handleClick("1")}>1</button>
          <button onClick={() => this.handleClick("2")}>2</button>
          <button onClick={() => this.handleClick("3")}>3</button>
          <button onClick={() => this.handleClick("-")}>-</button>

          <button onClick={() => this.handleClick("0")}>0</button>
          <button onClick={this.clearDisplay}>C</button>
          <button onClick={this.calculateResult}>=</button>
          <button onClick={() => this.handleClick("+")}>+</button>
        </div>
      </div>
    );
  }
}

export default App;
