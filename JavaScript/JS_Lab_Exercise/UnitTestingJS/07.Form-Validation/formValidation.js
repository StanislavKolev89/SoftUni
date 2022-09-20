function validate() {
    let submitBtn = document.getElementById('submit');
    submitBtn.addEventListener('click', validateInfo);
    let isCompanyChecked = document.getElementById('company');
    isCompanyChecked.addEventListener('click', onIsCompanyHandler);
    function validateInfo(e) {
        e.preventDefault();
        let username = document.getElementById('username');
        let email = document.getElementById('email');
        let password = document.getElementById('password');
        let confPassword = document.getElementById('confirm-password');

        let usernameReg = /^[A-Za-z0-9]{3,20}$/;
        let userValidation = usernameReg.test(username.value);
        setStyle(userValidation, username);
        let emailReg = /^.*@.*\..*$/;
        let emailValidation = emailReg.test(email.value);
        setStyle(emailValidation, email);
        let passwordReg = /^\w{5,15}$/;
        let passwordValidation = passwordReg.test(password.value);
        let confPasswordValidation = passwordReg.test(confPassword.value);

        setStyle((passwordValidation && password.value === confPassword.value), password);
        setStyle((confPasswordValidation && password.value === confPassword.value), confPassword);

        let companyNumberFieldCorrect = false;
        let companyNumberField = document.getElementById('companyNumber');
        if (isCompanyChecked.checked) {
            // companyNumberField.addEventListener('change', checkforValidNumber);
            let numberField = companyNumberField.value;
            if (!isNaN(numberField) || numberField.trim() !== '') {
                let number = Number(numberField);
                if (number >= 1000 && number < 10000) {
                    setStyle(true, companyNumberField);
                    companyNumberFieldCorrect = true;
                } else {
                    setStyle(false, companyNumberField);
                }
            }
        }

        let hiddenDiv = document.getElementById('valid');
        let mainValidation = userValidation && emailValidation && passwordValidation && confPasswordValidation;

        if (mainValidation && isCompanyChecked.checked) {
            if (companyNumberFieldCorrect) {
                hiddenDiv.style.display = 'block';
            }
        } else if (mainValidation) {

            hiddenDiv.style.display = 'block';
        }
    }
    function setStyle(isValid, element) {
        if (isValid) {
            element.style.borderColor = 'none';
        } else {
            element.style.borderColor = 'red';
        }
    }

    function onIsCompanyHandler(e) {
        let companyField = document.getElementById('companyInfo');
        companyField.style.display = e.target.checked ? 'block' : 'none';
    }
}
