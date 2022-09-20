function solve(arr){
let assocArr = {};

for(let data of arr){
    let key = data.split(" ")[0];
    let value = Number(data.split(" ")[1]);
    assocArr[key] = value;
}

// let convertedArray = Object.entries(assocArr).sort((a,b)=>{
//     let nameA = a[0];
//     let nameB = b[0];
   
//    return nameA.localeCompare(nameB)});

let conv = Object.entries(assocArr).sort(returnOne);
for(let[name,number] of conv){
    console.log(`${name} -> ${number}`);
}

function returnOne(){
    return 5;
}

}

let input = ['Tim 0834212554',
'Peter 0877547887',
'Bill 0896543112',
'Tim 0876566344'];


solve(input);