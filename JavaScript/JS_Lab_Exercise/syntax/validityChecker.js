function solve(x1, y1, x2, y2) {
  let firstValidation =  calculatinghypotenuse(x1,y1,0,0);
  let secondValidation = calculatinghypotenuse(x2, y2,0,0);
    let thirdValidation = calculatinghypotenuse(x1,y2,x2,y2);

   if(firstValidation){
    console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
   }else{
    console.log(`{${x1}, ${y1}} to {0, 0} is invalid`)
   }
   if(secondValidation){
    console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
   }else{
    console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
   }
   if(thirdValidation){
    console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
   }else{
    console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);


   }
   

    function calculatinghypotenuse(x1,y2,x2,y2){
     let firstSide= x1-x2;
     let secondSide = y1-y2;

            if(Number.isInteger(Math.sqrt(firstSide **2 + secondSide ** 2))){
                return true;
            }
            return false;
        }
    }



solve(2, 1, 1, 1);
solve(3, 0, 0, 4);