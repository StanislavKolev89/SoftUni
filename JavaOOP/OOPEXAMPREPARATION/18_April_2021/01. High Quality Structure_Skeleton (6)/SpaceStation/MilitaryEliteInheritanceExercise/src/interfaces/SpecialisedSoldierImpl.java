package interfaces;
public class SpecialisedSoldierImpl extends LieutenantGeneralImpl{
    private Corp corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName,Corp corp) {
        super(id, firstName, lastName);
        this.corp = corp;
    }
}
