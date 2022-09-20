class Hex{
constructor(value){
    this.value = value;
}

valueOf(){
    return this.value;
}

plus(obj){
    let result =0;
    if(obj==='number'){
      result = this.valueOf()+obj;
    }else{
        result =this.valueOf()+obj.valueOf()
    }
    return new Hex(result);

}

minus(obj){
    let result =0;
    if(obj==='number'){
      result = this.valueOf()-obj;
    }else{
        result =this.valueOf()-obj.valueOf()
    }
    return new Hex(result);

}

parse(string){
    return parseInt(string, 16);
}
toString(){
   
    function decimalToHexString(number)
    {
      if (number < 0)
      {
        number = 0xFFFFFFFF + number + 1;
      }
    
      return number.toString(16).toUpperCase();
    }
   return '0x'+decimalToHexString(this.value); 
}

}

let FF = new Hex(255);
console.log(FF.toString());
FF.valueOf() + 1 == 256;
let a = new Hex(10);
let b = new Hex(5);
console.log(a.plus(b).toString());
console.log(a.plus(b).toString()==='0xF');
console.log(FF.parse('AAA'));