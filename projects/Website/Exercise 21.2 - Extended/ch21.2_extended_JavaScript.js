var originalTitle = document.title;
var userName = prompt("What is your name?");

function showUnreadCount(unread) {
  document.title = originalTitle + "(" + unread + " New Messages!)";
}

function changeHeaderBackground() {
  document.getElementById("header").style.background = "#ffffff";
}

function customizePage() {
  if (userName == null)
    while (userName == null) userName = prompt("What is your name?");
  document.title = userName;
  if (document.getElementById("userDiv") == null) {
    var userDiv = document.createElement("div");
    var userText = document.createTextNode(
      "Hello " +
        userName +
        " nice to meet you. This website was made just for you!!"
    );
    userDiv.appendChild(userText);
    userDiv.setAttribute("id", "userDiv");
    userDiv.style.color = "red";
    document.body.appendChild(userDiv);
  }
}
