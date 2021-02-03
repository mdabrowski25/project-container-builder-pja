package pl.pjwstk.target;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class S22118 {
    public static void main(String[] args) {
        AppControl appControl = new AppControl();
        appControl.controlLoop();
    }

    public static class AppControl {
        Option option;
        private Scanner sc = new Scanner(System.in);
        ContainerManagement containerManagement = new ContainerManagement();
        boolean listContainersClicked = false;

        public void setListContainersClicked(boolean listContainersClicked) {
            this.listContainersClicked = listContainersClicked;
        }

        public boolean isListContainersClicked() {
            return listContainersClicked;
        }

        public void controlLoop() {
            do {
                printOptions();
                option = getOption();
                switch (option) {
                    case EXIT:
                        exit();
                        break;
                    case LIST_CONTAINERS:
                        containerManagement.listAllContainers();
                        setListContainersClicked(true);
                        break;
                    case SORTED_CONTAINERS:
                        if (isListContainersClicked()) {
                            containerManagement.getAndSortContainers();
                            System.out.println("Manifest utworzony \n");
                        } else {
                            System.out.println("Najpierw nalezy wygenerowac liste kontenerow!!! \n");
                        }
                        break;
                    default:
                        System.out.println("Wybrano bledna opcje");
                }
            } while (option != Option.EXIT);
        }

        private Option getOption() {
            boolean optionOk = false;
            Option option = null;
            while (!optionOk) {
                try {
                    option = Option.createFromInt(getInt());
                    optionOk = true;
                } catch (NoSuchOptionException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Wprowadzono wartosc ktora nie jest liczba podaj ponownie");
                }
            }
            return option;
        }

        private int getInt() {
            try {
                return sc.nextInt();
            } finally {
                sc.nextLine();
            }
        }


        private void printOptions() {
            System.out.println("Wybierz opcje:");
            for (Option element : Option.values()) {
                System.out.println(element.toString());
            }
        }

        public void exit() {
            System.out.println("Koniec programu");
            sc.close();
        }

        public enum Option {
            EXIT(0, "wyjscie z programu"),
            LIST_CONTAINERS(1, "wygeneruj liste wszystkich kontenerow (containerList.txt) i ja wyswietl"),
            SORTED_CONTAINERS(2, "generuj plik manifest (kolejnosc zaladunku)");

            private final int value;
            private final String description;

            Option(int value, String description) {
                this.value = value;
                this.description = description;
            }

            @Override
            public String toString() {
                return value + " - " + description;
            }

            static Option createFromInt(int option) throws NoSuchOptionException {
                try {
                    return Option.values()[option];
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchOptionException("Brak opcji o ID: " + option);
                }
            }
        }
    }

    public static class ContainerGenerator {
        private final Random random = new Random();
        private final String[] dryProductTypes = {"Currier posts", "pallets", "chests", "cartoons",
                "furniture", "PC hardware", "plastic", "toys"};
        private final String[] gasProductTypes = {"LPG", "gasoline", "diesel", "LNG", "CNG", "nitrogen", "oil"};
        private final String[] highTempProductTypes = {"fabrics", "tapes", "cables", "ropes", "sleeves", "tadpoles", "sewing"};
        private final String[] chilledTempProductTypes = {"bananas", "apples", "grapes", "vaccines", "wine"};
        private final String[] coldTempProductTypes = {"ice", "ice cream", "seafood", "poultry", "red meat"};
        private final String[] thermalTempProductTypes = {"paints", "sport balls", "glue"};
        private final String[] ventilatedProductTypes = {"animals", "coffee beans", "garlic"};

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

        public PowerSupplyContainer generatePowerSupplyContainer() {
            ContainerSizeType randomizedSize = randomSizeEnum();
            int randomizedWeight = random.nextInt((14000 - 7500) + 1) + 7500;

            return new PowerSupplyContainer(randomizedWeight, randomizedSize, "kW");
        }

        public VentilatedContainer generateVentilatedContainer() {
            ContainerSizeType randomizedSize = randomSizeEnum();
            int randomizedWeight = random.nextInt((15000 - 6000) + 1) + 6000;
            String randomizedVentilatedProductType = ventilatedProductTypes[random.nextInt(ventilatedProductTypes.length)];

            return new VentilatedContainer(randomizedWeight, randomizedSize, randomizedVentilatedProductType);
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

        public int randomNumberTo8() {
            return random.nextInt(9);
        }
    }

    public static class ContainerManagement {
        public static boolean isListCreated = false;

        public void listAllContainers() {
            Container[] containers = produceOrReadContainers();
            for (Container container : containers) {
                System.out.println(container.toString());
            }
        }

        private Container[] produceOrReadContainers() {
            Container[] list = new Container[15000];
            ContainersDto containersDto;
            String fileName = "containerList.txt";
            File file = new File(fileName);
            try {
                if (file.exists()) {
                    isListCreated = true;
                } else {
                    boolean newFileBoolean = file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!isListCreated) {
                file = new File(fileName);
                String serializedFileName = "serializedContainers.obj";
                try (
                        var fileWriter = new FileWriter(file);
                        var bufferedWriter = new BufferedWriter(fileWriter);
                        var writer = new PrintWriter(bufferedWriter);
                        var fileOutputStream = new FileOutputStream(serializedFileName);
                        var objectOutputStream = new ObjectOutputStream(fileOutputStream)
                ) {
                    ContainerGenerator containerGenerator = new ContainerGenerator();
                    for (int i = 0; i < list.length; i++) {
                        int randomNumberTo8 = containerGenerator.randomNumberTo8();
                        generateRandomContainerAndAdd(containerGenerator, list, i, randomNumberTo8, writer);
                    }
                    containersDto = new ContainersDto(list);
                    objectOutputStream.writeObject(containersDto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                list = getContainers();
            }
            return list;
        }

        private Container[] getContainers() {
            Container[] list = new Container[15000];
            ContainersDto containersDto;
            try (
                    var fileInputStream = new FileInputStream("serializedContainers.obj");
                    var objectInputStream = new ObjectInputStream(fileInputStream)
            ) {
                containersDto = (ContainersDto) objectInputStream.readObject();
                list = containersDto.getContainers();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return list;
        }

        public void getAndSortContainers() {
                Container[] containers = getContainers();
                int c20counter = 0;
                int c40counter = 0;
                for (Container container : containers) {
                    if (container.getSizeType().equals(ContainerSizeType.c20)) {
                        c20counter++;
                    } else {
                        c40counter++;
                    }
                }
                Container[] containersC20 = new Container[c20counter];
                Container[] containersC40 = new Container[c40counter];
                int index20Counter = 0;
                int index40Counter = 0;
                for (Container container : containers) {
                    if (container.getSizeType().equals(ContainerSizeType.c20)) {
                        containersC20[index20Counter++] = container;
                    } else {
                        containersC40[index40Counter++] = container;
                    }
                }
                containerArrayBubbleSort(containersC20);
                containerArrayBubbleSort(containersC40);
                generateManifest(containersC20, containersC40);
        }

        private void generateManifest(Container[] containers20, Container[] containers40) {
            String fileName = "manifest.txt";
            File file = new File(fileName);
            try (
                    var fileWriter = new FileWriter(file);
                    var bufferedWriter = new BufferedWriter(fileWriter);
                    var writer = new PrintWriter(bufferedWriter)
            ) {
                boolean newFileCreated = file.createNewFile();
                Position position = new Position(1, 1, 1);
                manifestWriter(containers20, writer, position);
                position.setRow(position.getRow() + 1);
                manifestWriter(containers40, writer, position);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void manifestWriter(Container[] containers, PrintWriter writer, Position position) {
            String line;
            int reverseCounter = containers.length - 1;
            for (int i = 0; i < containers.length; i++) {
                if (i % 2 == 0) {
                    line = "SERIAL: " + containers[i].getSerial() + "  " + position.toString() + "  weight: " +
                            containers[i].getWeight() + "  product: " + containers[i].getProductType() +
                            "  sizeType: " + containers[i].getSizeType();
                } else {
                    line = "SERIAL: " + containers[reverseCounter].getSerial() + "  " + position.toString() +
                            "  weight: " + containers[reverseCounter].getWeight() + "  product: " +
                            containers[reverseCounter].getProductType() + "  sizeType: " +
                            containers[reverseCounter--].getSizeType();
                }
                if (position.getColumn() < 40) {
                    position.setColumn(position.getColumn() + 1);
                } else if (position.getRow() < 75) {
                    position.setRow(position.getRow() + 1);
                    position.setColumn(1);
                } else {
                    position.setLevel(position.getLevel() + 1);
                    position.setRow(1);
                    position.setColumn(1);
                }
                writer.write(line + "\n");
            }
        }

        private void containerArrayBubbleSort(Container[] containers) {
            Container container;
            for (int i = 0; i < containers.length; i++) {
                for (int j = 0; j < (containers.length - i - 1); j++) {
                    if (containers[j].getWeight() > containers[j + 1].getWeight()) {
                        container = containers[j];
                        containers[j] = containers[j + 1];
                        containers[j + 1] = container;
                    }
                }
            }
        }

        private void generateRandomContainerAndAdd(ContainerGenerator containerGenerator, Container[] list, int i, int randomNumberTo8, PrintWriter writer) {
            switch (randomNumberTo8) {
                case 1:
                    UniversalContainer universalContainer = containerGenerator.generateUniversalContainer();
                    list[i] = universalContainer;
                    writer.write(universalContainer.toString() + "\n");
                    break;
                case 2:
                    GasContainer gasContainer = containerGenerator.generateGasContainer();
                    list[i] = gasContainer;
                    writer.write(gasContainer.toString() + "\n");
                    break;
                case 3:
                    HeatedContainer heatedContainer = containerGenerator.generateHeatedContainer();
                    list[i] = heatedContainer;
                    writer.write(heatedContainer.toString() + "\n");
                    break;
                case 4:
                    InsulatedContainer insulatedContainer = containerGenerator.generateInsulatedContainer();
                    list[i] = insulatedContainer;
                    writer.write(insulatedContainer.toString() + "\n");
                    break;
                case 5:
                    RefrigeratedContainer refrigeratedContainer = containerGenerator.generateRefrigeratedContainer();
                    list[i] = refrigeratedContainer;
                    writer.write(refrigeratedContainer.toString() + "\n");
                    break;
                case 6:
                    ThermalContainer thermalContainer = containerGenerator.generateThermalContainer();
                    list[i] = thermalContainer;
                    writer.write(thermalContainer.toString() + "\n");
                    break;
                case 7:
                    PowerSupplyContainer powerSupplyContainer = containerGenerator.generatePowerSupplyContainer();
                    list[i] = powerSupplyContainer;
                    writer.write(powerSupplyContainer.toString() + "\n");
                    break;
                default:
                    VentilatedContainer ventilatedContainer = containerGenerator.generateVentilatedContainer();
                    list[i] = ventilatedContainer;
                    writer.write(ventilatedContainer.toString() + "\n");
                    break;
            }
        }
    }


    public static abstract class Container implements Serializable {
        private static final long serialVersionUID = 91283569185360L;

        private int weight;
        private ContainerSizeType sizeType;
        private String productType;
        private int serial;
        public static int counter = 1;

        protected Container(int weight, ContainerSizeType sizeType, String productType) {
            this.productType = productType;
            this.serial = generateId();
            this.weight = weight + sizeType.getWeight();
            this.sizeType = sizeType;
        }

        private int generateId() {
            return counter++;
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

        protected String getProductType() {
            return productType;
        }

        protected void setProductType(String productType) {
            this.productType = productType;
        }

        protected int getSerial() {
            return serial;
        }

        protected void setSerial(int serial) {
            this.serial = serial;
        }

        @Override
        public String toString() {
            return "productType:  " + productType + gap() + "weight:  " + weight + gap() +
                    "sizeType:  " + sizeType;
        }

        protected String gap() {
            return "    ";
        }
    }

    public static class GasContainer extends Container {
        private final String description = "gas container";

        public GasContainer(int weight, ContainerSizeType sizeType, String productType) {
            super(weight, sizeType, productType);
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "ContainerType:  GasContainer" + gap() + "SERIAL:  " + getSerial() + gap() + super.toString() +
                    gap() + "description:  " + description;
        }
    }

    public static class HeatedContainer extends TemperatureControlledContainer {
        private final String description = "for products/objects which require temp 18-25";

        protected HeatedContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
            super(weight, sizeType, productType, temperature);
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "ContainerType:  HeatedContainer" + gap() + super.toString() + gap() +
                    "description:  " + description;
        }
    }

    public static class InsulatedContainer extends TemperatureControlledContainer {
        private final String description = "for products/objects which require temp -10 to 4";

        public InsulatedContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
            super(weight, sizeType, productType, temperature);
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "ContainerType:  InsulatedContainer" + gap() + super.toString() + gap() +
                    "description:  " + description;
        }
    }

    public static abstract class TemperatureControlledContainer extends Container {
        private int temperature;

        protected TemperatureControlledContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
            super(weight, sizeType, productType);
            this.temperature = temperature;
        }

        protected int getTemperature() {
            return temperature;
        }

        protected void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        @Override
        public String toString() {
            return "SERIAL:  " + getSerial() + gap() + "temperature:  " + temperature + gap() + super.toString();
        }
    }

    public static class PowerSupplyContainer extends Container {
        private final String description = "power generator";

        public PowerSupplyContainer(int weight, ContainerSizeType sizeType, String productType) {
            super(weight, sizeType, productType);
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "ContainerType:  PowerSupplyContainer" + gap() + "SERIAL:  " + getSerial() + gap() + super.toString() +
                    gap() + "description:  " + description;
        }
    }

    public static class RefrigeratedContainer extends TemperatureControlledContainer {
        private final String description = "for products/objects which require temp -25 to -11";

        public RefrigeratedContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
            super(weight, sizeType, productType, temperature);
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "ContainerType:  RefrigeratedContainer" + gap() + super.toString() + gap() +
                    "description:  " + description;
        }
    }

    public static class ThermalContainer extends TemperatureControlledContainer {
        private final String description = "for products/objects which require temp 5-17";

        public ThermalContainer(int weight, ContainerSizeType sizeType, String productType, int temperature) {
            super(weight, sizeType, productType, temperature);
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "ContainerType:  ThermalContainer" + gap() + super.toString() + gap() + "description:  " + description;
        }
    }

    public static class UniversalContainer extends Container {
        private final String description = "DRY general";
        private int numberOfPackages;

        public UniversalContainer(int weight, ContainerSizeType sizeType, int numberOfPackages, String productType) {
            super(weight, sizeType, productType);
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
            return "ContainerType:  UniversalContainer" + gap() + "SERIAL:  " + getSerial() + gap() +
                    "numberOfPackages:  " + numberOfPackages + gap() + super.toString() + gap() +
                    "description:  " + description;
        }
    }

    public static class VentilatedContainer extends Container {
        private final String description = "for organic load";

        public VentilatedContainer(int weight, ContainerSizeType sizeType, String productType) {
            super(weight, sizeType, productType);
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "ContainerType:  VentilatedContainer" + gap() + "SERIAL:  " + getSerial() + gap() + super.toString() +
                    gap() + "description:  " + description;
        }
    }

    public enum ContainerSizeType {
        c20("Container 20'", 590, 235, 239, 2300),
        c40("Container 40'", 1200, 235, 239, 3750),
        c40hc("Container 40' HIGH CUBE", 1200, 235, 270, 3850);

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

    public static class NoSuchOptionException extends Exception {
        public NoSuchOptionException() {
        }

        public NoSuchOptionException(String message) {
            super(message);
        }
    }


    public static class Position {
        private int row;
        private int column;
        private int level;

        public Position(int row, int column, int level) {
            this.column = column;
            this.level = level;
            this.row = row;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public int getLevel() {
            return level;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "row: " + row +
                    "  column: " + column +
                    "  level: " + level;
        }
    }

    public static class ContainersDto implements Serializable {
        private Container[] containers;

        public ContainersDto(Container[] containers) {
            this.containers = containers;
        }

        public Container[] getContainers() {
            return containers;
        }

        public void setContainers(Container[] containers) {
            this.containers = containers;
        }
    }


}
