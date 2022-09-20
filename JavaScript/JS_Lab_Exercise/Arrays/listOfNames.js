function solve( array){
array.sort((a,b)=>a.localeCompare(b));
let counter = 1;
array.forEach(element => {
    console.log(`${counter++}.${element}`);
});

}
solve(["John", "Bob", "Christina", "Ema"])