function solve(array) {
    let ellement = array.shift();
    let newArray = [];
    newArray.push(ellement);
    for (let i = 0; i < array.length; i++) {
        if (ellement <= array[i]) {
            newArray.push(array[i]);
            ellement = array[i];
        }

    }
    return newArray;
}

solve([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24]);

solve([20,
    3,
    2,
    15,
    6,
    1]);


console.log(solve([1, 2, 3, 4, 5, 6, 7, 6, 3, 1, 3, 4, 12, 51, 1]));