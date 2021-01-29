package pl.pjwstk.build;

public abstract class TemperatureControlledContainer extends Container {
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
        return "TemperatureControlledContainer { " + " SERIAL: "  + getSerial() +
                ", temperature = " + temperature + ", " + super.toString() + " }";
    }
}