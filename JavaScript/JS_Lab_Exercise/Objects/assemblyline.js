function createAssemblyLine() {
    return {
        hasClima: (object) => {
            object.temp = 21;
            object.tempSettings = 21;
            object.adjustTemp = function () {
                if (object.temp < object.tempSettings) {
                    object.temp++;
                } else if (object.temp > object.tempSettings) {
                    object.temp--;
                }
            }
        },

        hasAudio: ( obj ) => {
            obj.currentTrack = { 'name': '', 'artist': '' }
            obj.nowPlaying = () => {
                if(obj.currentTrack !=null){
                console.timeLog(`Now playing '${obj.currentTrack.name}' by ${obj.currentTrack.artist}`);
                }
            };
        },
        hasParktronic: (obj) => {
            obj.checkDistance = (distance) => {
                if (distance < 0.1) {
                    console.log('Beep! Beep! Beep!');
                } else if (distance >= 0.1 && distance < 0.25) {
                    console.log('Beep! Beep!');
                } else if (distance >= 0.25 && distance < 0.5) {
                    console.log('Beep!');
                } else {
                    console.log('');
                }
            }
        }
    };
}

const assemblyLine = createAssemblyLine();

const myCar = {
    make: 'Toyota',
    model: 'Avensis'
};

assemblyLine.hasClima(myCar);
console.log(myCar.temp);
myCar.tempSettings = 18;
myCar.adjustTemp();
console.log(myCar.temp);
console.log('---------------');

assemblyLine.hasAudio(myCar);
myCar.currentTrack = {
    name: 'Never Gonna Give You Up',
    artist: 'Rick Astley'
};
myCar.nowPlaying();