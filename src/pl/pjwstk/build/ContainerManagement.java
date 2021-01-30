package pl.pjwstk.build;

import java.io.*;

public class ContainerManagement {
    public static boolean isListCreated = false;


    public void listAllContainers() {
        Container[] containers = produceContainers();
        for (Container container : containers) {
            System.out.println(container.toString());
        }
    }

    private Container[] produceContainers() {
        Container[] list = new Container[15000];
        String fileName = "containerList.txt";
        if (!isListCreated) {
            boolean fileCreation = false;
            File file = new File(fileName);
            FileWriter fileWriter = null;
            BufferedWriter bufferedWriter = null;
            PrintWriter writer = null;
            try {
                fileCreation = file.createNewFile();
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
                writer = new PrintWriter(bufferedWriter);
                ContainerGenerator containerGenerator = new ContainerGenerator();
                for (int i = 0; i < list.length; i++) {
                    int randomNumberTo8 = containerGenerator.randomNumberTo8();
                    generateContainerAndAdd(containerGenerator, list, i, randomNumberTo8, writer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            isListCreated = fileCreation;
        } else {
            FileReader fileReader;
            BufferedReader reader;
            try {
                fileReader = new FileReader(fileName);
                reader = new BufferedReader(fileReader);
                String nextLine;
                int lines = 0;
                while ((nextLine = reader.readLine()) != null) {
                    System.out.println(nextLine);
                    lines++;
                }
            } catch (IOException e) {
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
                writer.write(universalContainer.toString());
                break;
            case 2:
                GasContainer gasContainer = containerGenerator.generateGasContainer();
                list[i] = gasContainer;
                writer.write(gasContainer.toString());
                break;
            case 3:
                HeatedContainer heatedContainer = containerGenerator.generateHeatedContainer();
                list[i] = heatedContainer;
                writer.write(heatedContainer.toString());
                break;
            case 4:
                InsulatedContainer insulatedContainer = containerGenerator.generateInsulatedContainer();
                list[i] = insulatedContainer;
                writer.write(insulatedContainer.toString());
                break;
            case 5:
                RefrigeratedContainer refrigeratedContainer = containerGenerator.generateRefrigeratedContainer();
                list[i] = refrigeratedContainer;
                writer.write(refrigeratedContainer.toString());
                break;
            case 6:
                ThermalContainer thermalContainer = containerGenerator.generateThermalContainer();
                list[i] = thermalContainer;
                writer.write(thermalContainer.toString());
                break;
            case 7:
                PowerSupplyContainer powerSupplyContainer = containerGenerator.generatePowerSupplyContainer();
                list[i] = powerSupplyContainer;
                writer.write(powerSupplyContainer.toString());
                break;
            default:
                VentilatedContainer ventilatedContainer = containerGenerator.generateVentilatedContainer();
                list[i] = ventilatedContainer;
                writer.write(ventilatedContainer.toString());
                break;
        }
    }

    public void getAndSortContainers() {

    }
}
