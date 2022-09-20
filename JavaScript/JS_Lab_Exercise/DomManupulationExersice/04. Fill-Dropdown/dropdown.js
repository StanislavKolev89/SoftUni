function addItem() {
    let text = document.querySelector('input[type="text"][id="newItemText"]');
    let value = document.querySelector('input[type="text"][id="newItemValue"]');
    console.log(text.value, value.value);
    let menu = document.getElementById('menu');
    let option = document.createElement('option');
    option.textContent = text.value;
    option.value = value.value;
    menu.appendChild(option);


    text.value = '';
    value.value = '';
}