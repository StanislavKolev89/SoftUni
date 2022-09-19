package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;
    private Hero hero;
    private Hero hero2;

    @Before
    public void setUp() {
        heroRepository = new HeroRepository();
        hero = new Hero("Nikola", 10);
        hero2 = new Hero("Gabi",12);
    }

    @Test(expected = NullPointerException.class)
    public void testThrowingExceptionWhenCreatingHeroWithNullValue() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowingExceptionWhenCreatingHeroThatAlreadyExist() {
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test
    public void testOfProperCreatingAHero() {
        heroRepository.create(hero);
        Assert.assertEquals(heroRepository.getCount(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testRemovingHeroWithEmptyName() {
        heroRepository.create(hero);
        heroRepository.remove("    ");
    }

    @Test(expected = NullPointerException.class)
    public void testRemovingHeroWithNullValue() {
        heroRepository.create(hero);
        heroRepository.remove(null);
    }
    @Test
    public void properRemovingOfHero(){
        heroRepository.create(hero);
        heroRepository.remove("John");
    }
    @Test
    public void testGettingHeroWithHighestPoints(){
        heroRepository.create(hero);
        heroRepository.create(hero2);
        heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(hero2.getLevel(),12);
    }
    @Test
    public void testGettingHero(){
        heroRepository.create(hero);
        heroRepository.create(hero2);
        heroRepository.getHero("Gabi");
        Assert.assertEquals(hero2.getLevel(),12);
    }
    @Test
    public void testGettingCollection(){
        heroRepository.create(hero);
        heroRepository.create(hero2);
      heroRepository.getHeroes();
    }
}
