function solve(array){
        let newArray = [];

        for (let i = 0; i < array.length; i++) {
            const element = array[i];
        element<0? newArray.unshift(element): newArray.push(element);
        }

        newArray.forEach(element => {
            console.log(element);
        });

}

solve([7, -2, 8, 9]);
solve([3, -2, 0, -1]);