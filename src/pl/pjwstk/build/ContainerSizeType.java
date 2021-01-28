package pl.pjwstk.build;

public enum ContainerSizeType {
    c20("Container 20'", 590,239),
    c40("Container 40'", 1200, 239),
    c40hc("Container 40' HIGH CUBE",1200,270);

    ContainerSizeType(String description, int lengthA, int height) {
        int lengthB = 235;
    }
}
