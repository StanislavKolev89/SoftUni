function solve(array, n) {
    let newArr = [];
    for (let i = 0; i < array.length; i += n) {
        newArr.push(array[i]);
    }
    return newArr;
}

console.log(solve(['5',
    '20',
    '31',
    '4',
    '20'],
    2));
    console.log(solve(['dsa',
    'asd', 
    'test', 
    'tset'], 
    2));
    console.log(solve(['1', 
    '2',
    '3', 
    '4', 
    '5'], 
    6));