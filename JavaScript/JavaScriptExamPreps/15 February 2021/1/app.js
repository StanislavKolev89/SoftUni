function solution() {

    let boxes = Array.from(document.querySelectorAll('.card'));
    let addGifts = boxes[0];
    let listOfGifts = boxes[1];
    let sentGifts = boxes[2];
    let discardGifts = boxes[3];


    let inputField = document.querySelector('input[type="text"]');

    let BtN = document.querySelector('button');
    BtN.addEventListener('click', addToListOfGifts);

    function addToListOfGifts(e) {
        let fieldToAppent = listOfGifts.querySelector('ul');
        let text = inputField.value;
        let li = document.createElement('li');
        li.textContent = text;
        li.class = "gift";
        let sendBTN = document.createElement('button');
        sendBTN.id = 'sendButton';
        sendBTN.textContent = 'Send';

        let discardBTN = document.createElement('button');
        discardBTN.id = 'discardButton';
        discardBTN.textContent = 'Discard';

        li.appendChild(sendBTN);
        li.appendChild(discardBTN);
        sendBTN.addEventListener('click', sendData.bind(null, text, li, sentGifts));
        discardBTN.addEventListener('click', discardData.bind(null, text, li, discardGifts));
        inputField.value = '';
        
        fieldToAppent.appendChild(li);
        let arrayOfLis = Array.from(fieldToAppent.children);
        arrayOfLis.sort((a, b) => a.textContent.localeCompare(b.textContent)).forEach(e => fieldToAppent.appendChild(e));
    }

    function sendData(text, liToRemove, sentGifts) {
        let ul = sentGifts.querySelector('ul');
        let li = document.createElement('li');
        liToRemove.remove();
        li.textContent = text;
        li.className = 'gift';
        ul.appendChild(li);
    };


    function discardData(text, liToRemove, sentGifts) {
        let ul = discardGifts.querySelector('ul');
        let li = document.createElement('li');
        liToRemove.remove();
        li.textContent = text;
        li.className = 'gift';
        ul.appendChild(li);
    };
}