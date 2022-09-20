function solution() {
    let str = '';
    return {
        append,
        removeStart,
        removeEnd,
        print
    }
    function append(text) {
        str += text;
    }

    function removeStart(n) {
        let newStr = str.slice(0, n);
        str = str.replace(newStr, '');
    }

    function removeEnd(n) {
        let newStr = str.slice(-n);
        str = str.replace(newStr, '');
    }

    function print() {
        console.log(str);
    }
}

let firstZeroTest = solution();

firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print();

console.log('--------------------------------')
let secondZeroTest = solution();

secondZeroTest.append('123');
secondZeroTest.append('45');
secondZeroTest.removeStart(2);
secondZeroTest.removeEnd(1);
secondZeroTest.print();