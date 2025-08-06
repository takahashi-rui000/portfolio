const images = document.querySelectorAll('img');
const modal = document.getElementById("modal");
const modalImage = document.getElementById('modalImage');
const btn = document.getElementById("openModal");
const closeBtn = document.querySelector(".close");

images.forEach(element => {
    element.addEventListener('click', () => {
        modalImage.src = element.src;
        modal.style.display = "flex";
    });
});

closeBtn.addEventListener("click", () => {
  modal.style.display = "none";
});

window.addEventListener("click", (e) => {
  if (e.target === modal) {
    modal.style.display = "none";
  }
});