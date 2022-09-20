function solve(arr) {
    console.log(reduced(arr).join(' '));


    function reduced(array) {
        let newArr = [];
        for (let i = 0; i < array.length; i += 2) {
            newArr.push(array[i]);

        }
        return newArr;
    }

}

solve(['20', '30', '40', '50', '60']);