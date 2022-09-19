package CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine,String color) {
        this(model, engine, 0,color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;

    }


    @Override
    public String toString(){
        StringBuilder object = new StringBuilder();
        object.append(this.model+":").append("\n");
        object.append(engine.getModel()).append(":").append("\n");
        object.append("Power: ").append( this.engine.getHorsePower()).append("\n");
        object.append("Displacement: ").append((this.engine.getDisplacement()!=0)? this.engine.getDisplacement(): "n/a").append("\n");
        object.append("Efficiency: ").append(this.engine.getEfficiency()).append("\n");
        object.append(("Weight: ")).append((this.weight!=0)? this.weight: "n/a").append("\n");
        object.append("Color: ").append(this.color);
        return  object.toString();
    }
}
