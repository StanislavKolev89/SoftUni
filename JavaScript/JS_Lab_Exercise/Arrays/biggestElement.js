function solve(matrix){
    let max = Number.MIN_VALUE;
    for (let row = 0;row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            let el = matrix[row][col];
            if(el>max){
                max = el;
            }
        }
    }
    return max;
}

console.log(solve([[20, 50, 10],
    [8, 33, 252]]));