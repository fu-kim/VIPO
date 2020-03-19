var canvas = document.getElementById("canvas"),
    context = canvas.getContext("2d"),
    startButton = document.getElementById("startButton"),
    glasspane = document.getElementById("glasspane"),
    paused = false;

startButton.onclick = function (e) {
    e.preventDefault();
    paused = !paused;
    startButton.innerHTML = paused ? "start" : "stop";

}

glasspane.onmousedown = function (e) {
    e.preventDefault();
}

function drawCanvas() {

    context.beginPath();
    context.fillStyle="#666666";
    context.fillRect(0,0,300,300);
    context.stroke();
}


draw = drawCanvas();