public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastname, double salary) {
        super(id, firstName, lastname);
        this.salary = salary;

    }

    @Override
    public double getSalary() {
        return this.salary;
    }


}
