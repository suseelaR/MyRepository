import React, { useState } from "react";
import "./App.css";

function App() {
  const [vote, setVote] = useState("");
  const [submitted, setSubmitted] = useState(false);

  const parties = [
    { name: "Party A" },
    { name: "Party B" },
    { name: "Party C" },
    { name: "Party D" }
  ];

  const castVote = (party) => {
    setVote(party);
    setSubmitted(true);
  };

  const resetVote = () => {
    setVote("");
    setSubmitted(false);
  };

  return (
    <div className="container">
      <div className="card">
        <h1> Voting Application</h1>
        <p>Select one party and submit your vote</p>

        {!submitted ? (
          <div className="party-grid">
            {parties.map((party, index) => (
              <div
                key={index}
                className="party-box"
                onClick={() => castVote(party.name)}
              >
                <h3>{party.name}</h3>
              </div>
            ))}
          </div>
        ) : (
          <div className="result-box">
            <h2>Vote Submitted Successfully</h2>
            <h3>You voted for:</h3>
            <div className="winner">{vote}</div>

            <button onClick={resetVote}>Vote Again</button>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
