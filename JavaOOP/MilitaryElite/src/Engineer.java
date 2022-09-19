import java.util.Collection;
import java.util.Collections;

public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
