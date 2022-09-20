function solve(a, b) {
    while (a > 0 && b > 0) {
        if (a > b) {
            return solve(b, (a % b));
        } else if (b > a) {
            return solve(a, b % a);
        } else {
            return a;
        }
    }
    if (a == 0) {
        console(log(b));
    } else { console.log(a) }

}

solve(20, 10);
solve(2154, 458);