const express = require("express");
const { MongoClient, ObjectId } = require("mongodb");
const cors = require("cors");

const app = express();
app.use(cors());
app.use(express.json());
app.use(express.static("public"));

const uri = "mongodb://127.0.0.1:27017";
const client = new MongoClient(uri);

let collection;

async function startServer() {
  await client.connect();
  const db = client.db("mca");
  collection = db.collection("users");

  console.log("MongoDB Connected");

  app.listen(3000, () => {
    console.log("Server running on http://localhost:3000");
  });
}

startServer();


// CREATE
app.post("/addUser", async (req, res) => {
  const result = await collection.insertOne(req.body);
  res.send(result);
});

// READ
app.get("/users", async (req, res) => {
  const users = await collection.find().toArray();
  res.send(users);
});

// UPDATE
app.put("/updateUser/:id", async (req, res) => {
  const id = req.params.id;
  const result = await collection.updateOne(
    { _id: new ObjectId(id) },
    { $set: req.body }
  );
  res.send(result);
});

// DELETE
app.delete("/deleteUser/:id", async (req, res) => {
  const id = req.params.id;
  const result = await collection.deleteOne({ _id: new ObjectId(id) });
  res.send(result);
});
