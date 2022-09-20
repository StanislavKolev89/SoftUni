function findingMax(num1,num2,num3){
    let array = [num1,num2,num3];
    let biggest = array.reduce(function(a,b){
      return Math.max(a,b);
    });
    console.log("The largest number is "+ biggest+".");
    }