function solve(array) {
    let dim1 = array[0];
    let dim2 = array[1];
    let rowStart = array[2];
    let colStart = array[3];
    let matrix = creatingMatrix(dim1, dim2);
    matrix = fillingMatrix(matrix, rowStart, colStart);
    console.log(matrix);

    function fillingMatrix(matrix, rowStart, colStart) {
        matrix[rowStart][colStart] = 1;
        let iterator = 1;
        while (true) {

            //down
            if (inBoundry(matrix, rowStart + iterator, colStart) && typeof matrix[rowStart + iterator][colStart] != 'number') {
                matrix[rowStart + iterator][colStart] = 1 + iterator;
            }
            //riht
            if (inBoundry(matrix, rowStart, colStart + iterator) && typeof matrix[rowStart][colStart + iterator] != 'number') {
                matrix[rowStart][colStart + iterator] = 1 + iterator;
            }
            //left
            if (inBoundry(matrix, rowStart, colStart - iterator) && typeof matrix[rowStart][colStart - iterator] != 'number') {
                matrix[rowStart][colStart - iterator] = 1 + iterator;
            }
            //up
            if (inBoundry(matrix, rowStart - iterator, colStart) && typeof matrix[rowStart - iterator][colStart] != 'number') {
                matrix[rowStart - iterator][colStart] = iterator + iterator;
            }
            //upright
            if (inBoundry(matrix, rowStart - iterator, colStart + iterator) && typeof matrix[rowStart - iterator][colStart + iterator] != 'number') {
                matrix[rowStart - iterator][colStart + iterator] = 1 + iterator;
            }
            //upleft
            if (inBoundry(matrix, rowStart + iterator, colStart - iterator) && typeof matrix[rowStart - iterator][colStart - iterator] != 'number') {
                matrix[rowStart + iterator][colStart-iterator] = 1 + iterator;
            }
            //downright
            if (inBoundry(matrix, rowStart + iterator, colStart + iterator) && typeof matrix[rowStart + iterator][colStart + iterator] != 'number') {
                matrix[rowStart + iterator][colStart + iterator] = 1 + iterator;
            }
            //downleft
            if (inBoundry(matrix, rowStart + iterator, colStart - iterator) && typeof matrix[rowStart + iterator][colStart - iterator] != 'number') {
                matrix[rowStart + iterator][colStart-iterator] = 1 + iterator;
            }
            if (matrixFull(matrix)) {
                break;
            }
            iterator++;

        }
        return matrix;
    }
    function matrixFull(matrix) {
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {
                if (typeof matrix[row][col] != 'number') {
                    return false;
                }
            }
        }
        return true;
    }

    function inBoundry(matrix, row, col) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix.length) {
            return true;
        }
        return false;
    }

    function fillingLeft(matrix, rowStart, colStart) {
        let initalValue = matrix[rowStart][colStart];
        let counts = rowStart;
        for (let col = 0; col < counts; col++) {
            matrix[col][rowStart] = Math.abs(colStart - col) + initalValue;
        }
        return matrix;
    }
    function fillingDown(matrix, rowStart, colStart) {
        let initalValue = matrix[rowStart][colStart];
        let counts = rowStart;
        for (let col = counts; col < matrix[rowStart].length; col++) {
            matrix[col][rowStart] = Math.abs(colStart - col) + initalValue;
        }
        return matrix;
    }
    function creatingMatrix(rows, cols) {
        let matrix = [];

        for (let row = 0; row < rows; row++) {
            let rowMatrix = [];
            for (let col = 0; col < cols; col++) {
                rowMatrix.push('*');
            }
            matrix.push(rowMatrix);
        }
        return matrix;
    }

}

solve([4, 4, 0, 0]);