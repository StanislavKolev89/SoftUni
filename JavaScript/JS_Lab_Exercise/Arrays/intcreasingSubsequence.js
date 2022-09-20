function solve(array) {
let newArray = [];
newArray.push(array.shift());

for (let i = 0; i < array.length; i++) {
    const element = array[i];
    if(element>=newArray[newArray.length-1]){
        newArray.push(element);
    } 
}
console.log(newArray);

}
solve([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24])
    solve([20, 
        3, 
        2, 
        15,
        6, 
        1]);