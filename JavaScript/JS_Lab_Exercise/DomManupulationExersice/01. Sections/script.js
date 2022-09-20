function create(words) {

   // document.addEventListener('click', showContent);
   let output = document.getElementById('content');
   output.addEventListener('click', showContent);
   words.forEach(element => {
      let div = document.createElement('div');
      let p = document.createElement('p');
      p.textContent = element;
      p.style.display = 'none';

      div.appendChild(p);
      output.appendChild(div);

   });

   function showContent(e) {
      if (e.target.tagName == 'DIV'&&  e.target != output) {
         e.target.children[0].style.display = '';
      }
   }

}