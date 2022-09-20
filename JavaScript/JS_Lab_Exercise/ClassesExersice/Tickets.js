function solve(array, criteria) {
    let bucket = [];

    class Ticket {
        constructor(destinationName, price, status) {
            this.destinationName = destinationName;
            this.price = price;
            this.status = status;
        }

        getDestinationName() {
            return this.destinationName;
        }

        getPrice() {
            return this.price;
        }

        getStatus() {
            return this.status;
        }



    }



    for (const el of array) {
        let [destinationName, price, status] = el.split('|');
        let ticket = new Ticket(destinationName, price, status);
        bucket.push(ticket);

    }
    let sorted = null;
    if (criteria == 'destination') {
        sorted = bucket.sort((a, b) => a.getDestinationName().localeCompare(b.getDestinationName()));
    } else if (criteria == 'status') {
        sorted = bucket.sort((a, b) => a.getStatus().localeCompare(b.getStatus()));
    } else if (criteria == 'price') {
        sorted = bucket.sort((a, b) => a.getPrice() - b.getPrice());
    }
    return sorted;
}



console.log('By status-----------------------------')
console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'status'));
console.log('By price----------------------------------');
console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'price'));
console.log('By destination-------------------------');
console.log(solve(['Philadelphia|94.20|available',
    'New York City|95.99|available',
    'New York City|95.99|sold',
    'Boston|126.20|departed'],
    'destination'));