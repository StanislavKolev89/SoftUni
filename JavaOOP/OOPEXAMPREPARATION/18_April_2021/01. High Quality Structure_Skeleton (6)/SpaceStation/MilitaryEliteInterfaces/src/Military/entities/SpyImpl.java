package Military.entities;

import Military.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String spyNumber;

    public SpyImpl(int id, String firstName, String lastName, String spyNumber) {
        super(id, firstName, lastName);
        this.spyNumber = spyNumber;
    }

    @Override
    public String getSpyNumber() {
        return this.spyNumber;
    }

    @Override
    public String toString(){
        return String.format("Name: %s %s Id: %d%nCode Number: %s",this.getFirstName(),this.getLastName(),this.getId(),this.getSpyNumber());
    }
}
