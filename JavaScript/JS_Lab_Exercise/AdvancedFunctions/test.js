function greet(name){
    return function message(message){
        return function anotherMessage(another){
            return `${name} ${message} ${another}`;
        }
       
    }
}

let result = greet('Pesho');
let another = result('how are you');
console.log(another('Motherfucker'));