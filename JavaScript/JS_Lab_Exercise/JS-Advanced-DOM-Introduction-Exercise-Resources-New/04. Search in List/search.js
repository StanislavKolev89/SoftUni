function search() {
   let searched = document.getElementById('searchText');
   let listOfTowns = Array.from(document.querySelectorAll('#towns li'));

   let searchedText = searched.value;
   //clear result from previous search

   listOfTowns.forEach(el => {
      el.style.fontWeight = 'normal';
      el.style.textDecoration = 'none';
   });
   //filter all li's which include text
   //underline and bold
   let counter = 0;
   let result = listOfTowns.filter(el => el.textContent.includes(searchedText)).forEach(x => {
      x.style.fontWeight = 'bold';
      x.style.textDecoration = 'underline';
      counter++;
   });
   //show result ind div"result";
   document.getElementById('result').textContent = `${counter} matches found`;
}

