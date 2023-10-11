function validateInput(inputElem) {
    const notification = document.getElementById("notification");

    if (isNaN(inputElem.value)) {
        inputElem.classList.add("error");
        notification.style.display = "block";
    } else {
        inputElem.classList.remove("error");
        notification.style.display = "none";
    }
}