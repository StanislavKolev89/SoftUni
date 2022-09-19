import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankVaultTest {

      private BankVault bankVault;
      private Map<String,Item> items;

      @Before
        public void  setUp(){
          bankVault = new BankVault();
          items = new LinkedHashMap<>();
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


      @Test
    public void properCreatingBankVault(){
          Assert.assertEquals(items,this.bankVault.getVaultCells());
          Assert.assertEquals(12,bankVault.getVaultCells().size());
      }

      @Test(expected = IllegalArgumentException.class)
    public void testAddingToNotExistingCell() throws OperationNotSupportedException {
         Assert.assertEquals("Cell doesn't exist!",this.bankVault.addItem("E5", new Item("Gosho", "tasd")));
      }

    @Test
    public void testProperAddingItemToACell() throws OperationNotSupportedException {
        Item item = new Item("Gosho","id");
        Assert.assertEquals("Item:id saved successfully!",this.bankVault.addItem("C1", item));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingToExistingCell() throws OperationNotSupportedException {
          Item item = new Item("Gosho", "tasd");
          Item item1 = new Item("Pesho", "tasd");
        bankVault.addItem("A1", item);
        Assert.assertTrue(bankVault.getVaultCells().containsValue(item));
        Assert.assertEquals("Item is already in cell",bankVault.addItem("A1",item1));
    }


//    @Test(expected = IllegalArgumentException.class)
//    public void testAddingToCellSameItem() throws OperationNotSupportedException {
//          Item item = new Item("Gosho", "tasd");
//        bankVault.addItem("A1", item);
//        bankVault.addItem("A1", item);


    @Test (expected = IllegalArgumentException.class)
    public void test_RemovingNonExistingCell(){
          Assert.assertEquals("Cell doesn't exists!", bankVault.removeItem("D14", new Item("asd","asd")));
    }
    @Test
    public void test_RemovingExistingCell() throws OperationNotSupportedException {
          Item item = new Item("test","id");
          this.bankVault.addItem("A3",item);
          Assert.assertEquals("Remove item:id successfully!",  bankVault.removeItem("A3",item));
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_RemovingNonExistingItemInCell(){

        Assert.assertEquals("Item in that cell doesn't exists!", bankVault.removeItem("A2", new Item("asasd","asasdd")));
    }

}