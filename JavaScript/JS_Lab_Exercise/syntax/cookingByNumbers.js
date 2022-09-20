function solve(number, op1, op2, op3, op4, op5) {
    let num = number;
    let arr = [op1, op2,op3, op4, op5];
    for (let i = 0; i < arr.length; i++) {
        num = operation(num, arr[i]);
        console.log(num);
    
    }function operation(number,str) {
        switch(str){
            case'chop':
            return number / 2;
            break;
            case'dice':
            return Math.sqrt(number);
            break;
            case'spice':
            return ++number;
            break;
            case'bake':
            return number*3;
            break;
            case'fillet':
            return 0.8 * number;
        }
     }
}



solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');