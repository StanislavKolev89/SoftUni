function solve(speed, area) {

    let overSpeed = overLimit(speed, area);
    if (overSpeed >= 0) {
        console.log(`Driving ${speed} km/h in a ${getLimit(area)} zone`);
    } else {
        overSpeed = Math.abs(overSpeed);
        console.log(`The speed is ${overSpeed} km/h faster than the allowed speed of ${getLimit(area)} - ${status(overSpeed)}`);
    }
    function status(digit) {
        let kmOver = Math.abs(digit);
        if (kmOver <= 20) {
            return 'speeding';
        } else if (kmOver <= 40) {
            return 'excessive speeding';
        } else {
            return 'reckless driving';
        }

    }

    function overLimit(speed, area) {
        let limit = getLimit(area);
        return limit - speed;
    }
    function getLimit(area) {
        switch (area) {
            case "city":
                return 50;
                break;
            case "residential":
                return 20;
                break;
            case "interstate":
                return 90;
                break;
            case "motorway":
                return 130;
                break;
        }
    }
}

solve(40, 'city')
solve(21, 'residential')
solve(120, 'interstate')
solve(200, 'motorway')
