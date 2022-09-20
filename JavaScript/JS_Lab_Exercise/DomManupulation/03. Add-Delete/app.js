function addItem() {
    let list = document.getElementById('items');
    let inputField = document.getElementById('newItemText');
    let inputData = inputField.value;
    let liElement = document.createElement('li');
    liElement.textContent = inputData;
    let button = document.createElement('a');
    button.textContent = '[Delete]';
    button.href = '#';
    liElement.appendChild(button);
    button.addEventListener('click', ()=> liElement.remove());
    list.appendChild(liElement);

    inputField = '';
}