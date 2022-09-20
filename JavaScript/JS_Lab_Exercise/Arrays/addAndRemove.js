function solve(commands) {
    let arr = [];
    let number = 1;


    commands.forEach(command => {
        command === "add" ? arr.push(number) : arr.pop();
        number++;
    });


    if (arr.length <= 0) {
        console.log("Empty");
    } else {
        console.log(arr.join('\n'));
    }
}

solve(['add', 
'add', 
'add', 
'add']);
solve(['add',
    'add',
    'remove',
    'add',
    'add']);
solve(['remove',
'remove', 
'remove'])