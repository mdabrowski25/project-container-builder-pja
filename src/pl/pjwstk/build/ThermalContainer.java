package pl.pjwstk.build;

public class ThermalContainer extends TemperatureControlledContainer {
    private final String description = "for products/objects which require temp 5-17";

    public ThermalContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
        super(weight, sizeType, productType, temperature);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ContainerType:  ThermalContainer" + gap() +  super.toString() + gap() + "description:  " + description;
    }
}
