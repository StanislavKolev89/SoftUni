function solve(arrayOfObj, criteria) {
    let objects = JSON.parse(arrayOfObj);

    let hasProperty = function (criteria, obj) {
      let [first, second] = criteria.split('-');
      if (obj.hasOwnProperty(first)) {
          if (obj[first] === second) {
              return true;
          }
      }
      return false;
  }

    if (criteria ==='all') {
        for (let i = 0; i < objects.length; i++) {
            let e = objects[i];
            console.log(`${i}. ${e.first_name} ${e.last_name} - ${e.email}`);
        }
    } else { 
      if(objects !==[]){
        let filtered = objects.filter(obj => hasProperty(criteria, obj));
        for (let i = 0; i < filtered.length; i++) {
            let e = filtered[i];
            console.log(`${i}. ${e.first_name} ${e.last_name} - ${e.email}`);
        }
        
      }
    }
}

// solve(`[{
//     "id": "1",
//     "first_name": "Ardine",
//     "last_name": "Bassam",
//     "email": "abassam0@cnn.com",
//     "gender": "Female"
//   }, {
//     "id": "2",
//     "first_name": "Kizzee",
//     "last_name": "Jost",
//     "email": "kjost1@forbes.com",
//     "gender": "Female"
//   },  
// {
//     "id": "3",
//     "first_name": "Evanne",
//     "last_name": "Maldin",
//     "email": "emaldin2@hostgator.com",
//     "gender": "Male"
//   }]`,
//     'gender-Female');

solve(`[{
  "id": "1",
  "first_name": "Kaylee",
  "last_name": "Johnson",
  "email": "k0@cnn.com",
  "gender": "Female"
}, {
  "id": "2",
  "first_name": "Kizzee",
  "last_name": "Johnson",
  "email": "kjost1@forbes.com",
  "gender": "Female"
}, {
  "id": "3",
  "first_name": "Evanne",
  "last_name": "Maldin",
  "email": "emaldin2@hostgator.com",
  "gender": "Male"
}, {
  "id": "4",
  "first_name": "Evanne",
  "last_name": "Johnson",
  "email": "ev2@hostgator.com",
  "gender": "Male"
}]`,'last_name-Johnson');
