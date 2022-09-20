const { expect } = require('chai');
const numberOperations = require('./03. Number Operations_Resources');


describe('Test pow', function () {
    describe('Test pow', function () {
        it('Should work ', function () {
            expect(numberOperations.powNumber(3)).to.equal(9);
            expect(numberOperations.powNumber(0)).to.equal(0);
            expect(numberOperations.powNumber(1)).to.equal(1);

        });


    });
    describe('Number checker', function () {
        it('Should work with a string', function () {
            expect(numberOperations.numberChecker('3')).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(3)).to.equal('The number is lower than 100!');
            expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker('120')).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
            expect(numberOperations.numberChecker('-20')).to.equal('The number is lower than 100!');

        });
        it('Should throw with invalid input', function () {
            expect(() => { numberOperations.numberChecker('a') }).to.throw('The input is not a number!');
            expect(() => { numberOperations.numberChecker(undefined) }).to.throw('The input is not a number!');
            expect(() => { numberOperations.numberChecker({}) }).to.throw('The input is not a number!');
 
            expect(() => { numberOperations.numberChecker('3a') }).to.throw('The input is not a number!');
        });
    });

    describe('Sum arrays', function(){
        it('Should return the right sum',function(){
           expect(numberOperations.sumArrays([1,2,3],[3,4,5])).to.eql([4,6,8]);
           expect(numberOperations.sumArrays([0,0,0],[0,0,])).to.eql([0,0,0]);
           expect(numberOperations.sumArrays([1,4,5],[0,0,])).to.eql([1,4,5]);
           expect(numberOperations.sumArrays([0,0,0],[0,0,])).to.eql([0,0,0]);
           expect(numberOperations.sumArrays([1,2,0],[3,4,5,6])).to.eql([4,6,5,6]);
   
        });
    });


});