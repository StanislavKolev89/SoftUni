function solve(array) {
    let str = [];
    let command = '';
    let string = '';
    array.forEach(element => {
        command = element.split(' ')[0];
        string = element.split([' '])[1];
        solution(command, string, str);

    });

    function solution(command, string, str) {
        if (command == 'add') {
    
            str.push(string);
        } else if (command == 'remove') {
            let indexOfString = str.indexOf(string, 0);
            while (str.includes(string)) {
                str.splice(indexOfString, 1);
            }
        } else if (command == 'print') {
            console.log(str.join(','));
        }
    }

}

solve(['add hello', 'add again', 'remove hello', 'add again', 'print']);
solve(['add hello','add hello', 'add again', 'remove hello', 'add again', 'print']);