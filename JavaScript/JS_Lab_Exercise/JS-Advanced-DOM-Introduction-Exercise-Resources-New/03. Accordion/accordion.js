function toggle() {
  let buttonContent = document.getElementsByClassName('button')[0];
let contentToShow = document.getElementById('extra');

buttonContent.textContent = buttonContent.textContent ==='More'? 'Less': 'More';
contentToShow.style.display = contentToShow.style.display === 'none'? 'block' :'none';
}