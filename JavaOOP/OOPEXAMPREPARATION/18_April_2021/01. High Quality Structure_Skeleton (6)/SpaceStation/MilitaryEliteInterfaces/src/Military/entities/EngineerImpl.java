package Military.entities;

import Military.interfaces.Engineer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<RepairImpl> repairs;

    protected EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(RepairImpl repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<RepairImpl> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(System.lineSeparator());
        builder.append(String.format("Corps: %s", corps(getCorps()))).append(System.lineSeparator())
                .append("Repairs:").append(System.lineSeparator());
        repairs.stream().forEach(e -> builder.append(e.toString()).append(System.lineSeparator()));
        return builder.toString().trim();
    }

    private String corps(Corps corps) {
        if(corps == Corps.AIRFORCES){
            return "Airforces";
        }
        return "Marines";
    }
}
