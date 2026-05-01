const API = "http://localhost:3000";

let editId = null;

// ADD USER
async function addUser() {
  const name = document.getElementById("name").value;
  const age = document.getElementById("age").value;

  await fetch(API + "/addUser", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, age })
  });

  clearInputs();
  loadUsers();
}

// LOAD USERS
async function loadUsers() {
  const res = await fetch(API + "/users");
  const data = await res.json();

  const list = document.getElementById("list");
  list.innerHTML = "";

  data.forEach(user => {
    const li = document.createElement("li");

    li.innerHTML = `
      <b>${user.name}</b> (${user.age})
      <br><br>
      <button class="edit-btn" onclick="editUser('${user._id}', '${user.name}', '${user.age}')">Edit</button>
      <button class="delete-btn" onclick="deleteUser('${user._id}')">Delete</button>
    `;

    list.appendChild(li);
  });
}

// EDIT (Fill form)
function editUser(id, name, age) {
  document.getElementById("name").value = name;
  document.getElementById("age").value = age;

  editId = id;
}

// UPDATE USER
async function updateUser() {
  if (!editId) {
    alert("Select a user to edit");
    return;
  }

  const name = document.getElementById("name").value;
  const age = document.getElementById("age").value;

  await fetch(API + "/updateUser/" + editId, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name, age })
  });

  editId = null;
  clearInputs();
  loadUsers();
}

// DELETE
async function deleteUser(id) {
  await fetch(API + "/deleteUser/" + id, {
    method: "DELETE"
  });

  loadUsers();
}

// CLEAR INPUT
function clearInputs() {
  document.getElementById("name").value = "";
  document.getElementById("age").value = "";
}

loadUsers();
