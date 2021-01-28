package pl.pjwstk.build;


public class UniversalContainer extends Container {
    private final String description = "DRY general";
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

    @Override
    public String toString() {
        return " UniversalContainer{" +
                "description='" + description + '\'' +
                ", numberOfPackages=" + numberOfPackages + ", " + super.toString() + '}';
    }
}
