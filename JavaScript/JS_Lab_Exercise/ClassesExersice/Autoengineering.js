function solve(array) {
    // "{carBrand} | {carModel} | {producedCars}"
    let brandsMap = new Map();

    for (const input of array) {
        let [carBrand, carModel, producedCars] = input.split(' | ');
        producedCars = Number(producedCars);
        if (!brandsMap.has(carBrand)) {
            brandsMap.set(carBrand, new Map());
        }

        if (!brandsMap.get(carBrand).has(carModel)) {
            brandsMap.get(carBrand).set(carModel, producedCars);
        } else {
            brandsMap.get(carBrand).set(carModel, brandsMap.get(carBrand).get(carModel) + producedCars);
        }
    }

   for (const [carbrand, Map] of brandsMap) {
        console.log(carbrand);
        for (const [carModel, producedCars] of Map) {
            console.log(`###${carModel} -> ${producedCars}`)
            
        }
   }

}

solve(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']);