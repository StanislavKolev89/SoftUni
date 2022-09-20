function solve(steps, lengthOfSingleStep, KmPerHour) {
    let distanceInMeters = steps * lengthOfSingleStep;
    let additionalTimeinMin = Math.floor(distanceInMeters / 500) 
    let resultInMin = Math.floor(distanceInMeters / (KmPerHour * 16.667)); 
    let secToAdd = Math.ceil(((distanceInMeters / (KmPerHour * 16.667)) - resultInMin) * 60);
    let finalTimeInMinutes = resultInMin+additionalTimeinMin;

    let hours =Math.floor(finalTimeInMinutes / 60);
    let mins = finalTimeInMinutes % 60;
    

    console.log(`${pad(hours,2)}:${pad(mins,2)}:${pad(secToAdd,2)}`);
 
    function pad(num, size) {
        num = num.toString();
        while (num.length < size) num = "0" + num;
        return num;
    }
}

solve(4000, 0.60, 5);
solve(2564, 0.70, 5.5);