package pl.pjwstk.build;

public class GasContainer extends Container {
    private final String description = "gas container";

    public GasContainer(int weight, ContainerSizeType sizeType, String productType) {
        super(weight, sizeType, productType);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ContainerType:  GasContainer" + gap() + "SERIAL:  " + getSerial() + gap() + super.toString() +
                gap() + "description:  " + description;
    }
}
