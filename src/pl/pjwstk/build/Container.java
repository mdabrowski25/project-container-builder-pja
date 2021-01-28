package pl.pjwstk.build;

public abstract class Container {
    private int weight;
    private ContainerSizeType sizeType;

    protected Container(int weight, ContainerSizeType sizeType) {
        this.weight = weight + sizeType.getWeight();
        this.sizeType = sizeType;

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

    @Override
    public String toString() {
        return "weight=" + weight +
                ", sizeType=" + sizeType;
    }
}
