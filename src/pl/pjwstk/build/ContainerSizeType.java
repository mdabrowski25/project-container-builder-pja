package pl.pjwstk.build;

public enum ContainerSizeType {
    c20("Container 20'", 590,235,239, 2300),
    c40("Container 40'", 1200, 235,239, 3750),
    c40hc("Container 40' HIGH CUBE",1200,235,270, 3850);

    private final int weight;
    private final int height;
    private final String description;
    private final int lengthA;
    private final int lengthB;

    ContainerSizeType(String description, int lengthA, int lengthB, int height, int weight) {
        this.weight = weight;
        this.height = height;
        this.description = description;
        this.lengthA = lengthA;
        this.lengthB = lengthB;
    }

    int getWeight() {
        return weight;
    }

    int getHeight() {
        return height;
    }

    String getDescription() {
        return description;
    }

    int getLengthA() {
        return lengthA;
    }

    int getLengthB() {
        return lengthB;
    }
}
