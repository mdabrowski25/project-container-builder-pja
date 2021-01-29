package pl.pjwstk.build;

import java.util.Random;

public class ContainerGenerator {
    Random random = new Random();
    String[] dryProductTypes = {"Currier posts", "pallets", "chests", "cartoons",
            "furniture", "PC parts", "plastic", "toys"};

    public UniversalContainer generateUniversalContainer() {
        ContainerSizeType randomizedSize = randomEnum(ContainerSizeType.class);
        int randomizedWeight = random.nextInt(1500);
        int randomizedNumberOfPackages = random.nextInt(4500);
        String randomizedDryProductType = dryProductTypes[random.nextInt(dryProductTypes.length)];

        return new UniversalContainer(randomizedWeight, randomizedSize,
                randomizedNumberOfPackages, randomizedDryProductType);
    }

    private <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
