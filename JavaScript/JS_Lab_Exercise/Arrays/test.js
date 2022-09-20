let arr = [1,2,3,4,5,6];
let reducer = (acc,value,index,arr)=> {
    if(index %2 == 0){
    acc+=value*2;
    }else{
    acc+=value;
    }
    return acc;
}
console.log(arr.reduce(reducer));


