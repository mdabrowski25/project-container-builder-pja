package pl.pjwstk.build;

public class HeatedContainer extends TemperatureControlledContainer {
    private final String description = "for products/objects which require temp 18-25";

    protected HeatedContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
        super(weight, sizeType, productType, temperature);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ContainerType:  HeatedContainer" + gap() + super.toString() + gap() +
                "description:  " + description;
    }
}
