package bakery.repositories.interfaces;

import bakery.entities.tables.interfaces.Table;

public interface TableRepository extends Repository<Table> {
    Table getByNumber(int number);
}
