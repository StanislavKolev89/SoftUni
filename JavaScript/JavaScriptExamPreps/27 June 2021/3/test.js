const { expect } = require(`chai`);
const testNumbers = require('./testNumbers')

describe("Testing With Chai", function () {
    describe("Sum two numbers ", function () {
        it("Should return proper value when using valid numbers", function () {
            expect(testNumbers.sumNumbers(3, 4)).to.equal('7.00');
            expect(testNumbers.sumNumbers(3, 4.3)).to.equal('7.30');
            expect(testNumbers.sumNumbers(-1, 4)).to.equal('3.00');
            expect(testNumbers.sumNumbers(3, 0)).to.equal('3.00');
        });
        it("Should return undefined when using nonvalid numbers", function () {
            expect(testNumbers.sumNumbers(3, '4')).to.be.undefined;
            expect(testNumbers.sumNumbers(3, null)).to.be.undefined;
            expect(testNumbers.sumNumbers(null, undefined)).to.be.undefined;
            expect(testNumbers.sumNumbers(1.4, [])).to.be.undefined;
            expect(testNumbers.sumNumbers(1.4, {})).to.be.undefined;
        });


    });

    describe("Number checker", function () {
        it("Should return even input", function () {
            expect(testNumbers.numberChecker(4)).to.equal('The number is even!');
            expect(testNumbers.numberChecker(0)).to.equal('The number is even!');
            expect(testNumbers.numberChecker(256)).to.equal('The number is even!');
            expect(testNumbers.numberChecker('256')).to.equal('The number is even!');
            expect(testNumbers.numberChecker('0')).to.equal('The number is even!');

        });
        it("Should return odd input", function () {
            expect(testNumbers.numberChecker(3)).to.equal('The number is odd!');
            expect(testNumbers.numberChecker(13)).to.equal('The number is odd!');
            expect(testNumbers.numberChecker(253)).to.equal('The number is odd!');
            expect(testNumbers.numberChecker('15')).to.equal('The number is odd!');
        });

        it("Should throw error with invalid input", function () {
            expect(() => { testNumbers.numberChecker('o') }).to.throw();
        
            expect(() => { testNumbers.numberChecker({}) }).to.throw();
            expect(() => { testNumbers.numberChecker(undefined) }).to.throw();
        });
    });
    describe("Average Sum", function () {
        it("Should return proper sum with valid input", function () {
        expect(testNumbers.averageSumArray([3,5.8])).to.equal(4.4);
        expect(testNumbers.averageSumArray([3,5.8])).to.equal(4.4);
        expect(testNumbers.averageSumArray([3,5,3,6,7])).to.equal(4.8);
        });
     

    });

});