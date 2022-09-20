 let sumArrays= function (array1, array2) {

            const longerArr = array1.length > array2.length ? array1 : array2;
            const rounds = array1.length < array2.length ? array1.length : array2.length;
    
            const resultArr = [];
    
            for (let i = 0; i < rounds; i++) {
                resultArr.push(array1[i] + array2[i]);
            }
    
            resultArr.push(...longerArr.slice(rounds));
    
            return resultArr
        }

    console.log(sumArrays([1,2,3],[4,5,6]));

    