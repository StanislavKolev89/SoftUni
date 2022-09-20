function solve(input) {
    let matrix = fillMatrix(input);
    let copy = matrix.slice()
    let firstDiagonal = 0;
    let secondDiagonal = 0;
    for (let row = 0; row < matrix.length; row++) {
        firstDiagonal += matrix[row][row];
        secondDiagonal += matrix[matrix.length - row - 1][row];
    }
    if (firstDiagonal == secondDiagonal) {
        matrix = changeMatrix(matrix, firstDiagonal);
        printMatrix(matrix);
    } else {
        printMatrix(copy);
    }

    function printMatrix(matrix) {
        for (let row = 0; row < matrix.length; row++) {
            console.log(matrix[row].join(' '));
        }
    }
    function changeMatrix(matrix, value) {
        for (let row = 0; row < matrix.length; row++) {
            matrix[row][row] = '' + matrix[row][row];
            matrix[matrix.length - row - 1][row] = '' + matrix[matrix.length - row - 1][row];
        }

        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {
                let element = matrix[row][col];
                if (typeof element == 'number') {
                    matrix[row][col] = value;
                }
            }
        }
        matrix = finalChangesOfMatrix(matrix);
        return matrix;
    }
    function finalChangesOfMatrix(matrix) {
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {
                let element = matrix[row][col];
                if (typeof element == 'string') {
                    matrix[row][col] = Number(element);
                }
            }
        }
        return matrix;
    }
    function fillMatrix(input) {
        let matrix = [];

        let count = input.length
        for (let i = 0; i < count; i++) {
            matrix[i] = input.shift().split(' ').map(Number);
        }
        return matrix;
    }
}


solve(['5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1']);

solve(['1 1 1',
    '1 1 1',
    '1 1 0']);