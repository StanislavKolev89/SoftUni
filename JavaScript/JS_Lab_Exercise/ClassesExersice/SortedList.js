class List {
    constructor() {
        this.arr = [];
        this.size = 0;
    }

    add(value) {
    
            this.arr.push(value)
            this.size += 1
            return this.arr.sort((a, b) => {
                return a - b
            });
  
    }

    get(index) {
        if (this.arr.length > index && index >= 0) {
            return this.arr[index];
        } else {
            throw new Error;
        }
    }
     remove(index) {
        if (this.arr.length > index && index >= 0) {
            this.arr.splice(index, 1);
            this.size--;
        } else {
            throw new Error;
        }
        return this.arr.sort((a, b) => {
            return a - b
        });
    
    }
}

 

let list = new List();
list.add(5);
list.add(6);
list.add(12);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(2));
console.log(list.size);