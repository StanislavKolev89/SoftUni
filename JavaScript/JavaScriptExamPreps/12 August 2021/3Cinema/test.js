const { expect } = require('chai');

const { cinema } = require('./cinema');

describe("Cinema ", function () {


    describe("Show Movie", function () {

        it("should return a message with empty array", function () {
            expect(cinema.showMovies([])).to.equal('There are currently no movies to show.');
        });

        it("should return an array with movies", function () {
            expect(cinema.showMovies(['as', 'df'])).to.equal('as, df');
        });
    });

    describe("Ticket Price", function () {

        it("should return proper price with valid projection", function () {
            expect(cinema.ticketPrice('Premiere')).to.equal(12.00);
            expect(cinema.ticketPrice('Normal')).to.equal(7.50);
            expect(cinema.ticketPrice('Discount')).to.equal(5.50);
        });

        it("should throw  an error with invalid data", function () {
            expect(() => cinema.ticketPrice('null')).to.throw('Invalid projection type.');
            expect(() => cinema.ticketPrice(undefined)).to.throw('Invalid projection type.');
            expect(() => cinema.ticketPrice('sasd')).to.throw('Invalid projection type.');
            expect(() => cinema.ticketPrice(0)).to.throw('Invalid projection type.');
        });
    });

    describe("Swap Seats", function () {

        it("should swap correctly with valid numbers", function () {
            expect(cinema.swapSeatsInHall(2, 12)).to.equal(`Successful change of seats in the hall.`);
            expect(cinema.swapSeatsInHall(20, 11)).to.equal(`Successful change of seats in the hall.`);
            expect(cinema.swapSeatsInHall(2, 1)).to.equal(`Successful change of seats in the hall.`);
        });

        it("should return unsiccessful message with invalid data", function () {
            expect(cinema.swapSeatsInHall(0, 21)).to.equal(`Unsuccessful change of seats in the hall.`);
            expect(cinema.swapSeatsInHall(null, 1)).to.equal(`Unsuccessful change of seats in the hall.`);
            expect(cinema.swapSeatsInHall(1, null)).to.equal(`Unsuccessful change of seats in the hall.`);
            expect(cinema.swapSeatsInHall(1, undefined)).to.equal(`Unsuccessful change of seats in the hall.`);
            expect(cinema.swapSeatsInHall(1, '')).to.equal(`Unsuccessful change of seats in the hall.`);

        });
    });

});