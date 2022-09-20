class SummerCamp {

    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForTheCamp = { child: 150, student: 300, collegian: 500 };
        this.listOfParticipants = [];
    }

    registerParticipant(name, condition, money) {

        if (!this.priceForTheCamp.hasOwnProperty(condition)) {
            throw new Error(`Unsuccessful registration at the camp.`);
        }

        let searchedName = this.listOfParticipants.find(p => p.name == name);

        if (searchedName !== undefined) {
            return `The ${name} is already registered at the camp.`;
        }

        if (money < this.priceForTheCamp[condition]) {
            return `The money is not enough to pay the stay at the camp.`;
        }
        let obj = { name, condition, power: 100, wins: 0 };
        this.listOfParticipants.push(obj);

        return `The ${name} was successfully registered.`;
    }

    unregisterParticipant(name) {
        let searchedName = this.listOfParticipants.find(p => p.name == name);

        if (searchedName === undefined) {
            throw new Error(`The ${name} is not registered in the camp.`)
        }

        this.listOfParticipants = this.listOfParticipants.filter(p => p.name != name);
        return `The ${name} removed successfully.`

    }

    timeToPlay(typeOfGame, name1, name2) {

        if (typeOfGame == "WaterBalloonFights") {
            let p1 = this.listOfParticipants.find(e => e.name == name1);
            let p2 = this.listOfParticipants.find(e => e.name == name2);

            if (p1 === undefined || p2 === undefined) {
                throw new Error('Invalid entered name/s.');
            }
            let p1con = p1.condition;
            let p2con = p2.condition;
            if (p1con !==p2con) {
                throw new Error(`Choose players with equal condition.`);
            }

            if (p1.power != p2.power) {
                if (p1.power > p2.power) {
                    p1.wins++;
                    return `The ${p1.name} is winner in the game ${typeOfGame}.`
                } else {
                    p2.wins++;
                    return `The ${p2.name} is winner in the game ${typeOfGame}.`
                }
            } else {
                return `There is no winner.`
            }

        } else if (typeOfGame == "Battleship") {
            let p1 = this.listOfParticipants.find(e => e.name == name1);
            if (p1 === undefined) {
                throw new Error('Invalid entered name/s.');
            }

            p1.power+=20;
            return  `The ${p1.name} successfully completed the game ${typeOfGame}.`
        }
    }

    toString(){
        let result = [];
        let numberOfPlayers= this.listOfParticipants.length;
        result.push(`${this.organizer} will take ${numberOfPlayers} participants on camping to ${this.location}`);
        let arrayofPlayer = this.listOfParticipants.sort((a,b)=> b.wins-a.wins);
        arrayofPlayer.forEach(e=> result.push(`${e.name} - ${e.condition} - ${e.power} - ${e.wins}`));

        return result.join('\n');
        }

}

const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));

console.log(summerCamp.toString());