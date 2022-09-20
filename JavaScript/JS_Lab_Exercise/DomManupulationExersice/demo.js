function counter(){

let button =document.getElementById('counter');

button.addEventListener('click', changeContent);


function changeContent(e){
    let value = e.target;
    let currrentValue = Number(value.textContent);
    
    value.textContent= ++currrentValue;

}
}