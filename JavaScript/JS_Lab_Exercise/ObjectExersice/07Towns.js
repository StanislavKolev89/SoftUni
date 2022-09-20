function solve(array) {
    let towns = [];
    for (let i = 0; i < array.length; i++) {
        let [townName, latitude, longitude] = array[i].split(/\s*\|\s*/gim).filter(x => x !== '');
     let latitudeParse = Number(latitude);
        let longitudeParse = Number(longitude);
        if(!Number.isNaN(latitudeParse) && !Number.isNaN(longitudeParse)){
        towns.push({ Town: townName, Latitude: 
            Number(latitudeParse.toFixed(2)), Longitude: Number(longitudeParse.toFixed(2)) });
        }

    }
    console.log(JSON.stringify(towns));
}

solve(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']);