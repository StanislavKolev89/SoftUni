function attachEventsListeners() {
    let inputFields = Array.from(document.querySelectorAll('input[type="text"]'));

    let daysConverter = document.getElementById('daysBtn');
    let hoursConverter = document.getElementById('hoursBtn');
    let minutesConverter = document.getElementById('minutesBtn');
    let secondsConverter = document.getElementById('secondsBtn');

    daysConverter.addEventListener('click', convertData);
    hoursConverter.addEventListener('click', convertData);
    minutesConverter.addEventListener('click', convertData);
    secondsConverter.addEventListener('click', convertData);

    let values = {
        days: 1,
        hours: 24,
        minutes: 1440,
        seconds: 86400
    }

    function convertedToDays(amount, unitId) {
        let day = amount / values[unitId];
        let obj = {
            0: day,
            1: day * 24,
            2: day * 1440,
            3: day * 86400
        }
        for (let i = 0; i < inputFields.length; i++) {
            inputFields[i].value = obj[i];
        }
    }

    function convertData(e) {
        let unitId = e.target.parentNode.children[1].id;
        let amount = Number(e.target.parentNode.children[1].value);
        convertedToDays(amount, unitId);
    }
}