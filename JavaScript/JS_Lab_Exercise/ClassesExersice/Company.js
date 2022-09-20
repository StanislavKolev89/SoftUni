class Company {

    constructor() {
        this.departments = new Map();
    }

    static Employee = class Employee {
        constructor(username, salary, position) {
            this.username = username;
            this.salary = salary;
            this.position = position;
        }

        get username() {
            return this._username;
        }

        get salary() {
            return this._salary;
        }

        get position() {
            return this._position;
        }

        set username(value) {
            if (value === undefined || value === null || value === '') {
                throw new Error('Invalid input!');
            }
            this._username = value;
        }
        set salary(value) {
            if (value === undefined || value === null || value === '' || value<0) {
                throw new Error('Invalid input!');
            }
            this._salary = value;
        }

        set position(value) {
            if (value === undefined || value === null || value === '') {
                throw new Error('Invalid input!');
            }
            this._position = value;
        }

        toString(){
            return `${this._username} ${this._salary} ${this._position}`;
        }

    }

    addEmployee(username, salary, position, department) {
        if (department === undefined || department === null || department === '') {
            throw new Error('Invalid input!');
        }

        if (!this.departments.has(department)) {
            this.departments.set(department, []);
        }
        let employee = new Company.Employee(username, salary, position);
        this.departments.get(department).push(employee);
        return `New employee is hired. Name: ${username}. Position: ${position}`;

    }

    

    bestDepartment() {
        let sorted = [...this.departments].sort(([departementNameA,emloyees1],[departementNameB,emloyees2])=>
            this._getAverage(departementNameB) - this._getAverage(departementNameA)
        );

       let [departmentName, employees] =sorted[0];
     
        let result = `Best Department is: ${departmentName}\n`;
        result+=`Average salary: ${this._getAverage(departmentName)}\n`;
      let sortedEmp=  employees.sort((a,b)=>{
            return b.salary-a.salary === 0? a.username.localeCompare(b.username) : b.salary-a.salary;
        });
      result+=sortedEmp.join('\n');
        return result;
    }


    _getAverage(departmentName){
        let employees = this.departments.get(departmentName);
     return   employees.reduce((acc,worker)=> acc+worker.salary,0)/employees.length;
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");

console.log(c.bestDepartment());