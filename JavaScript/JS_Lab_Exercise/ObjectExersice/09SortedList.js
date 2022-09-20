function createSortedList() {
    let numbers = [];
    return {
        add: (element) => {
            numbers.push(element);
            numbers.sort((a, b) => a - b);
        }, remove: (index) => {
            if (index < 0 || index >= numbers.length) {
                throw new RangeError("Index out of range");
            }
            numbers.splice(index, 1)
        },
        get: (index) => {
            if (index < 0 || index >= numbers.length) {
                throw new RangeError("Index out of range");
            }
            return numbers[index];
        },
        get size() {
            return numbers.length;
        }
    }
}


let list = createSortedList();
list.add(5);
list.add(6);
list.add(7);
console.log(list.size);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));
console.log(list.size);