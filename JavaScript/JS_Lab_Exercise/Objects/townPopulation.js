function town(array) {

    let cities = {};
    array.forEach(element => {
        let tokens = element.split(' <-> ');
        let city = tokens[0];
        let population = Number(tokens[1]);
        let newCity = { city, population };

        if (cities[city] != undefined) {
           population += cities[city];
        }
        cities[city] = population;

    });

    for (let key in cities) {
        console.log(`${key} : ${cities[key]}`);
    }
}

town(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']);

    town(['Istanbul <-> 100000',
    'Honk Kong <-> 2100004',
    'Jerusalem <-> 2352344',
    'Mexico City <-> 23401925',
    'Istanbul <-> 1000']);