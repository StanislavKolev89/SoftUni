package Military.interfaces;

import Military.entities.RepairImpl;

import java.util.Collection;

public interface Engineer extends Private {
    void addRepair(RepairImpl repair);
    Collection<RepairImpl> getRepairs();


}
