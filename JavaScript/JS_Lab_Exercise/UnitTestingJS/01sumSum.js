function sum(array, start, end) {

    if (!Array.isArray(array)) {
        return NaN;
    }

    for (const el of array) {
        if (typeof el !== 'number') {
            return NaN;
        }
        '♠'
    }
    let startIndex = start < 0 ? 0 : start;
    let endIndex = end > array.length - 1 ? array.length - 1 : end;
    return array.slice(startIndex, endIndex + 1).reduce((acc, el) => acc + el, 0);

}

console.log(sum([10, 20, 30, 40, 50, 60], 3, 300));
console.log(sum([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1));
console.log(sum([10, 'twenty', 30, 40], 0, 2));
console.log(sum([], 1, 2));
console.log(sum('text', 0, 2));