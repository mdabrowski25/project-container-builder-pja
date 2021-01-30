package pl.pjwstk.build;

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
        if (!isListCreated) {
            ContainerGenerator containerGenerator = new ContainerGenerator();
            for (int i = 0; i < list.length; i++) {
                int randomNumberTo8 = containerGenerator.randomNumberTo8();
                generateContainerAndAdd(containerGenerator, list, i, randomNumberTo8);
            }
            //zapis do pliku
            isListCreated = true;
        } else {
            //odczyt
        }
        return list;
    }

    private void generateContainerAndAdd(ContainerGenerator containerGenerator, Container[] list, int i, int randomNumberTo8) {
        switch (randomNumberTo8) {
            case 1:
                list[i] = containerGenerator.generateUniversalContainer();
                break;
            case 2:
                list[i] = containerGenerator.generateGasContainer();
                break;
            case 3:
                list[i] = containerGenerator.generateHeatedContainer();
                break;
            case 4:
                list[i] = containerGenerator.generateInsulatedContainer();
                break;
            case 5:
                list[i] = containerGenerator.generateRefrigeratedContainer();
                break;
            case 6:
                list[i] = containerGenerator.generateThermalContainer();
                break;
            case 7:
                list[i] = containerGenerator.generatePowerSupplyContainer();
                break;
            default:
                list[i] = containerGenerator.generateVentilatedContainer();
                break;
        }
    }

    public void getAndSortContainers() {

    }
}
