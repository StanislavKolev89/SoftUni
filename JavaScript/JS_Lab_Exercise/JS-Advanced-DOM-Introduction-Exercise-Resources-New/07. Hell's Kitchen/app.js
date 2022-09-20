function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);
   function onClick() {
      let input = document.getElementsByTagName('textarea');
      let data = Array.from(JSON.parse(input[0].value));

      let restaurants = new Map();
      data.forEach(element => {
         let [restaurantName, workers] = element.split(' - ');
         if (!restaurants.has(restaurantName)) {
            restaurants.set(restaurantName, createObjectFromWorkers(workers));
         } else {
            restaurants.get(restaurantName).getWorkers().concat(arrayOfWorkers(workers));
         }
      });
      let bestRestaurantWorkers = [];
      let bestRestaurant = findBestRestaurant(restaurants);

      let outputBestRestaurat = document.querySelector('#bestRestaurant p');
      outputBestRestaurat.textContent = bestRestaurant;
      let ouputBestWorkers = document.querySelector('#workers p');
      ouputBestWorkers.textContent = concatenateResult(bestRestaurantWorkers);

      function concatenateResult(bestWorkers) {
         let result = "";
         bestWorkers.forEach(e => result += `Name: ${e.name} With Salary: ${e.salary} `);
         return result;
      }
      function findBestRestaurant(rest) {
         let best = '';
         let maxValue = Number.MIN_VALUE;
         for (let [restaurant, object] of rest) {
            if (object.getAverge() > maxValue) {
               maxValue = object.getAverge();
               let restName = restaurant;
               let bestSalary = object.getWorkers().sort((a, b) => b.salary - a.salary)[0].salary;
               bestRestaurantWorkers = object.getWorkers().sort((a, b) => b.salary - a.salary);
               best = `Name: ${restName} Average Salary: ${maxValue.toFixed(2)} Best Salary: ${bestSalary.toFixed(2)}`;
            }
         }
         return best;
      }
      function arrayOfWorkers(work) {
         let workers = work.split(', ');
         let arrayOfWorkers = []
         workers.forEach(e => {
            let [name, salary] = e.split(' ');
            arrayOfWorkers.push({ name, salary });
         });
         return arrayOfWorkers;
      }
      function createObjectFromWorkers(work) {
         let array = {};
         let workers = work.split(', ');
         let arrayOfWorkers = []
         workers.forEach(e => {
            let [name, salary] = e.split(' ');
            salary = Number(salary);
            arrayOfWorkers.push({ name, salary });
         });
         array.getAverge = () => {
            let sum = 0;
            arrayOfWorkers.forEach(e => sum += Number(e.salary));
            return sum / arrayOfWorkers.length;
         }
         array.getWorkers = () => {
            return arrayOfWorkers;
         }
         return array;
      }
   }
}