var clicks = 0;

function callClicks() {
    clicks = parseInt(localStorage.getItem("actualClicks"), 10) || 0;
    document.getElementById("clicks").innerHTML = clicks;
}

function onClick() {
    clicks += 1;
    document.getElementById("clicks").innerHTML = clicks;
    saveClicks();
};

function saveClicks() {
    localStorage.setItem("actualClicks", clicks);
};

function trash() {
    clicks = -1;
    document.getElementById("clicks").innerHTML = clicks;
}

function cleanLocalStorage() {
    localStorage.clear();
}

callClicks(); // Kind of like your onload="datenAbrufen()"