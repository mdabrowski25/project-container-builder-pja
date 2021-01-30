package pl.pjwstk.build;

public class PowerSupplyContainer extends Container {
    private final String description = "power generator";

    public PowerSupplyContainer(int weight, ContainerSizeType sizeType, String productType) {
        super(weight, sizeType, productType);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ContainerType:  PowerSupplyContainer" + gap() + "SERIAL:  " + getSerial() + gap() + super.toString() +
                gap() + "description:  " + description;
    }
}
