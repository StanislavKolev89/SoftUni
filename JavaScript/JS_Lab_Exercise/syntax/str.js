function solve(str){
    let arr = str.toString().split("");
    let sum = arr.reduce((a,b)=>Number(a)+Number(b));
    for (let i = 1; i < arr.length; i++) {
        if(arr[i] != arr[0]){
            console.log("false");
            console.log(sum);
         
            return;
        }
    }
    console.log("true")
    console.log(sum);
   
}
solve(2222222)
solve(1234)