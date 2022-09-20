function solve() {
    let OnScreenBtn = document.querySelector('#container button');

    OnScreenBtn.addEventListener('click', addMoviesToScreen);

    let tableofMovies = document.querySelector('#movies >ul');

    function addMoviesToScreen(event) {
        event.preventDefault();

        let nameMovie = document.querySelectorAll('#container input');

        let name = nameMovie[0].value;
        let hall = nameMovie[1].value;
        let price = nameMovie[2].value;
        if (name.trim() !== '' && hall.trim() !== ''
            && price.trim() !== '' && !isNaN(price)) {

            let liElement = document.createElement('li');

            let spanEl = document.createElement('span');
            spanEl.textContent = name;
            liElement.appendChild(spanEl);

            let strongEl = document.createElement('strong');
            strongEl.textContent = `Hall: ${hall}`;
            liElement.appendChild(strongEl);

            let rightDivEl = document.createElement('div');

            let strongElTwo = document.createElement('strong');
            strongElTwo.textContent = `${Number(price).toFixed(2)}`;
            rightDivEl.appendChild(strongElTwo);
            let inputEl = document.createElement('input');
            inputEl.setAttribute('placeholder', 'Tickets Sold');
            rightDivEl.appendChild(inputEl);

            let archiveBtn = document.createElement('button');
            archiveBtn.textContent = 'Archive';
            archiveBtn.addEventListener('click', addtoArchive);
            rightDivEl.appendChild(archiveBtn);
            liElement.appendChild(rightDivEl);
            tableofMovies.appendChild(liElement);

            nameMovie[0].value = '';
            nameMovie[1].value = '';
            nameMovie[2].value = '';

        }
    }
    function addtoArchive(e) {
        let archiveSection = document.querySelector('#archive >ul')

        let row = e.target.parentElement.parentElement;

        let ticketsSoldInput = row.querySelector('div input');
        let numberOftickets = ticketsSoldInput.value;

        if (!isNaN(Number(numberOftickets)) && numberOftickets.trim() !== '') {
            numberOftickets = Number(numberOftickets);
            let priceStrongField = row.querySelector('div strong');
            let price = Number(priceStrongField.textContent);

            let li = document.createElement('li');
            let span = document.createElement('span');

            span.textContent = row.querySelector('span').textContent;
            li.appendChild(span);

            let strong = document.createElement('strong');
            strong.textContent = `Total amount: ${(price * numberOftickets).toFixed(2)}`;
            li.appendChild(strong);

            let button = document.createElement('button');
            button.textContent = 'Delete';
            button.addEventListener('click', deleteData);
            li.appendChild(button);
            archiveSection.appendChild(li);
            row.remove();
        }
    }

    function deleteData(e) {
        let li = e.target.parentElement;
        li.remove();
    }

    let clearBtn = document.querySelector('#archive button');

    clearBtn.addEventListener('click', clearArchive);

    function clearArchive(e) {
        let archiveSec = Array.from(document.querySelectorAll('#archive >ul li'));
        archiveSec.forEach(e => e.remove());

    }
}