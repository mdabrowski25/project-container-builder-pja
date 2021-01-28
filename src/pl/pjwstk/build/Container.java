package pl.pjwstk.build;

public abstract class Container {
    private int weight;
    private ContainerSizeType sizeType;
    private String serialNumber;

    protected Container(int weight, ContainerSizeType sizeType) {
        this.weight = weight;
        this.sizeType = sizeType;
        this.serialNumber = "CON-";
    }

    protected int getWeight() {
        return weight;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    protected ContainerSizeType getSizeType() {
        return sizeType;
    }

    protected void setSizeType(ContainerSizeType sizeType) {
        this.sizeType = sizeType;
    }

    protected String getSerialNumber() {
        return serialNumber;
    }

    protected void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
