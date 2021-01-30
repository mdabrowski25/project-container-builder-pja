package pl.pjwstk.build;

public class Main {
    public static void main(String[] args) {
        ContainerGenerator containerGenerator = new ContainerGenerator();
        UniversalContainer universalContainer = containerGenerator.generateUniversalContainer();
        System.out.println(universalContainer.toString());

        GasContainer gasContainer = containerGenerator.generateGasContainer();
        System.out.println(gasContainer.toString());

    }
}
