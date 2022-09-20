class Restaurant {

    constructor(budgetMoney) {
        this.budgetMoney = budgetMoney;
        this.menu = new Map();
        this.stockProducts = {};
        this.history = [];
    }

    loadProducts(array) {
        for (const input of array) {
            let [product, quantity, productPrice] = input.split(' ');
            quantity = Number(quantity);
            productPrice = Number(productPrice);

            if (productPrice <= this.budgetMoney) {
                if (!this.stockProducts.hasOwnProperty(product)) {
                    this.stockProducts[product] = 0;
                }
                let current = this.stockProducts[product];
                this.stockProducts[product] = current + quantity;

                this.budgetMoney -= productPrice;
                this.history.push(`Successfully loaded ${quantity} ${product}`)
            } else {
                this.history.push(`There was not enough money to load ${quantity} ${product}`)
            }
        }
        return this.history.join('\n');
    }

    addToMenu(meal, products, price) {

        if (!this.menu.has(meal)) {
            this.menu.set(meal, { products, price })
            if (this.menu.size == 1) {
                return `Great idea! Now with the ${meal} we have 1 meal in the menu, other ideas?`
            } else {
                return `Great idea! Now with the ${meal} we have ${this.menu.size} meals in the menu, other ideas?`
            }
        } else {
            return `The ${meal} is already in the our menu, try something different.`
        }
    }

    showTheMenu() {
        let result = [];
        if (this.menu.size == 0) {
            return "Our menu is not ready yet, please come later...";
        } else {
            for (let [key, value] of this.menu) {
                result.push(`${key} - $ ${value.price}`);
            }
        }
        return result.join('\n')
    }

    makeTheOrder(meal) {
        let canNotMakeTheMeal = false;
        let productsNeeded = this.menu.get(meal).products;
        if (!this.menu.has(meal)) {
            return `There is not ${meal} yet in our menu, do you want to order something else?`
        } else {

            for (let tuple of productsNeeded) {
                let product = tuple.split(' ')[0];
                let quantityNeeded = Number(tuple.split(' ')[1]);
                let quantityInStock = this.stockProducts[product];
                if (!this.stockProducts.hasOwnProperty(product) || quantityNeeded > quantityInStock) {
                    canNotMakeTheMeal = true;
                    return `For the time being, we cannot complete your order (${meal}), we are very sorry...`
                }

            }
        }
            if (!canNotMakeTheMeal) {
                for (let tuple of productsNeeded) {
                    let product = tuple.split(' ')[0];
                    let quantityNeeded = Number(tuple.split(' ')[1]);
                    let current = this.stockProducts[product];
                    this.stockProducts[product] = current - quantityNeeded;
                }
                this.budgetMoney += this.menu.get(meal).price;
                return `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${this.menu.get(meal).price}.`
            }
        


    }
}

let kitchen = new Restaurant(1000);
kitchen.loadProducts(['Yogurt 30 3', 'Honey 50 4', 'Strawberries 20 10', 'Banana 5 1']);
console.log(kitchen.budgetMoney);
kitchen.addToMenu('frozenYogurt', ['Yogurt 1', 'Honey 1', 'Banana 1', 'Strawberries 10'], 9.99);
console.log(kitchen.budgetMoney);
console.log(kitchen.makeTheOrder('frozenYogurt'));
console.log(kitchen.budgetMoney);
