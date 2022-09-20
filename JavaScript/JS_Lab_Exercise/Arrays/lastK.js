function solve(counts,k){
let newArray = [1];
for (let i = 1; i < counts; i++) {
    newArray.push(sum(newArray,k));
    
}

console.log(newArray);
function sum(array,k){
    let sum = 0;
    let index = array.length-k>0 ? array.length-k: 0;
    let arr = array.slice(index).reduce((a,b)=>a+b);
  
    return arr
}

}

solve(6,3);
solve(8,2);