function solve() {
    let name = Array.from(document.getElementsByTagName('input'))[0];
    let age = Array.from(document.getElementsByTagName('input'))[1];
    let kind = Array.from(document.getElementsByTagName('input'))[2];
    let owner = Array.from(document.getElementsByTagName('input'))[3];

    let addBTN = document.querySelector('#container button');
    addBTN.addEventListener('click', movetoAdoption);

    function movetoAdoption(e) {
        e.preventDefault();

        let nameField = name.value;
        let ageField = Number(age.value);
        let kindField = kind.value;
        let ownerField = owner.value;
        if (nameField !== '' && ageField !== '' && kindField !== '' && ownerField !== '' && !Number.isNaN(ageField)) {

            let adoptionSection = document.querySelector('#adoption  ul');

            let pet = document.createElement('li');

            let p = document.createElement('p');
            let strongName = document.createElement('strong');
            strongName.textContent = nameField;
            let strongAge = document.createElement('strong');
            strongAge.textContent = ageField;
            let strongKind = document.createElement('strong');
            strongKind.textContent = kindField;

            p.appendChild(strongName);
            p.append(' is a ');
            p.appendChild(strongAge);
            p.append(' year old ')
            p.appendChild(strongKind);
            pet.appendChild(p);

            let span = document.createElement('span');
            let ownerData = ownerField;
            span.textContent = 'Owner: ' + ownerData;
            pet.appendChild(span);

            let button = document.createElement(`button`);
            button.textContent = 'Contact with owner';
            button.addEventListener('click', moveToAddopted);
            pet.appendChild(button);

            name.value = '';
            age.value = '';
            kind.value = '';
            owner.value = '';

            adoptionSection.appendChild(pet);

            function moveToAddopted() {
                let buttonToChange = pet.querySelector('button');

                let div = document.createElement('div');
                let input = document.createElement('input');
                input.placeholder = 'Enter your names';
                div.appendChild(input);
                buttonToChange.textContent = 'Yes! I take it';
                buttonToChange.addEventListener('click', movingToNewPetSection.bind(null, pet, input));
                div.appendChild(button);
                pet.appendChild(div);

            }
        }
    }



    function movingToNewPetSection(pet, inputData) {
        let data = inputData.value.trim();
        let finalSection = document.querySelector('#adopted ul');
        if (data == '') {
            return;
        }

        pet.querySelector('span').textContent = 'New Owner: ' + data;
        const checkBtn = document.createElement('button');
        checkBtn.textContent = 'Checked';
        checkBtn.addEventListener("click", check.bind(null, pet));
        pet.querySelector('div').remove();

        pet.appendChild(checkBtn);
       
        finalSection.appendChild(pet);


    }

    function deleteData(pet) {
        pet.remove();
    }

}

