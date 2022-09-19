package bakery.repositories.interfaces;

import java.util.Collection;
import java.util.List;

public interface Repository<T> {

    List<T> getAll();

    void add(T t);

}
