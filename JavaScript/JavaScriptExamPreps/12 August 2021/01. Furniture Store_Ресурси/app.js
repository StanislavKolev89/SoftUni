window.addEventListener('load', solve);

function solve() {

    const modelField = document.getElementById('model');
    const yearField = document.getElementById('year');
    const descField = document.getElementById('description');
    const priceField = document.getElementById('price');

    const addBtn = document.getElementById('add');
    addBtn.addEventListener('click', writeMsg);


    const totalPriceField = document.getElementsByClassName('total-price')[0];



    function writeMsg(e) {
        e.preventDefault();
        if (modelField.value == '' || yearField.value == '' || yearField.value == '' || priceField.value == ''
            || Number.isNaN(Number(yearField.value)) || Number.isNaN(Number(priceField.value)) ||
            (Number(yearField.value) < 0) || (Number(priceField.value) < 0)) {
            return;
        }

        const furnitureList = document.getElementById('furniture-list');

        const mainTr = document.createElement('tr');
        mainTr.className = 'info';

        const furnitureTd = document.createElement('td');
        furnitureTd.textContent = modelField.value;

        const priceTd = document.createElement('td');
        let str = `${Number(priceField.value).toFixed(2)}`;
        priceTd.textContent = str;

        const buttonsFieldTd = document.createElement('td');

        const moreInfroBtn = document.createElement('button');

        moreInfroBtn.className = 'moreBtn';
        moreInfroBtn.textContent = 'More Info';
        const buyBtn = document.createElement('button');
        buyBtn.className = "buyBtn";
        buyBtn.textContent = 'Buy It';

        mainTr.appendChild(furnitureTd);
        mainTr.appendChild(priceTd);
        mainTr.appendChild(buttonsFieldTd);

        buttonsFieldTd.appendChild(moreInfroBtn);
        buttonsFieldTd.appendChild(buyBtn);
      
        const secondaryTr = document.createElement('tr');
        secondaryTr.className = "hide";
        const yearTd = document.createElement('td');
        yearTd.textContent = `Year: ${yearField.value}`;

        const descTd = document.createElement('td');
        descTd.textContent = `Description: ${descField.value}`;
        descTd.colSpan = "3";

        secondaryTr.appendChild(yearTd);
        secondaryTr.appendChild(descTd);

        furnitureList.appendChild(mainTr);
        furnitureList.appendChild(secondaryTr);

        moreInfroBtn.addEventListener('click', showMoreInfo.bind(null,moreInfroBtn,secondaryTr));
        buyBtn.addEventListener('click', calculateTotal.bind(null,mainTr,totalPriceField,priceTd));

        modelField.value = '';
        yearField.value = '';
        descField.value = ''
        priceField.value = '';


    }


    function showMoreInfo(moreInfroBtn,secondaryTr){
        if(moreInfroBtn.textContent =='More Info'){
    moreInfroBtn.textContent = 'Less Info';
    secondaryTr.style.display='contents';
         } else if(moreInfroBtn.textContent =='Less Info'){
            moreInfroBtn.textContent = 'More Info';
            secondaryTr.style.display='none';
    }

    }



    function calculateTotal(maintTr,totalPriceField,priceTd){
        let currentValue = Number(totalPriceField.textContent);
        currentValue += Number(priceTd.textContent);
            totalPriceField.textContent = currentValue.toFixed(2);
            maintTr.remove();
    }


}
