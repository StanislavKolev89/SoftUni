package bankSafe;


import jdk.internal.access.JavaSecurityAccess;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankVaultTest {
    private BankVault bankVault;
    private Map<String, Item> items;


    @Before
    public void setUp() {
        bankVault = new BankVault();
        Map<String, Item> items = new LinkedHashMap<>();
        this.items.put("A1", null);
        this.items.put("A2", null);
        this.items.put("A3", null);
        this.items.put("A4", null);
        this.items.put("B1", null);
        this.items.put("B2", null);
        this.items.put("B3", null);
        this.items.put("B4", null);
        this.items.put("C1", null);
        this.items.put("C2", null);
        this.items.put("C3", null);
        this.items.put("C4", null);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_addingNonExistingCell() throws OperationNotSupportedException {
        bankVault.addItem("E5", new Item("George","12"));
    }

    @Test
    public void test_ProperCreating_BankCells() {
        Assert.assertEquals(bankVault.getVaultCells(),items);
    }
}