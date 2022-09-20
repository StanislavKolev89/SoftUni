function validate() {
let inputfield = document.getElementById('email');
let regex = /^[a-z]+@[a-z]+.[a-z]+$/
inputfield.addEventListener('change',validateEmail);
inputfield.style.bordercolor = 'red';

function validateEmail(e){
    if(regex.test(inputfield.value)){
       inputfield.classList.remove('error')
    }else{
        inputfield.classList.add('error');
    }
}
}