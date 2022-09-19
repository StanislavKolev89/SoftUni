package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {

    @Test
    public void createObjectHappyCase() {
        Spaceship star_of_death = new Spaceship("Star of Death", 2000);
        Assert.assertEquals("Star of Death", star_of_death.getName());
        Assert.assertEquals(2000, star_of_death.getCapacity());
        Assert.assertEquals(0, star_of_death.getCount());
    }

    @Test
    public void createObjectNameIsNull() {
        Exception exception = assertThrows(() -> new Spaceship(null, 2000));
        Assert.assertTrue(exception instanceof NullPointerException);
        Assert.assertEquals("Invalid spaceship name!", exception.getMessage());
    }

    @Test
    public void createObjectNameBlank() {
        Exception exception = assertThrows(() -> new Spaceship(" ", 2000));
        Assert.assertTrue(exception instanceof NullPointerException);
        Assert.assertEquals("Invalid spaceship name!", exception.getMessage());
    }

    @Test
    public void createObjectInvalidCapacity() {
        Exception exception = assertThrows(() -> new Spaceship("some", -1));
        Assert.assertTrue(exception instanceof IllegalArgumentException);
        Assert.assertEquals("Invalid capacity!", exception.getMessage());
    }

    @Test
    public void addAstrounaut_capacityReached_expectException() {
        Astronaut astronaut = new Astronaut("John", 100);
        Exception exception = assertThrows(() -> new Spaceship("some", 0).add(astronaut));

        Assert.assertTrue(exception instanceof IllegalArgumentException);
        Assert.assertEquals("Spaceship is full!", exception.getMessage());
    }

    @Test
    public void addAstrounaut_astronautAlreadyExists_expectException() {
        Astronaut astronaut = new Astronaut("John", 100);
        Spaceship spaceship = new Spaceship("Ship", 100);
        spaceship.add(astronaut);
        Exception exception = assertThrows(() -> spaceship.add(astronaut));

        Assert.assertTrue(exception instanceof IllegalArgumentException);
        Assert.assertEquals(String.format("Astronaut %s is already in!", astronaut.getName()), exception.getMessage());
    }

    @Test
    public void addAstrounaut_happyCase_expectCountToBeIncremented() {
        Spaceship spaceship = new Spaceship("Ship", 10);
        Assert.assertEquals(0, spaceship.getCount());
        spaceship.add(new Astronaut("John", 100));
        Assert.assertEquals(1, spaceship.getCount());
    }
    @Test
    public void removeAstronaut_expectCountToBeIncremented() {
        Spaceship spaceship = new Spaceship("Ship", 10);
        Assert.assertFalse(  spaceship.remove(null));

    }

    @Test
    public void removeAstronaut_expectCountToBeDecremented() {
        Spaceship spaceship = new Spaceship("Ship", 10);
        spaceship.add(new Astronaut("John",100));
        Assert.assertTrue(spaceship.remove("John"));

    }

    private Exception assertThrows(Action action) {
        try {
            action.act();
        } catch (Exception e) {
            return e;
        }
        return null;
    }

    private interface Action {
        void act();
    }
}
