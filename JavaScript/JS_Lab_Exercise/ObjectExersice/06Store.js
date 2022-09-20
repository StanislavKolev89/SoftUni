function solve(inputArray){
    let objectMap = {};

for (let i = 0; i < inputArray.length; i++) {
    let[product,productPrice] = inputArray[i].split(" : ");
    let letter = product[0];
    if(!objectMap[letter]){
     objectMap[letter] = {}; 
     objectMap[letter][product] = Number( productPrice);
    }else{
        objectMap[letter][product] = Number( productPrice);
    }
}
    let sortedletters = Object.keys(objectMap).sort((a,b)=> a.localeCompare(b));
    for (const key of sortedletters) {
        let products = Object.entries(objectMap[key]).sort((a,b)=> a[0].localeCompare(b[0]));
        console.log(key);
        products.forEach((e)=> console.log(`  ${e[0]}: ${e[1]}`));
    }      
}

solve(['Appricot : 20.4',
'Fridge : 1500',
'TV : 1499',
'Deodorant : 10',
'Boiler : 300',
'Apple : 1.25',
'Anti-Bug Spray : 15',
'T-Shirt : 10']
)