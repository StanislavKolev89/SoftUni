package Military.entities;

import Military.interfaces.LieutenantGeneral;
import Military.interfaces.Private;

import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    protected LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);

    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("  Name: %s %s Id: %d Salary: %.2f",this.getFirstName(),this.getLastName(),this.getId(),this.getSalary())).
                append(System.lineSeparator());
        builder.append("Privates:").append(System.lineSeparator());
       privates.stream().sorted(Comparator.comparing(Private::getId).reversed()).forEach(e->builder.append("  ").append(e.toString()).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
