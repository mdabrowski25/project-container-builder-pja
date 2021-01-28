package pl.pjwstk.build;

public class UniversalContainer extends Container {
    private final String description = "general purpose container for dry packages";
    private int numberOfPackages;

    public UniversalContainer(int weight, ContainerSizeType sizeType, int numberOfPackages) {
        super(weight, sizeType);
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
}
