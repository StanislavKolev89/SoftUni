function solve(array, order) {
     order == 'asc' ? array.sort((a, b) => a - b) : array.sort((a, b) => b - a);
 return array
}

solve([14, 7, 17, 6, 8], 'desc');