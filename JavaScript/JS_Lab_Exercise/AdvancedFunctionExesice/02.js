function solve(...array) {
    let obj = {};
    let arr = [];
    array.forEach(el => {
        let type = typeof (el);
        arr.push({ type: el });
        obj[type] !== undefined ?obj[type]+=1  : obj[type]=1;
        console.log(`${type}: ${el}`);
     
    });

Object.keys(obj).sort((a, b) => obj[b] - obj[a]).forEach(key => console.log(`${key} = ${obj[key]}`));



}

solve('cat', 42, 55, function () { console.log('Hello world!'); })