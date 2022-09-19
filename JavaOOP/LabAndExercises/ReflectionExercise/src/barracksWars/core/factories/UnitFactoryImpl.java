package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // unitType-> Archer, Pikeman, Swordsman
//        switch (unitType) {
//            case "Archer":
//                return new Archer();
//                case " Pikeman":
//                return new Pikeman();
//                case "Swordsman":
//                return new Swordsman();
//            case "Horseman":
//                return new Horseman();
//            case "Gunner":
//                return new Gunner();
//        }
//        return null;
		Class unitClass = Class.forName(UNITS_PACKAGE_NAME+ unitType);
		Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
		return constructor.newInstance();

    }
}
