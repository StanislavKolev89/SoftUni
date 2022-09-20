class Parking {
    constructor(capacity) {
        this.capacity = capacity;
        this.vehicles = [];
        this.set = new Set();

    }


    addCar(carModel, carNumber) {
        if (this.capacity == 0) {
            throw new Error('Not enough parking space.');
        }
        if (!this.set.has(carNumber)) {
            let car = { carModel, carNumber, payed: false };
            this.vehicles.push(car);
            this.capacity--;
            this.set.add(carNumber);
            return `The ${carModel}, with a registration number ${carNumber}, parked.`

        }
    }

    removeCar(carNumber) {
        let car = this.vehicles.filter(e => e.carNumber == carNumber);
        if (!this.set.has(carNumber)) {
            throw new Error(`The car, you're looking for, is not found.`);
        }
        if (car[0].payed === false) {
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`);
        }
        this.vehicles = this.vehicles.filter(e => e.carNumber != carNumber);
        this.set.delete(carNumber);
        return `${carNumber} left the parking lot.`;
    }

    pay(carNumber) {
        let car = this.vehicles.filter(e => e.carNumber == carNumber);

        if (!this.set.has(carNumber)) {
            throw new Error(`${carNumber} is not in the parking lot.`);
        }
        if (car[0].payed === true) {
             
            throw new Error(`${carNumber}'s driver has already payed his ticket.`);
        }

        car[0].payed = true;
        return `${carNumber}'s driver successfully payed for his stay.`;
    }


    getStatistics(carNumber) {
        let result = [];
        if (carNumber === undefined) {
            result.push(`The Parking Lot has ${this.capacity} empty spots left.`);
          
         this.vehicles.sort((a, b) => a.carModel.localeCompare(b.carModel)).

                forEach(car => {

                    let payedOrNot = car.payed === true ? 'Has payed' : 'Not payed';
                    result.push(`${car.carModel} == ${car.carNumber} - ${payedOrNot}`)
                });
        
        } else {
            let searched = this.vehicles.filter(e => e.carNumber == carNumber)[0];
            let payedOrNot = searched.payed === true ? 'Has payed' : 'Not payed';
            result.push(`${searched.carModel} == ${searched.carNumber} - ${payedOrNot}`);
        }
        return result.join('\n');
    }

}

const parking = new Parking(12);
console.log(parking.getStatistics());
console.log(parking.addCar("Volvo t600", "TX3691CA"));
console.log(parking.addCar("Volvo t500", "TX3692CA"));
console.log(parking.addCar("Volvo t700", "TX3693CA"));




console.log(parking.pay("TX3691CA"));
console.log(parking.pay("TX3691CA"));
console.log(parking.pay("TX3692CA"));

console.log(parking.pay("TX3691CA"));
console.log(parking.removeCar("TX3692CA"));
console.log(parking.pay("TX3693CA"));
