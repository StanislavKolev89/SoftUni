const {expect} = require('chai');
const dealership = require('./dealership');


describe("Testing dealerShip", function() {
    describe("New car cost method", function() {

        it("Should return proper price when existing car is given", function() {
            expect(dealership.newCarCost('Audi A4 B8',30000)).to.equal(15000);
            expect(dealership.newCarCost('Audi A6 4K',100000)).to.equal(80000);
            expect(dealership.newCarCost('Audi A8 D5',100000)).to.equal(75000);
            expect(dealership.newCarCost('Audi TT 8J',14000)).to.equal(0);
        });

        
        it("Should return proper price when non existing car is given", function() {
            expect(dealership.newCarCost('Audi A4 ',30000)).to.equal(30000);
            expect(dealership.newCarCost('Audi A6K',100000)).to.equal(100000);
            expect(dealership.newCarCost('Audi D5',100000)).to.equal(100000);
            expect(dealership.newCarCost('Audi 8J',14000)).to.equal(14000);
        });
     });

     describe("carEqupment", function() {

        it("Should return proper arraywhen existing indexes are given", function() {
            expect(dealership.carEquipment(['leather','exstrPaint','cooler'],[0,2])).to.eql(['leather','cooler']);
            expect(dealership.carEquipment(['heatedSeats','exstrPaint','cooler'],[0])).to.eql(['heatedSeats']);
     
        });

     });

     describe("euroCategory", function() {

        it("Should return proper message", function() {
           expect(dealership.euroCategory(5)).to.equal('We have added 5% discount to the final price: 14250.');
           expect(dealership.euroCategory(4)).to.equal('We have added 5% discount to the final price: 14250.');
           expect(dealership.euroCategory(3)).to.equal('Your euro category is low, so there is no discount from the final price!');
        });

     });

});