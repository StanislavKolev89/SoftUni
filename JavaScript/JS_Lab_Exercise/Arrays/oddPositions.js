function solve(array) {
    let newArray = array.filter((v, i) => i % 2 == 1).map(e => e * 2).reverse();
    return newArray.join(' ');
}

solve([10, 15, 20, 25]);