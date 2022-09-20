const { expect } = require('chai');
const mathEnforcer = require('./04Math');

describe('Math Enforcer', () => {

    it('should return undefined when using non number value when adding', () => {
        expect(mathEnforcer.addFive('10')).to.be.undefined;
        expect(mathEnforcer.addFive(null)).to.be.undefined;
        expect(mathEnforcer.addFive({})).to.be.undefined;
        expect(mathEnforcer.addFive('10')).to.be.undefined;
        expect(mathEnforcer.addFive(undefined)).to.be.undefined;

    });
    it('should return proper result when adding five', () => {
        expect(mathEnforcer.addFive(5)).to.equal(10);
        expect(mathEnforcer.addFive(0)).to.equal(5);
        expect(mathEnforcer.addFive(-100)).to.equal(-95);
        expect(mathEnforcer.addFive(5)).to.equal(10);
        expect(mathEnforcer.addFive(5.3)).to.be.closeTo(10, 3, 0, 01);

    });
    it('should return undefined when using non number value when subtracting', () => {
        expect(mathEnforcer.subtractTen('10')).to.be.undefined;
        expect(mathEnforcer.subtractTen(null)).to.be.undefined;
        expect(mathEnforcer.subtractTen({})).to.be.undefined;
        expect(mathEnforcer.subtractTen('10')).to.be.undefined;
        expect(mathEnforcer.subtractTen(undefined)).to.be.undefined;



    });
    it('should return proper value when using integer value when subtracting', () => {
        expect(mathEnforcer.subtractTen(10)).to.equal(0);
        expect(mathEnforcer.subtractTen(100)).to.equal(90);
        expect(mathEnforcer.subtractTen(10.3)).to.be.closeTo(0, 3, 0.01);
        expect(mathEnforcer.subtractTen(-10)).to.equal(-20);

    });

    it('should return proper value when summing', () => {
        expect(mathEnforcer.sum(10, 4)).to.equal(14);
        expect(mathEnforcer.sum(12, 3)).to.equal(15);
        expect(mathEnforcer.sum(-3, 5.3)).to.be.closeTo(2.3, 0.01);
        expect(mathEnforcer.sum(-1000, 1999)).to.equal(999);

    });
    it('should return undefined  when summing with non Number values', () => {
        expect(mathEnforcer.sum(10, '')).to.be.undefined;
        expect(mathEnforcer.sum([], 1)).to.be.undefined;
        expect(mathEnforcer.sum({}, '')).to.be.undefined;
        expect(mathEnforcer.sum(null, 1.4)).to.be.undefined;
        expect(mathEnforcer.sum(undefined, undefined)).to.be.undefined;
        expect(mathEnforcer.sum(10, 't')).to.be.undefined;

    });

});