package bakery.repositories.interfaces;

import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public  class TableRepositoryImpl implements TableRepository{
    private List<Table> tables;


    public TableRepositoryImpl(){
        this.tables = new ArrayList<>();
    }
    @Override
    public List getAll() {
        return this.tables;
    }

    @Override
    public void add(Table table) {
        this.tables.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        return  tables.stream().filter(e->e.getTableNumber() == number).findFirst().orElse(null);
    }
}
