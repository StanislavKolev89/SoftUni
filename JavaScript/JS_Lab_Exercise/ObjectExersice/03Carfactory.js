function solve(obj) {
    let ListOfEngines = {
        "Small engine": { power: 90, volume: 1800 },
        "Normal engine": { power: 120, volume: 2400 },
        "Monster engine": { power: 200, volume: 3500 }
    };

    let newObj = {};
    let objectToCollectFrom = Object.assign({}, obj);

    newObj.model = objectToCollectFrom.model;
    newObj.engine = findProperVolume(objectToCollectFrom.power, ListOfEngines);
    newObj.carriage = { type: objectToCollectFrom.carriage, color: objectToCollectFrom.color };
    newObj.wheels = fillingArray(objectToCollectFrom.wheelsize);

    return newObj;
    function fillingArray(number) {
        if (number % 2 == 0) {
            number--;
        }
        return [number, number, number, number];
    }
    function findProperVolume(power, engines) {
        if (power <= 90) {
            return engines["Small engine"];
        } else if (power <= 120) {
            return engines["Normal engine"];
        } else {
            return engines["Monster engine"]
        }
    }
}

console.log(solve({
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
}));

console.log(solve({
    model: 'Opel Vectra',
    power: 110,
    color: 'grey',
    carriage: 'coupe',
    wheelsize: 17
}));