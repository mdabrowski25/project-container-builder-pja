package pl.pjwstk.build;


import java.util.Objects;

public class UniversalContainer extends Container {
    private final String description = "DRY general";
    private int numberOfPackages;

    public UniversalContainer(int weight, ContainerSizeType sizeType, int numberOfPackages, String productType) {
        super(weight, sizeType, productType);
        this.numberOfPackages = numberOfPackages;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfPackages() {
        return numberOfPackages;
    }

    public void setNumberOfPackages(int numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    @Override
    public String toString() {
        return " UniversalContainer {" + " SERIAL: "  + getSerial() +
                ", description = " + description +
                ", numberOfPackages = " + numberOfPackages + ", " + super.toString() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversalContainer that = (UniversalContainer) o;
        return numberOfPackages == that.numberOfPackages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, numberOfPackages);
    }
}
