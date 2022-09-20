const {expect} = require('chai');
const {} = require('./addsub');

describe('SumSub',()=>{

    let instance = null;

    beforeEach(()=>{
        instance = calc();
    });


    it('should add correctly',()=>{
        instance.add(1);
        expect(instance.get()).to.equal(1);
    });
 
});