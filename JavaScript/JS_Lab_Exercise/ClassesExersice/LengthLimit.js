class Stringer {

    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
        this.lastReturned = this.innerString;
    }

    increase(length) {
       
        this.innerLength += length;
    }

    decrease(length) {
      
        this.innerLength= this.innerLength-length<0? 0: this.innerLength-length;
    }

    toString() {
        let result = '';

        if (this.lastReturned.endsWith('...')) {
            this.lastReturned = this.lastReturned.substring(0, (this.lastReturned.length - 3));
        }

        if (this.lastReturned.length > this.innerLength) {
            result = this.lastReturned.substring(0, this.innerLength);
            result += '...';
            this.lastReturned = result;
            return this.lastReturned;
        }

        return this.innerString;

    }

}

let test = new Stringer("Test", 5);
console.log(test.toString()); // Test

test.decrease(3);
console.log(test.toString()); // Te...

test.decrease(5);
console.log(test.toString()); // ...

test.increase(4);
console.log(test.toString()); //