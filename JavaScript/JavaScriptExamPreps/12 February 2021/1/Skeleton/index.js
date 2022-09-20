function solve() {
  let dateField = document.querySelector('input[type="datetime-local"]');
  let moduleFieldData = document.querySelector('select[name="lecture-module"]');
  let lectureField = document.querySelector('input[type="text"]');
  let addBtn = document.querySelector('.form-control button');
addBtn.addEventListener('click', showData);


function showData(e){
    e.preventDefault();
    if(dateField.value !=='' && moduleFieldData.value !=='Select module' && lectureField.value !==''){

        let divModules = document.getElementsByClassName('modules')[0];
        let moduleFormated = `${moduleFieldData.value.toUpperCase()}-MODULE`;
        let filtered = Array.from(divModules.querySelectorAll('.module h3')).map(e=>e.textContent);
        

        let newDiv = document.createElement('div');
        
        if(!filtered.includes(moduleFormated)){
            newDiv.classList.add('module');
        let h3inNewDiv = document.createElement('h3');
        h3inNewDiv.textContent = `${moduleFieldData.value.toUpperCase()}-MODULE`;
        newDiv.appendChild(h3inNewDiv);

        let ulinNewDiv = document.createElement('ul');

        let liInUl = document.createElement('li');
        liInUl.classList.add('flex');

        let h4 = document.createElement('h4');
        let[date,hour] = dateField.value.split('T');
        date = replacingCharacter(date);
        
        let str = `${lectureField.value} - ${date} - ${hour}`;
        h4.textContent = str;
        liInUl.appendChild(h4);
       
        let buttonDelete = document.createElement('button');
        buttonDelete.classList.add('red');
        buttonDelete.textContent = 'Del';
        buttonDelete.addEventListener('click', deleteData);
        liInUl.appendChild(buttonDelete);
        ulinNewDiv.appendChild(liInUl);
        newDiv.appendChild(ulinNewDiv);

        }else{
            
            let arr= Array.from(divModules.querySelectorAll('.module h3'));

            arr = arr.filter(e=> e.textContent == moduleFormated)[0];
            let ulToAppendTo = arr.parentElement.querySelector('ul');

            let liInUl = document.createElement('li');
            liInUl.classList.add('flex');
    
            let h4 = document.createElement('h4');
            let[date,hour] = dateField.value.split('T');
        
            date = replacingCharacter(date);
            let str = `${lectureField.value} - ${date} - ${hour}`;
            h4.textContent = str;
            liInUl.appendChild(h4);
           
            let buttonDelete = document.createElement('button');
            buttonDelete.classList.add('red');
            buttonDelete.textContent = 'Del';
            buttonDelete.addEventListener('click', deleteData);
            liInUl.appendChild(buttonDelete);

            ulToAppendTo.appendChild(liInUl);

            let arrayOfLis = Array.from(ulToAppendTo.querySelectorAll('li'));

            arrayOfLis.sort((a,b)=>a.querySelector('h4').textContent.localeCompare(b.querySelector('h4').textContent)).
            forEach(li => ulToAppendTo.appendChild(li));
        }

        dateField.value = '';
        moduleFieldData.value ='Select module';
        lectureField.value = '';
        divModules.appendChild(newDiv);
        
    
      
    }

}
    function replacingCharacter(str){
        let array = str.split('');
        let newStr = '';
    
        for (let i = 0; i < array.length; i++) {
        let element = array[i];
            if(element=='-'){
                element = '/';
            }
            newStr+=element;
        }
        return newStr.trim();
    }

    function deleteData(e){
        let arrayOfLis = Array.from(e.target.parentElement.parentElement.querySelectorAll('li'));
        if(arrayOfLis.length>1){

            let liToDelete = e.target.parentElement;
            liToDelete.remove();
        }else{
            e.target.parentElement.parentElement.parentElement.remove();
        }
  

        }
     
    }
