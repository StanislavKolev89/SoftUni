function taxes(name, population, treasury) {
    return {
        name : name,
        population: population,
        treasury: treasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += this.population * this.taxRate;
        },
        applyGrowth(percentage) { this.population += Math.floor(population * percentage / 100); },
        applyRecession(percentage) { this.treasury -= Math.ceil(this.treasury * percentage / 100); }
    };


}


const city = taxes('Sofia', 2000000, 1000000);
console.log(city);
