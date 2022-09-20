function extractingWords(str){
let regex = /(?<words>\w+)/g;
let arr = str.match(regex);
let output = [];
arr.forEach(element => {
    output.push(element.toUpperCase());
});
console.log(output.join(", "));
}

extractingWords('Hi, how are you?');
extractingWords('hello, my name is Stancho');
extractingWords('hello');