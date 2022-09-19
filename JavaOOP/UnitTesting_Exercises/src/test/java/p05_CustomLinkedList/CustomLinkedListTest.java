package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Test;

public class CustomLinkedListTest {
    private CustomLinkedList<String> linkedList;

    @Test
    public void tryingToAddItemToTheList(){
        linkedList = new CustomLinkedList();
        linkedList.add("Gosho");
        linkedList.add("Maria");
        linkedList.get(1);

    }
    @Test
    public void tryingToSetItemToTheList(){
        linkedList = new CustomLinkedList();
        linkedList.add("Gosho");
        linkedList.add("Maria");
        linkedList.set(1,"Maria");
        Assert.assertEquals("Maria",linkedList.get(1));

    }

    @Test (expected = IllegalArgumentException.class)

    public void tryingToGetInvalidIndex(){
        linkedList = new CustomLinkedList();
        linkedList.add("asdasd");
        linkedList.get(1);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void tryingToSetItemAtInvalidIndex(){
        linkedList = new CustomLinkedList<>();
        linkedList.add("Gosho");
        linkedList.set(1,"asdasd");
    }


@Test
    public void tryingToGetIndexOfItem(){
    linkedList = new CustomLinkedList();
    linkedList.add("Gosho");
    Assert.assertEquals(linkedList.indexOf("Petar"),-1);
    linkedList.add("Maria");linkedList.indexOf("Maria");
    Assert.assertEquals(linkedList.indexOf("Maria"),1);
}
@Test
    public void checkIfContainsItem(){
    linkedList = new CustomLinkedList();
    linkedList.add("Gosho");
    linkedList.add("Maria");
    Assert.assertTrue(linkedList.contains("Gosho"));
    Assert.assertTrue(linkedList.contains("Maria"));
    Assert.assertFalse(linkedList.contains("Mariaaaa"));
}

@Test

    public void tryingToRemoveItemCorrectly(){
        linkedList = new CustomLinkedList<>();
        linkedList.add("Shosho");
        linkedList.add("Gosho");
        linkedList.remove("Gosho");
        Assert.assertEquals(linkedList.get(0),"Shosho");
    int peter = linkedList.remove("Peter");
    Assert.assertEquals(-1,peter);
}

@Test(expected = IllegalArgumentException.class)
    public void testOfCatchingExceptionWhenTryingToRemoveInvalidIndex(){
    linkedList = new CustomLinkedList<>();
    linkedList.add("Shosho");
    linkedList.add("Gosho");
    linkedList.removeAt(2);
}

@Test
    public void testOfRemovingExistingElementFromList(){
    linkedList = new CustomLinkedList<>();
    linkedList.add("Shosho");
    linkedList.add("Gosho");
    String actual = linkedList.removeAt(1);
    Assert.assertEquals("Gosho",actual);
}
@Test
    public void tryingTogetCount(){
        linkedList = new CustomLinkedList<>();
    int count = linkedList.getCount();
    Assert.assertEquals(0,count);

}


}