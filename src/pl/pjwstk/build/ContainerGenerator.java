package pl.pjwstk.build;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ContainerGenerator {
    Random random = new Random();
    String[] dryProductTypes = {"Currier posts", "pallets", "chests", "cartoons",
            "furniture", "PC hardware", "plastic", "toys"};
    String[] gasProductTypes = {"LPG", "gasoline", "diesel", "LNG", "CNG", "nitrogen", "oil"};
    String[] highTempProductTypes = {"fabrics", "tapes", "cables", "ropes", "sleeves", "tadpoles", "sewing"};
    String[] chilledTempProductTypes = {"bananas", "apples", "grapes", "vaccines", "wine"};
    String[] coldTempProductTypes = {"ice", "ice cream", "seafood", "poultry", "red meat"};
    String[] thermalTempProductTypes = {"paints", "sport balls", "glue"};

    public UniversalContainer generateUniversalContainer() {
        ContainerSizeType randomizedSize = randomSizeEnum();
        int randomizedWeight = random.nextInt((15000 - 6000) + 1) + 6000;
        int randomizedNumberOfPackages = random.nextInt((12000 - 6000) + 1) + 6000;
        String randomizedDryProductType = dryProductTypes[random.nextInt(dryProductTypes.length)];

        return new UniversalContainer(randomizedWeight, randomizedSize,
                randomizedNumberOfPackages, randomizedDryProductType);
    }

    public GasContainer generateGasContainer() {
        ContainerSizeType randomizedSize = randomSizeEnum();
        int randomizedWeight = random.nextInt((15000 - 6000) + 1) + 6000;
        String randomizedGasProductType = gasProductTypes[random.nextInt(gasProductTypes.length)];

        return new GasContainer(randomizedWeight, randomizedSize, randomizedGasProductType);
    }

    public HeatedContainer generateHeatedContainer() {
        ContainerSizeType randomizedSize = randomSizeEnum();
        int randomizedWeight = random.nextInt((15000 - 6000) + 1) + 6000;
        String randomizedHighTempProductType = highTempProductTypes[random.nextInt(highTempProductTypes.length)];
        int randomizedTemp = random.nextInt((25 - 18) + 1) + 18;

        return new HeatedContainer(randomizedWeight, randomizedSize, randomizedHighTempProductType, randomizedTemp);
    }

    public InsulatedContainer generateInsulatedContainer() {
        ContainerSizeType randomizedSize = randomSizeEnum();
        int randomizedWeight = random.nextInt((15000 - 6000) + 1) + 6000;
        String randomizedChilledTempProductType = chilledTempProductTypes[random.nextInt(chilledTempProductTypes.length)];
        int randomizedTemp = ThreadLocalRandom.current().nextInt(-10, 4 + 1);

        return new InsulatedContainer(randomizedWeight, randomizedSize, randomizedChilledTempProductType, randomizedTemp);
    }

    public RefrigeratedContainer generateRefrigeratedContainer() {
        ContainerSizeType randomizedSize = randomSizeEnum();
        int randomizedWeight = random.nextInt((15000 - 6000) + 1) + 6000;
        String randomizedColdTempProductType = coldTempProductTypes[random.nextInt(coldTempProductTypes.length)];
        int randomizedTemp = ThreadLocalRandom.current().nextInt(-25, -11 + 1);

        return new RefrigeratedContainer(randomizedWeight, randomizedSize, randomizedColdTempProductType, randomizedTemp);
    }

    public ThermalContainer generateThermalContainer() {
        ContainerSizeType randomizedSize = randomSizeEnum();
        int randomizedWeight = random.nextInt((15000 - 6000) + 1) + 6000;
        String randomizedThermalTempProductType = thermalTempProductTypes[random.nextInt(thermalTempProductTypes.length)];
        int randomizedTemp = ThreadLocalRandom.current().nextInt(5, 17 + 1);

        return new ThermalContainer(randomizedWeight, randomizedSize, randomizedThermalTempProductType, randomizedTemp);
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
