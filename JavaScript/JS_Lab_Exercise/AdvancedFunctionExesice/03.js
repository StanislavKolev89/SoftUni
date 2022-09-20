function getFibonator(){
    let prev = 1;
    let cur = 0;

 return  function inner(){
       let result = prev+cur;
        prev = cur;
        cur = result;
        return cur;
    }

    return inner;
}

let fib = getFibonator();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13