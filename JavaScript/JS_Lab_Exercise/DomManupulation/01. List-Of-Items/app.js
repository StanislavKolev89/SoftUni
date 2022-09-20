function addItem() {
   let input = document.getElementById('newItemText');

   let text = input.value;
   let newElement = document.createElement('li');
   newElement.textContent = text;
   let list = document.getElementById('items');
   list.appendChild(newElement);
   console.log(list.textContent);
}