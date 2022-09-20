function solve(array) {
    let notEnoughOperands = false;
    let arrayOfNumbers = [];
    for (let i = 0; i < array.length; i++) {
        const element = array[i];
        if (typeof element === 'number') {
            arrayOfNumbers.push(element);
        } else {
            if (arrayOfNumbers.length > 1) {
                let result = calculate(arrayOfNumbers.splice(-2), element);
                arrayOfNumbers.push(result);
            } else {
                notEnoughOperands = true;
                break;
            }
        }
    }

    if (notEnoughOperands) {
        console.log(`Error: not enough operands!`);
    }else if (arrayOfNumbers.length > 1) {
        console.log(`Error: too many operands!`);
    } else {
        console.log(arrayOfNumbers[0]);
    }
    function calculate(array, operator) {
        if (operator == '+') {
            return array[0] + array[1];
        } else if (operator == '-') {
            return array[0] - array[1];
        } else if (operator == '*') {
            return array[0] * array[1];
        } else if (operator == '/') {
            return array[0] / array[1];
        }
    }
}

solve([5,
    3,
    4,
    '*',
    '-']);