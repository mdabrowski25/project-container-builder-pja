package pl.pjwstk.build;

public enum ContainerSizeType {
    c20("Container 20'", 590,239, 2300),
    c40("Container 40'", 1200, 239, 3750),
    c40hc("Container 40' HIGH CUBE",1200,270, 3850);

    private int weight;
    private int height;
    private String description;
    private int lengthA;

    ContainerSizeType(String description, int lengthA, int height, int weight) {
        this.weight = weight;
        this.height = height;
        this.description = description;
        this.lengthA = lengthA;
        int lengthB = 235;
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
}
