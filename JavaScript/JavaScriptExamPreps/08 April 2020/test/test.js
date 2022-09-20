const { Repository } = require('./solution');
const { expect } = require('chai');

describe("Test Repository ", function() {
    describe("test1", function() {
        let properties = {
            name: "string",
            age: "number",
            birthday: "object"
        };
        let entity = {
            name: "Pesho",
            age: 22,
            birthday: new Date(1998, 0, 7)
        };
      
        it("should return proper idCount", function() {
         
            let rep = new Repository(properties);
            expect(rep.add(entity)).to.equal(0);
            expect(rep.add(entity)).to.equal(1);    
        });

        it("should return proper idCount", function() {
            let rep = new Repository(properties);
            expect(rep.count).to.equal(0);
        });
        it("should throw error when adding invalid entity ", function() {
            let entity = {
                name: "Pesho",
                age: "22",
                birthday: new Date(1998, 0, 7)
            };
            let rep = new Repository(properties);
            expect( ()=> {rep.add(entity)}).to.throw();
            let entity1 = {
                name: 2,
                age: 22,
             
            };
            expect( ()=> {rep.add(entity1)}).to.throw();
            let entity2 = {
                name: 2,
                age: 22,
                birthday: ''
            };
            expect( ()=> {rep.add(entity1)}).to.throw();
        });

        it("should return proper entity when valid Id is given", function() {
         
            let rep = new Repository(properties);
            rep.add(entity);
            expect(rep.getId(0)).to.equal(entity);
            let entity1= {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            rep.add(entity1);
            expect(rep.getId(1)).to.equal(entity1);
        });
        it("should throw ", function() {
         
            let rep = new Repository(properties);
            let entity1 = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            rep.add(entity1);
            expect(()=> {rep.del(1)}).to.throw();
          
        });
        it("should change entity corectly", function() {
         
            let rep = new Repository(properties);
            rep.add(entity);
            let entity1 = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            
            expect(()=> {rep.update(1,entity1)}).to.throw();

        
        });

        it("should change entity corectly", function() {
         
            let rep = new Repository(properties);
            rep.add(entity);
            let entity1 = {
                name: "Pesho",
                age: 22,
                birthday: 0
            };
            
            expect(()=> {rep.update(1,entity1)}).to.throw();

        
        });
   
     });
     // TODO: …
});