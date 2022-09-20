function solve(input) {

    let matrix = [[false, false, false],
    [false, false, false],
    [false, false, false]];

    let weHaveaWinner = false;
    let playersTurn = "X";
    let winnersName = '';
    let counter = 9;
    while (input.length > 0) {
        let position = input.shift().split(' ');
        let row = position[0];
        let col = position[1];
        let element = matrix[row][col];

        if (element === false) {
            matrix[row][col] = playersTurn;
            playersTurn = playersTurn == 'O' ? 'X' : 'O';

        } else if (element == 'X' || element == 'O') {
            console.log('This place is already taken. Please choose another!');
            continue;
        }

        if (hasAWinner(matrix, matrix[row][col])) {
            weHaveaWinner = true;
            winnersName = playersTurn == 'O' ? 'X' : 'O';
            break;
        }
        counter--;
        if (counter == 0) {
            break;
        }

    }
    if (weHaveaWinner) {
        console.log(`Player ${winnersName} wins!`)
    } else {
        console.log(`The game ended! Nobody wins :(`);
    }
    matrix.forEach(element => console.log(element.join("\t")));
    function hasAWinner(matrix, element) {
        if (element === 'X' || element === 'O') {
            if ((matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2] && matrix[0][0] !== false) ||
                (matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2] && matrix[1][0] !== false) ||
                (matrix[2][0] == matrix[2][1] && matrix[2][2] == matrix[2][1] && matrix[2][0] !== false) ||
                (matrix[0][0] == matrix[1][0] && matrix[2][0] == matrix[1][0] && matrix[0][0] !== false) ||
                (matrix[1][0] == matrix[1][1] && matrix[1][2] == matrix[1][1] && matrix[1][0] !== false) ||
                (matrix[2][0] == matrix[2][1] && matrix[2][2] == matrix[2][1] && matrix[2][0] !== false) ||
                (matrix[0][0] == matrix[1][1] && matrix[2][2] == matrix[1][1] && matrix[0][0] !== false) ||
                (matrix[2][0] == matrix[1][1] && matrix[0][2] == matrix[1][1] && matrix[2][0] !== false)) {
                return true;
            }
            return false;
        }
    }
}

solve(["0 0",
"0 0",
"1 1",
"0 1",
"1 2",
"0 2",
"2 2",
"1 2",
"2 2",
"2 1"]);