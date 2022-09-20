class Bank {

    constructor(bankName) {
        this._bankName = bankName;
        this.allCustomers = [];
    }

    newCustomer(customer) {

        let customerFound = this.allCustomers.find(c => c.personalId === customer.personalId);

        if (customerFound !== undefined) {
            throw new Error(`${customerFound.firstName} ${customerFound.lastName} is already our customer!`)
        }


        this.allCustomers.push(customer);
        return customer;
    }

    depositMoney(personalId, amount) {
        if (this.allCustomers.length !== 0) {
            let customerFound = this.allCustomers.find(c => c.personalId === personalId);
            if (customerFound === undefined) {
                throw new Error(`We have no customer with this ID!`)
            }

            if (!customerFound.hasOwnProperty("totalMoney")) {
                customerFound.totalMoney = 0;
                customerFound.transactions = [];
            }
            customerFound.totalMoney += amount;
            let obj = {
                n: customerFound.transactions.length + 1,
                message: `${customerFound.transactions.length + 1}. ${customerFound.firstName} ${customerFound.lastName} made deposit of ${amount}$!`
            };
            customerFound.transactions.push(obj);
            return `${customerFound.totalMoney}$`;
        }

    }

    withdrawMoney(personalId, amount) {

        let customerFound = this.allCustomers.find(c => c.personalId === personalId);
        if (customerFound === undefined) {
            throw new Error(`We have no customer with this ID!`)
        }
        if (customerFound.hasOwnProperty("totalMoney")) {

            if (customerFound.totalMoney < amount) {
                throw new Error(`${customerFound.firstName} ${customerFound.lastName} does not have enough money to withdraw that amount!`)
            } else {
                customerFound.totalMoney -= amount;

                let obj = {
                    n: customerFound.transactions.length + 1,
                    message: `${customerFound.transactions.length + 1}. ${customerFound.firstName} ${customerFound.lastName} withdrew ${amount}$!`
                };
                customerFound.transactions.push(obj);
                return `${customerFound.totalMoney}$`;
            }
        }

    }

    customerInfo(personalId) {

        let customerFound = this.allCustomers.find(c => c.personalId === personalId);
        if (customerFound === undefined) {
            throw new Error(`We have no customer with this ID!`)
        }
        let result = [];
        result.push(`Bank name: ${this._bankName}`);
        result.push(`Customer name: ${customerFound.firstName} ${customerFound.lastName}`);
        result.push(`Customer ID: ${customerFound.personalId}`);
        if (!customerFound.hasOwnProperty('totalMoney')) {
            customerFound.totalMoney = 0;
        }
        result.push(`Total Money: ${customerFound.totalMoney}$`);
        if (customerFound.hasOwnProperty('transactions')) {

            result.push(`Transactions:`);
            customerFound.transactions.sort((a, b) => b.n - a.n).forEach(c => result.push(c.message));

        }
        return result.join('\n');


    }
}

let bank = new Bank("SoftUni Bank1");
console.log(bank.customerInfo(6233267));
console.log(bank.newCustomer({ firstName: "Svetlin", lastName: "Nakov", personalId: 6233267 }));
console.log(bank.newCustomer({ firstName: "Mihaela", lastName: "Mileva", personalId: 4151596 }));

bank.depositMoney(6233267, 250);
console.log(bank.depositMoney(6233267, 250));
bank.depositMoney(4151596, 555);

console.log(bank.withdrawMoney(6233267, 125));

console.log(bank.customerInfo(6233267));