function solve(juices) {
    let mapWithJuice = new Map();
    let bottles = new Map();

    for (const element of juices) {
        let [juice, quantity] = element.split(' => ');
        quantity = Number(quantity);
        if (!mapWithJuice.has(juice)) {
            mapWithJuice.set(juice, quantity);
        } else {
            mapWithJuice.set(juice, mapWithJuice.get(juice) + quantity);
        }

        if (mapWithJuice.get(juice) >= 1000) {
            bottles.set(juice, 0);
        }
    }

    for (const el of mapWithJuice) {
        if (bottles.has(el[0])) {
            bottles.set(el[0], Math.floor(el[1] / 1000));
        }
    }
    for (const el of bottles) {
        console.log(`${el[0]} => ${el[1]}`);
    }

}







solve(['Orange => 2000',
    'Peach => 1432',
    'Banana => 450',
    'Peach => 600',
    'Strawberry => 549']);

    solve(['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']);