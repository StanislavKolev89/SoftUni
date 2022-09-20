function solve(array){
    let objMap = {}

    for (let i = 0; i < array.length; i+=2) {
      let name = array[i];
      let calories = Number(array[i+1]);
      objMap[name] = calories;
    }
    console.log(objMap);
}

solve(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']);
solve(['Potato', '93', 'Skyr', '63', 'Cucumber', '18', 'Milk', '42']);