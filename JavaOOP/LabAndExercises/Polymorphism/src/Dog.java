public class Dog extends Animal {

    private String name;
    private String favouriteFood;

    protected Dog(String name, String favouriteFood) {

        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        StringBuilder builder= new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append("DJAAF");
        return builder.toString().trim();
    }


}
