package pl.pjwstk.build;

import java.util.Random;

public class ContainerGenerator {
    Random random = new Random();

    public UniversalContainer generateUniversalContainer() {
        ContainerSizeType randomizedSize = randomEnum(ContainerSizeType.class);
        int randomizedWeight = random.nextInt(1000);
        int randomizedNumberOfPackages = random.nextInt(4500);
        return new UniversalContainer(randomizedWeight, randomizedSize, randomizedNumberOfPackages);
    }

    private <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
