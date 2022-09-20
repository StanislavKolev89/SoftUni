function solution() {
    let setOfproducts = fillSet();
    let microelements = new Map();
    return function manage(data) {

        let inputTokens = data.trim().split(' ');

        let message = '';
        let report = [];
        if (inputTokens.length == 1) {
            let protein = microelements.get('protein') == undefined ? 0 : microelements.get('protein');
            let fat = microelements.get('fat') == undefined ? 0 : microelements.get('fat');
            let flavour = microelements.get('flavour') == undefined ? 0 : microelements.get('flavour');
            let carb = microelements.get('carbohydrate') == undefined ? 0 : microelements.get('carbohydrate');

            return `protein=${protein} carbohydrate=${carb} fat=${fat} flavour=${flavour}`
        } else {
            let [command, element, number] = inputTokens;
            if (command == 'restock') {
                if (!microelements.has(element)) {
                    microelements.set(element, number);
                } else {
                    microelements.set(microelements.get(element) + number);
                }
                message = 'Success';
            } else if (command == 'prepare') {
                message = checkIfPossible(microelements, setOfproducts, element, number);
            }

        }



        return message;
    }

    function checkIfPossible(microelementsMap, setOfProducts, productName, numberofPlates) {
        for (let i = 0; i < numberofPlates; i++) {
            for (let objInSet of setOfProducts) {
                if (objInSet.name == productName) {
                    let counter = 0;
                    for (let property in objInSet) {
                        if (counter > 0) {
                            let value = objInSet[property];
                            if (!microelements.has(property)) {
                                return `Error: not enough ${property} in stock`;
                            } else {
                                let result = microelementsMap.get(property) - value;
                                if (result < 0) {
                                    return `Error: not enough ${property} in stock`;
                                } else {
                                    microelements.set(microelements.get(property) - result);
                                return `Success`;
                                }
                            }
                        }
                        counter++;
                    }
                }
            }
        }
       
    }

    function fillSet() {
        let set = new Set();

        set.add({
            name: 'apple',
            carbohydrate: 1,
            flavour: 2
        });
        set.add({
            name: 'lemonade',
            carbohydrate: 10,
            flavour: 20
        });
        set.add({
            name: 'burger',
            carbohydrate: 5,
            fat: 1,
            flavour: 1
        });
        set.add({
            name: 'eggs',
            protein: 5,
            fat: 1,
            flavour: 1
        });

        set.add({
            name: 'turkey',
            carbohydrate: 10,
            protein: 10,
            fat: 10,
            flavour: 10
        });
        return set;
    }



}



let manager = solution();
console.log(manager("restock flavour 50 "));
console.log(manager("prepare lemonade 4"));
console.log(manager("restock carbohydrate 10"));
console.log(manager("restock flavour 10"));
console.log(manager("prepare apple 1"));
console.log(manager("restock fat 10"));
console.log(manager("prepare burger 1"));
console.log(manager("report"));

// restock flavour 50 
// prepare lemonade 4 
// restock carbohydrate 10
// restock flavour 10
// prepare apple 1
// restock fat 10
// prepare burger 1
// report
