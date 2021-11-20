window.updateCount = function() {
    var x = $(".checkbox:checked").length;
    document.getElementById("y").innerHTML = x;
};