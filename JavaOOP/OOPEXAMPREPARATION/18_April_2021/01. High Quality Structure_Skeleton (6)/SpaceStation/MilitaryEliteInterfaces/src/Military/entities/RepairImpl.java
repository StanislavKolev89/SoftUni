package Military.entities;

import Military.interfaces.Repair;

public class RepairImpl implements Repair {

    private String name;
    private int hoursWorked;

    public RepairImpl(String name, int hoursWorked) {
        this.name = name;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.name;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }
    @Override
    public String toString(){
        return String.format("  Part Name: %s Hours Worked: %d",this.getPartName(),this.getHoursWorked());
    }
}
