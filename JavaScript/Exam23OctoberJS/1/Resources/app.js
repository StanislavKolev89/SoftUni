window.addEventListener('load', solve);

function solve() {

    let genre = document.getElementById('genre');
    let name = document.getElementById('name');
    let author = document.getElementById('author');
    let date = document.getElementById('date');
    let addBTN = document.getElementById('add-btn');

    let collectionOfSongs = document.querySelector('div .all-hits-container');
    let savedSongs = document.querySelector('div .saved-container');
    addBTN.addEventListener('click', moveToCollectionOfSongs);


    function moveToCollectionOfSongs(e) {
        e.preventDefault();
        if (genre.value == '' || name.value == '' || author == '' || date == '') {
            return;
        }

        let div = document.createElement('div');
        div.classList.add('hits-info');

        let img = document.createElement('img');
        img.src = './static/img/img.png';
        div.appendChild(img);
        let h2Genre = document.createElement('h2');
        h2Genre.textContent = `Genre: ${genre.value}`;
        div.appendChild(h2Genre);
        let h2Name = document.createElement('h2');
        h2Name.textContent = `Name: ${name.value}`;
        div.appendChild(h2Name);
        let h2Author = document.createElement('h2');
        h2Author.textContent = `Author: ${author.value}`;
        div.appendChild(h2Author);
        let h3Date = document.createElement('h3');
        h3Date.textContent = `Date: ${date.value}`;
        div.appendChild(h3Date);
        let saveBtn = document.createElement('button');
        saveBtn.classList.add('save-btn');
        saveBtn.textContent = 'Save song';
        saveBtn.addEventListener('click', moveToSavedSongs);
        div.appendChild(saveBtn);
        let likeBtn = document.createElement('button');
        likeBtn.classList.add('like-btn');
        likeBtn.textContent = 'Like song';
        likeBtn.addEventListener('click', changeTotalLikes);
        div.appendChild(likeBtn);
        let delBtn = document.createElement('button');
        delBtn.classList.add('delete-btn');
        delBtn.textContent = 'Delete';
        delBtn.addEventListener('click', removeTheDiv);
        div.appendChild(delBtn);

        genre.value='';
        name.value='';
        author.value = '';
        date.value = '';

        collectionOfSongs.appendChild(div);

        function moveToSavedSongs() {
               let buttons = Array.from(div.querySelectorAll('button'));
               buttons[0].remove();
               buttons[1].remove();
                savedSongs.appendChild(div);
        }

    }

    function changeTotalLikes(e) {
        let totalLikedParagraph = document.querySelector('.likes p');
        let string = totalLikedParagraph.textContent;
        let value = Number(string.split(' ')[2]);
        value++;
        totalLikedParagraph.textContent = `Total Likes: ${value.toString()}`;
        e.target.disabled = true;
    }

    function removeTheDiv(e) {
        e.target.parentElement.remove();
    }
}