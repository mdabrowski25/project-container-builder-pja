package pl.pjwstk.build;

public class InsulatedContainer extends TemperatureControlledContainer {
    private final String description = "for products/objects which require temp -10 to 4";

    public InsulatedContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
        super(weight, sizeType, productType, temperature);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ContainerType:  InsulatedContainer" + gap() + super.toString() + gap() +
                "description:  " + description;
    }
}
