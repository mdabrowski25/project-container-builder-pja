package pl.pjwstk.build;

public class MainTest {
    public static void main(String[] args) {
        ContainerGenerator containerGenerator = new ContainerGenerator();
        UniversalContainer universalContainer = containerGenerator.generateUniversalContainer();
        System.out.println(universalContainer.toString());

        GasContainer gasContainer = containerGenerator.generateGasContainer();
        System.out.println(gasContainer.toString());

        HeatedContainer heatedContainer = containerGenerator.generateHeatedContainer();
        System.out.println(heatedContainer.toString());

        InsulatedContainer insulatedContainer = containerGenerator.generateInsulatedContainer();
        System.out.println(insulatedContainer.toString());

        RefrigeratedContainer refrigeratedContainer = containerGenerator.generateRefrigeratedContainer();
        System.out.println(refrigeratedContainer.toString());

        ThermalContainer thermalContainer = containerGenerator.generateThermalContainer();
        System.out.println(thermalContainer.toString());

        PowerSupplyContainer powerSupplyContainer = containerGenerator.generatePowerSupplyContainer();
        System.out.println(powerSupplyContainer.toString());

        VentilatedContainer ventilatedContainer = containerGenerator.generateVentilatedContainer();
        System.out.println(ventilatedContainer.toString());
    }
}
