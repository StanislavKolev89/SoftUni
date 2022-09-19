public class Cat extends Animal{

    private String name;
    private String favouriteFood;

    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        StringBuilder builder= new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append("MEEOW");
        return builder.toString().trim();
    }
}
