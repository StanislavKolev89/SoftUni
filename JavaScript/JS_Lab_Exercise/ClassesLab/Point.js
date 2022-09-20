class Point{
    constructor(x,y){
        this.x = x;
        this.y = y;
    }

    static distance(x,y){
        
        return Math.sqrt((x.x-y.x)**2 +(x.y -y.y) ** 2);
    }
}

let p1 = new Point(5, 5);
let p2 = new Point(9, 8);
console.log(Point.distance(p1, p2));