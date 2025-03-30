const container = document.getElementById("container");
const wrap = document.getElementById("wrap");

const modal = document.getElementById("modal");
const modalCamera = document.getElementById("modal_camera")
const modalSensor = document.getElementById("modal_sensor")

const openModalBtn = document.getElementById("openModal");
const closeModalBtn = document.getElementById("closeModal");

const cameraBtn = document.getElementById("camera_button");
const closeModalCameraBtn = document.getElementById("closeModalCamera");

const sensorBtn = document.getElementById("sensor_button");
const closeModalSensorBtn = document.getElementById("closeModalSensor");

openModalBtn.onclick = function() {
    wrap.style.display = "block";
    modal.style.display = "block";
}

closeModalBtn.onclick = function() {
    modal.style.display = "none";
    wrap.style.display = "none";
}

cameraBtn.onclick = function() {
    modal.style.display = "none";
    modalCamera.style.display = "block";
}

closeModalCameraBtn.onclick = function () {
    modalCamera.style.display = "none";
    wrap.style.display = "none"
}

sensorBtn.onclick = function() {
    modal.style.display = "none";
    modalSensor.style.display = "block";
}

closeModalSensorBtn.onclick = function (){
    modalSensor.style.display = "none";
    wrap.style.display = "none";
}