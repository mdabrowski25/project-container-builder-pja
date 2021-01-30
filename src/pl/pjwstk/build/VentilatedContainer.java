package pl.pjwstk.build;

public class VentilatedContainer extends Container {
    private final String description = "for organic load";

    public VentilatedContainer(int weight, ContainerSizeType sizeType, String productType) {
        super(weight, sizeType, productType);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ContainerType:  VentilatedContainer" + gap() + "SERIAL:  " + getSerial() + gap() + super.toString() +
                gap() + "description:  " + description;
    }
}
