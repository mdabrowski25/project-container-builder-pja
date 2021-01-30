package pl.pjwstk.build;

public class RefrigeratedContainer extends TemperatureControlledContainer {
    private final String description = "for products/objects which require temp -25 to -11";

    public RefrigeratedContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
        super(weight, sizeType, productType, temperature);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ContainerType:  RefrigeratedContainer" + gap() + super.toString() + gap() +
                "description:  " + description;
    }
}
