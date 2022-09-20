function solve(matrix) {
    let firstSum = 0;
    let secondSum = 0;

    for (let row = 0; row < matrix.length; row++) {
        if(matrix[row].length>1){
            firstSum += matrix[row][row]; 
        let index = matrix[row].length-row-1;
        secondSum += matrix[row][index];
        }
    }
    console.log(firstSum, secondSum);
}

solve([[20],
[10]]);

solve([[3, 5, 17],
[-1, 7, 14],
[1, -8, 89]]);

