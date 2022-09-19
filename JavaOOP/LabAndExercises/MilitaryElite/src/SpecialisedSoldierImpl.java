public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastname, double salary, Corps corps) {
        super(id, firstName, lastname, salary);
        this.corps = corps;
    }
}
