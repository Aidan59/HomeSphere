const wrap = document.getElementById("wrap");

const modal = document.getElementById("modal");
const modalCamera = document.getElementById("modal_camera")
const modalSensor = document.getElementById("modal_sensor")

const openModalBtn = document.getElementById("openModal");
const closeModalBtn = document.getElementById("close_button");

const cameraBtn = document.getElementById("camera_button");
const closeModalCamera = document.getElementById("close_button_camera")

const sensorBtn = document.getElementById("sensor_button");
const closeModalSensor = document.getElementById("close_button_sensor")


closeModalBtn.onclick = function() {
    modal.style.display = "none";
    modalCamera.style.display = "none";
    modalSensor.style.display = "none"

    wrap.style.display = "none";
}

openModalBtn.onclick = function() {
    wrap.style.display = "block";
    modal.style.display = "block";
}

cameraBtn.onclick = function() {
    modal.style.display = "none";
    modalCamera.style.display = "block";
}

closeModalCamera.onclick = function (){
    modalCamera.style.display = "none";
    wrap.style.display = "none";
}

sensorBtn.onclick = function() {
    modal.style.display = "none";
    modalSensor.style.display = "block";
}

closeModalSensor.onclick = function (){
    modalSensor.style.display = "none";
    wrap.style.display = "none";
}

