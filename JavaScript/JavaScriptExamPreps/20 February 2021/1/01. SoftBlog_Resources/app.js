function solve() {
   let createBtn = document.getElementsByClassName('btn create')[0];
   createBtn.addEventListener('click', print);
   let postTable = document.querySelector('.site-content main section');
   let inputFields = Array.from(document.querySelectorAll('input'));



   function print(e) {
      e.preventDefault();


      let autorField = inputFields[0];
      let title = inputFields[1];
      let category = inputFields[2];
      let content = document.getElementsByTagName('textarea')[0];
      //Creating new Elements


      let articleSection = document.createElement('article');
      let h1 = document.createElement('h1');
      h1.textContent = title.value;

      let pCategory = document.createElement('p');
      pCategory.textContent = 'Category:';
      let strong = document.createElement('strong');
      strong.textContent = category.value;
      pCategory.appendChild(strong);

      let pCreator = document.createElement('p');
      pCreator.textContent = 'Creator:';
      let strong2 = document.createElement('strong');
      strong2.textContent = autorField.value;
      pCreator.appendChild(strong2);

      let pContent = document.createElement('p');
      pContent.textContent = content.value;

      let divButtons = document.createElement('div');
      divButtons.classList.add("buttons");

      let btnDelete = document.createElement('button');
      btnDelete.addEventListener('click', deleteContent.bind(null, articleSection));
      btnDelete.className = "btn delete";
      btnDelete.textContent = "Delete";

      let btnArchive = document.createElement('button');
      btnArchive.addEventListener('click', addToAchive.bind(null, postTable, articleSection));
      btnArchive.classList.add("btn", "archive");
      btnArchive.textContent = "Archive";
      divButtons.appendChild(btnDelete);

      divButtons.appendChild(btnArchive);


      articleSection.appendChild(h1);
      articleSection.appendChild(pCategory);
      articleSection.appendChild(pCreator);
      articleSection.appendChild(pContent);
      articleSection.appendChild(divButtons);

      postTable.appendChild(articleSection);

      autorField.value = '';
      title.value = '';
      category.value = '';
      content.value = '';

   }


   function deleteContent(articleSection) {
      articleSection.remove();
   }

   function addToAchive(e) {
      let articleToArchive = e.target.parentElement.parentElement;
      let archiveOl = document.querySelector('.archive-section ol');

      let archiveLis = Array.from(archiveOl.querySelectorAll('li'));
      let articleTitleHeading = articleToArchive.querySelector('h1');
      let articleTitle = articleTitleHeading.textContent;

      let newTitleLi = document.createElement('li');
      newTitleLi.textContent = articleTitle;
      

      articleToArchive.remove();

      archiveLis.push(newTitleLi);
   
      archiveLis.sort((a, b) => a.textContent.localeCompare(b.textContent)).forEach(li => ol.appendChild(li));

   }

}
