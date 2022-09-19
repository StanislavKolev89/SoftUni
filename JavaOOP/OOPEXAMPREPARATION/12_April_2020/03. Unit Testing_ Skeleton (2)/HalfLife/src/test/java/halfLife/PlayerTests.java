package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player
    @Test
    public void properCreatingPlayer(){
        Player player = new Player("Ivan",100);
        Assert.assertEquals("Ivan",player.getUsername());
        Assert.assertEquals(100,player.getHealth());

        Assert.assertTrue(player.getGuns().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void test_CathingException_CreatingPlayerWithNameEqualToNull() {
        new Player(null, 100);
    }
    @Test(expected = NullPointerException.class)
    public void test_CathingException_CreatingPlayerWithEmptyName() {
        new Player("    ", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CathingException_CreatingPlayerWithNegativeHealth() {
        new Player("Ivan", -1);
    }

    @Test
    public void properReturningPlayersGunRepository(){
        Player player = new Player("Ivan",100);
        player.addGun(new Gun("Makarov",100));
        Assert.assertTrue(!player.getGuns().isEmpty());
        Assert.assertEquals("Makarov",player.getGuns().get(0).getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_CathingException_PlayerIsDead() {
        Player player =new Player("Ivan", -1);
        player.takeDamage(10);

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_CathingException_PlayerIsDeadaa() {
        Player player =new Player("Ivan", 9);
        player.takeDamage(10);
        player.takeDamage(10);
    }
    @Test

    public void test_properResult_AfterTakingDamage() {
        Player player =new Player("Ivan", 10);
        player.takeDamage(8);
        Assert.assertTrue(player.getHealth()>0);
        Assert.assertEquals(2,player.getHealth());
    }
    @Test(expected = NullPointerException.class)
    public void test_CathingException_AddingGunWithNullValue() {
        Player player =new Player("Ivan", 10);
        player.addGun(null);
    }
    @Test
    public void testProperRemovingGUn(){
        Player player =new Player("Ivan", 100);
        Gun gun = new Gun("Makarov",12);
        player.addGun(gun);

        Assert.assertTrue(player.removeGun(gun));
    }
    @Test
    public void testProperReturningGUn(){
        Player player =new Player("Ivan", 100);
        Gun gun = new Gun("Makarov",12);
        player.addGun(gun);
        Gun makarov = player.getGun("Makarov");
        Assert.assertEquals(12, makarov.getBullets());

    }
    @Test(expected = NullPointerException.class)
    public void testUnproperReturningGUn(){
        Player player =new Player("Ivan", 100);
        Gun gun = new Gun("Makarov",12);
        Gun makarov = player.getGun("Makarov");
        Assert.assertEquals(12, makarov.getBullets());
        Gun aNull = player.getGun("null");
        Assert.assertNull(aNull);

    }

    @Test
    public void test_CheckIfHealthIsZero() {
        Player player = new Player("Ivan", 12);
        player.takeDamage(13);
        Assert.assertEquals(0,player.getHealth());
    }

}
