var originalTitle = document.title;
function showUnreadCount(unread) {
  document.title = originalTitle + "(" + unread + " New Messages!)";
}
showUnreadCount(3);
