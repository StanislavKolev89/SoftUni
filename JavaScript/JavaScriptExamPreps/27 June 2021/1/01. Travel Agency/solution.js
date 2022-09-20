window.addEventListener('load', solution);

function solution() {
  let name = document.getElementById('fname');
  let email = document.getElementById('email');
  let phoneNumber = document.getElementById('phone');
  let address = document.getElementById('address');
  let postalCode = document.getElementById('code');

  let copyObj = {
    name1: name.value,
    email2: email.value,
    phoneNumber3: phoneNumber.value,
    address4: address.value,
    postalCode5: postalCode.value
  }

  let previewList = document.getElementById('infoPreview');

  let submitBTN = document.getElementById('submitBTN');
  submitBTN.addEventListener('click', fillPreviewList);
  let editBTN = document.getElementById('editBTN');

  let contBTN = document.getElementById('continueBTN');

  function fillPreviewList(e) {
    if (name.value != '' && email.value != '') {
      createData(previewList, name, email, phoneNumber, address, postalCode);

      submitBTN.disabled = true;
      editBTN.disabled = false;
      contBTN.disabled = false;
      editBTN.addEventListener('click', enable.bind(null, submitBTN, previewList, copyObj));
      contBTN.addEventListener('click', finishOrder)
    }
  }

  function createData(previewList, name, email, phoneNumber, adress, postalCode) {
    let nameField = document.createElement('li');
    nameField.textContent = 'Full Name: ' + name.value;
    let emailField = document.createElement('li');
    emailField.textContent = 'Email: ' + email.value;
    let phoneField = document.createElement('li');
    phoneField.textContent = 'Phone Number: ' + phoneNumber.value;
    let addressField = document.createElement('li');
    addressField.textContent = 'Address: ' + address.value;
    let postalField = document.createElement('li');
    postalField.textContent = `Postal Code: ${[postalCode.value]}`;

    previewList.appendChild(nameField);
    previewList.appendChild(emailField);
    previewList.appendChild(phoneField);
    previewList.appendChild(addressField);
    previewList.appendChild(postalField);

    name.value = '';
    email.value = '';
    phoneNumber.value = '';
    address.value = '';
    postalCode.value = '';
  }


  function enable(submitBTN, previewList, copyObj) {
    let arrayOfLis = Array.from(previewList.children);
    name.value = arrayOfLis[0].textContent.split(': ')[1];
    email.value = arrayOfLis[1].textContent.split(': ')[1];
    phoneNumber.value= arrayOfLis[2].textContent.split(': ')[1];
    address.value = arrayOfLis[3].textContent.split(': ')[1];
    postalCode.value= arrayOfLis[4].textContent.split(': ')[1];
    submitBTN.disabled = false;
    editBTN.disabled = true;
    contBTN.disabled = true;
    previewList.innerHTML = '';

  }

  function finishOrder() {
    let div = document.getElementById('block');
    div.innerHTML = '';
    let h3 = document.createElement('h3');
    h3.textContent = 'Thank you for your reservation!';
    div.appendChild(h3);
  }
}
