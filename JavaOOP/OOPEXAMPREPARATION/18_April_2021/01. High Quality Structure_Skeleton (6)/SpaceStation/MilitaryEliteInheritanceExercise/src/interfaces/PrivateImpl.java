package interfaces;

public abstract class PrivateImpl implements Private{

    private int id;
    private String firstName;
    private String lastName;

    protected PrivateImpl(int id, String firstName,String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }


}
