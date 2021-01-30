package pl.pjwstk.build;

import java.util.Random;

public class ContainerGenerator {
    Random random = new Random();
    String[] dryProductTypes = {"Currier posts", "pallets", "chests", "cartoons",
            "furniture", "PC parts", "plastic", "toys"};
    String[] gasProductTypes = {"LPG", "gasoline", "diesel", "LNG", "CNG", "nitrogen", "oil"};

    public UniversalContainer generateUniversalContainer() {
        ContainerSizeType randomizedSize = randomSizeEnum();
        int randomizedWeight = random.nextInt(1500);
        int randomizedNumberOfPackages = random.nextInt(4500);
        String randomizedDryProductType = dryProductTypes[random.nextInt(dryProductTypes.length)];

        return new UniversalContainer(randomizedWeight, randomizedSize,
                randomizedNumberOfPackages, randomizedDryProductType);
    }

    public GasContainer generateGasContainer() {
        ContainerSizeType randomizedSize = randomSizeEnum();
        int randomizedWeight = random.nextInt(2700);
        String randomizedGasProductType = gasProductTypes[random.nextInt(gasProductTypes.length)];

        return new GasContainer(randomizedWeight, randomizedSize, randomizedGasProductType);
    }

    private ContainerSizeType randomSizeEnum() {
        int i = random.nextInt(4);
        switch (i) {
            case 1:
                return ContainerSizeType.c20;
            case 2:
                return ContainerSizeType.c40hc;
            default:
                return ContainerSizeType.c40;
        }
    }
}
