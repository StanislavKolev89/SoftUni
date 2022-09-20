const library = require('./library');
const { expect } = require('chai');

describe("Testing Library", function () {
    describe("calcPricePerBook", function () {
        it("should throw error with invalid input", function () {
            expect(() => { library.calcPriceOfBook(1,) }).to.throw();
            expect(() => { library.calcPriceOfBook('str', 1.333) }).to.throw();
            expect(() => { library.calcPriceOfBook('str', 0.33) }).to.throw();
            expect(() => { library.calcPriceOfBook('str', []) }).to.throw();
            expect(() => { library.calcPriceOfBook('str', {}) }).to.throw();
            expect(() => { library.calcPriceOfBook([1], 12) }).to.throw();
            expect(() => { library.calcPriceOfBook({}, 12) }).to.throw();
            expect(() => { library.calcPriceOfBook(undefined, 12) }).to.throw();
            expect(() => { library.calcPriceOfBook(null, 12) }).to.throw();
            expect(() => { library.calcPriceOfBook() }).to.throw();




        });

        it("should calculate properly with valid input", function () {
            expect(library.calcPriceOfBook('book', 1979)).to.equal(`Price of book is 10.00`);
            expect(library.calcPriceOfBook('book', 1980)).to.equal(`Price of book is 10.00`);
            expect(library.calcPriceOfBook('Troy', 1981)).to.equal(`Price of Troy is 20.00`);


        });
    });

    describe("findBook", function () {


        it("should return proper resultwith valid input", function () {
            let array = ["Troy", "Life Style", "Torronto"];
            expect(library.findBook(array, 'Troy')).to.equal("We found the book you want.");
            expect(library.findBook(array, 'Life Style')).to.equal("We found the book you want.");

        });

        it("should return  proper message when book is not present", function () {
            let array = ["Troy", "Life Style", "Torronto"];
            expect(library.findBook(array, 'Trogggy')).to.equal("The book you are looking for is not here!");
            expect(library.findBook(array, 'T')).to.equal("The book you are looking for is not here!");
            expect(library.findBook(array, 'asd')).to.equal("The book you are looking for is not here!");


        });
        it("should throw error is array is empty", function () {
            let array = [];
            expect(() => { library.findBook(array, 'Trogggy') }).to.throw(`No books currently available`);
        });
    });

    describe("arrange the books", function () {



        it("should throw error when input is not a number", function () {

            expect(() => { library.arrangeTheBooks(-3) }).to.throw();
            expect(() => { library.arrangeTheBooks('str') }).to.throw();
            expect(() => { library.arrangeTheBooks('undefined') }).to.throw();
            expect(() => { library.arrangeTheBooks(undefined) }).to.throw();
            expect(() => { library.arrangeTheBooks([]) }).to.throw();
            expect(() => { library.arrangeTheBooks({}) }).to.throw();
            expect(() => { library.arrangeTheBooks(null) }).to.throw();


        });

        it("should work when input is not a number", function () {

            expect(library.arrangeTheBooks(41)).to.equal("Insufficient space, more shelves need to be purchased.");
            expect(library.arrangeTheBooks(40)).to.equal("Great job, the books are arranged.");
            expect(library.arrangeTheBooks(39)).to.equal("Great job, the books are arranged.");


        });

    });
});