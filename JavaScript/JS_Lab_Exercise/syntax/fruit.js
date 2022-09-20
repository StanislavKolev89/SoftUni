function solve(fruit, weigthInGrams, price) {
let math = doTheMath(weigthInGrams, price);
   
    printResult();
    function printResult() {
        console.log(`I need $${math.toFixed(2)} to buy ${(weigthInGrams / 1000).toFixed(2)} kilograms ${fruit}.`);
    }
    function doTheMath(weigthInGrams, price) {
        return weigthInGrams / 1000 * price;
    }
}

solve('orange', 2500, 1.80);
solve('apple', 1563, 2.35);