function solve() {
    let inputFields = Array.from(document.querySelectorAll('tbody tr td'));
    let matrix = [];
    inputFields.forEach(e => matrix.push(Number(e.textContent)));

    console.log(matrix);
    let checkButton = document.getElementsByTagName('button')[0];
    checkButton.addEventListener('click', checkForWinner);
    let clearButton = document.getElementsByTagName('button')[1];
    clearButton.addEventListener('click', clearData);
    let table = document.getElementsByTagName('table')[0];
    let message = document.getElementById('check').children[0];

    function clearData(e) {
        inputFields.forEach(e => e.textContent = '');
        message.textContent = '';
        message.style.color = ''
        table.style.border = '';
    }
    function checkForWinner(e) {
        if (winnerFound(matrix) && noneIsInvalid(matrix)) {
            
                table.style.border = "2px solid green";
                message.textContent = 'You solve it! Congratulations!';
                message.style.color = 'green';
            
        } else {
            table.style.border = "2px solid red";
            message.textContent = 'NOP! You are not done yet...';
            message.style.color = 'red';

        }
    }

    function winnerFound(matrix) {
        if ((matrix[0] == matrix[1] && matrix[1] == matrix[2]) ||
            (matrix[3] == matrix[4] && matrix[4] == matrix[5]) ||
            (matrix[6] == matrix[7] && matrix[7] == matrix[8]) ||
            (matrix[0] == matrix[3] && matrix[3] == matrix[6]) ||
            (matrix[1] == matrix[4] && matrix[4] == matrix[7]) ||
            (matrix[2] == matrix[5] && matrix[5] == matrix[8]) ||
            (matrix[0] == matrix[4] && matrix[4] == matrix[8]) ||
            (matrix[6] == matrix[4] && matrix[4] == matrix[2])) {
            return true;
        }
        return false;
    }

    function noneIsInvalid(matrix) {
        for (let i = 0; i < matrix.length; i++) {
            if (matrix[i] < 1 || matrix[i] > 3) {
                return false;
            }
        }
        return true;
    }
}