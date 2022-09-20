function solve(arrayInput){
    let arrayOfObjects = []

    for (let i = 0; i < arrayInput.length; i++) {
        let[name, level, items] = arrayInput[i].split(' / ');
       items = items.length>0? items.split(', ') : [];
        arrayOfObjects.push({name,level,items});
    
    }
    console.log(JSON.stringify(arrayOfObjects);
    
}

solve(['Isacc / 25 / Apple, GravityGun',
'Derek / 12 / BarrelVest, DestructionSword',
'Hes / 1 / Desolator, Sentinel, Antara'])