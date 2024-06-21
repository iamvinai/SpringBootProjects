document.getElementById("resetForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission

    var username = document.getElementById("username").value;
    var oldPassword = document.getElementById("oldPassword").value;
    var newPassword = document.getElementById("newPassword").value;

    resetPassword(username, oldPassword, newPassword);
});

function resetPassword(username, oldPassword, newPassword) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/reset-password", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert(xhr.responseText);
            } else {
                alert("Error: " + xhr.statusText);
            }
        }
    };
    xhr.send("username=" + username + "&oldPassword=" + oldPassword + "&newPassword=" + newPassword);
}
