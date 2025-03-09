const container = document.getElementById("container");
const wrap = document.getElementById("wrap");
const modal = document.getElementById("modal");
const openModalBtn = document.getElementById("openModal");
const closeModalBtn = document.getElementById("closeModal");

openModalBtn.onclick = function() {
    wrap.style.display = "block";
    modal.style.display = "block";
}

closeModalBtn.onclick = function() {
    modal.style.display = "none";
    wrap.style.display = "none";
}
