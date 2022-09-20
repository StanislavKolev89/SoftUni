function solve(array){
    let newArray = array.sort((a,b)=> a-b).slice(array.length/2);
    return newArray;
}

console.log(solve([4, 7, 2, 5]));
console.log(solve([3, 19, 14, 7, 2, 19, 6]));