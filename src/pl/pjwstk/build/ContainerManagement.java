package pl.pjwstk.build;

import java.io.*;

public class ContainerManagement {
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
        String serializedFileName = "serializedContainers.obj";
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
                    generateContainerAndAdd(containerGenerator, list, i, randomNumberTo8, writer);
                }
                containersDto = new ContainersDto(list);
                objectOutputStream.writeObject(containersDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (
                    var fileInputStream = new FileInputStream(serializedFileName);
                    var objectInputStream = new ObjectInputStream(fileInputStream)
            ) {
                containersDto = (ContainersDto) objectInputStream.readObject();
                list = containersDto.getContainers();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    private void generateContainerAndAdd(ContainerGenerator containerGenerator, Container[] list, int i, int randomNumberTo8, PrintWriter writer) {
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

    public void getAndSortContainers() {

    }
}
