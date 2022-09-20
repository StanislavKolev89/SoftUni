function solve(inputArray){
    let objMap = {};
    for (let i = 0; i < inputArray.length; i++) {
    let [town, productName, productPrice] = inputArray[i].split(' | ');
        productPrice =Number(productPrice);
   
        if(!objMap.hasOwnProperty(productName)){
        objMap[productName] = {};
    }
        objMap[productName][town] = productPrice; 
    }

    for (const key in objMap) {
        let price= Object.values(objMap[key]).sort((a,b)=> a-b);
        let towns = Object.keys(objMap[key]).sort((a,b)=> a.localeCompare(b));
        console.log(`${key} -> ${price[0]} (${towns[0]})`);
    }

}
solve(['Sofia City | Audi | 100000',
'Sofia City | BMW | 100000',
'Sofia City | Mitsubishi | 10000',
'Sofia City | Mercedes | 10000',
'Sofia City | NoOffenseToCarLovers | 0',
'Mexico City | Audi | 1000',
'Mexico City | BMW | 99999',
'New York Cit | Mitsubishi | 10000',
'New York City | Mitsubishi | 1000',
'Mexico City | Audi | 100000',
'Washington City | Mercedes | 1000']);