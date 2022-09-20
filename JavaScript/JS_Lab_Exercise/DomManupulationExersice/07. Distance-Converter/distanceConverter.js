function attachEventsListeners() {
    let inputField = document.querySelectorAll('input[type = "text"][id = "inputDistance"]')[0];
    let outputField = document.querySelectorAll('input[type = "text"][id = "outputDistance"]')[0];

    let inputUnit = document.getElementById('inputUnits');
    let outputUnit = document.getElementById('outputUnits');
    document.querySelector('input[type="button"][id="convert"]').addEventListener('click', convert);


    function convert(e) {
        let distanceFromInput = inputField.value;
        let fromUnit = inputUnit.value;
        let toUnit = outputUnit.value;
        outputField.value = convertedToKm(distanceFromInput,fromUnit,toUnit);
    }

    let distances = {
        km: 1,
        m: 1000,
        cm: 100000,
        mm: 1000000,
        mi: 0.621371,
        yrd: 1093.61,
        ft: 3280.84,
        in: 39370.1
    }

    function convertedToKm(distance, fromUnit,toUnit) {
        let km = distance / distances[fromUnit];
        let obj = {
            km: km * 1,
            m: km * 1000,
            cm: km * 100000,
            mm: km * 10000000,
            mi: km * 0.621371,
            yrd: km * 1093.61,
            ft: km * 3280.84,
            in: km * 39370.1
        }
        return obj[toUnit];
    }
}