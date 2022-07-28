
const categoryOption = document.getElementById('categoryOption');


categoryOption.addEventListener('change', filterByCategory)


function filterByCategory() {
  for (const div of document.getElementsByClassName('filter')) {
    div.parentElement.style.display='block';
  };

  for (const div of document.getElementsByClassName('filter')) {
    if(div.id!=categoryOption.value){
      div.parentElement.style.display='none';
    }
  };
}