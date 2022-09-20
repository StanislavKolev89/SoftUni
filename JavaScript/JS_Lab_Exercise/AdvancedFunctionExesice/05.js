function add(num) {
    let sum = 0;
    
    function inner(number) {
        sum += number;
        console.log(sum);
        return inner;
    }

    inner.valueOf =() => {
        return sum;
    }
    return inner(num);
}

let a = add(1);
let b = a(6);
let c = b(-3);
// let addd = add(1)(6)(-3);
// console.log(addd.valueOf());