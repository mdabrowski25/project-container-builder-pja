package pl.pjwstk.build;

import java.io.Serializable;

public abstract class Container implements Serializable {
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
        return "productType:  " + productType + gap() +"weight:  " + weight + gap() +
                "sizeType:  " + sizeType;
    }

    protected String gap() {
        return "    ";
    }
}
