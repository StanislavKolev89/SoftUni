function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      let searched = document.getElementById('searchField');
      let data = Array.from(document.querySelectorAll('tbody tr'));
      let seachedText = searched.value.toLowerCase();
      searched.value = '';


      data.forEach(element => {
         element.className = '';
      });


      data.filter(el => el.textContent.toLowerCase().includes(seachedText)).forEach(x => x.className = 'select');
      searched.value = '';
   }
}