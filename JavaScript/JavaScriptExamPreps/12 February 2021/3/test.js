const { expect } = require('chai');
const pizzUni = require('./Pizza');

describe("PizzA Testing", function () {
    describe("MakingORder", function () {

        it("Should return proper message when valid object added with two parameters", function () {
            let obj = { orderedPizza: `Peperoni`, orderedDrink: `Cola` };
            expect(pizzUni.makeAnOrder(obj)).to.equal('You just ordered Peperoni and Cola.');

        });
        it("Should return proper message when valid object added with one parameter", function () {
            let obj = { orderedPizza: `Peperoni` };
            expect(pizzUni.makeAnOrder(obj)).to.equal('You just ordered Peperoni');
            let Obj1 ={};
            expect(()=>{pizzUni.makeAnOrder(Obj1)}).to.throw();
        });


    });

    describe("MakingORder", function () {

        it("Should return proper message when valid object added with two parameters", function () {
            let obj = { orderedPizza: `Peperoni`, orderedDrink: `Cola` };
            expect(pizzUni.makeAnOrder(obj)).to.equal('You just ordered Peperoni and Cola.');

        });
        it("Should return proper message when valid object added with one parameter", function () {
            let obj = { orderedPizza: `Peperoni` };
            expect(pizzUni.makeAnOrder(obj)).to.equal('You just ordered Peperoni');
            let Obj1 ={};
            expect(()=>{pizzUni.makeAnOrder(Obj1)}).to.throw();
        });


    });
    describe("getRemainingWork", function () {

        it("Should return proper message when valid object added with two parameters", function () {
          let statusArray =[{pizzaName: 'Peperoni', status: 'ready' },{pizzaName: 'Margarita', status: 'ready'}]; 
            expect(pizzUni.getRemainingWork(statusArray)).to.equal('All orders are complete!');
            let statusArray2 =[{pizzaName: 'Peperoni', status: 'ready' },{pizzaName: 'Margarita', status: 'preparing'}]; 
            expect(pizzUni.getRemainingWork(statusArray2)).to.equal('The following pizzas are still preparing: Margarita.');

        });
        it("Should return proper message when valid object added with one parameter", function () {
            let obj = { orderedPizza: `Peperoni` };
            expect(pizzUni.makeAnOrder(obj)).to.equal('You just ordered Peperoni');

        });


    });
    describe("orderType", function () {

        it("Should count proper sum ", function () {
        
            expect(pizzUni.orderType(100,'Carry Out')).to.equal(90);
            expect(pizzUni.orderType(100,'Delivery')).to.equal(100);
            

        });
        


    });
});