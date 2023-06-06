package org.example;

import java.util.Objects;

public class Motorcycle {
    String brandName;
    String modelName;
    int horsePower;
    int displacement;

    int topSpeed;

    String type;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Motorcycle(String line) {
        String[] splitLine = line.split(",");
        this.brandName = splitLine[0];
        this.modelName = splitLine[1];
        this.horsePower = Integer.parseInt(splitLine[2]);
        this.displacement = Integer.parseInt(splitLine[3]);
        this.topSpeed = Integer.parseInt(splitLine[4]);
        this.type = splitLine[5];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Motorcycle that)) return false;
        return horsePower == that.horsePower && displacement == that.displacement && topSpeed == that.topSpeed && Objects.equals(brandName, that.brandName) && Objects.equals(modelName, that.modelName) && Objects.equals(type, that.type);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", horsePower=" + horsePower +
                ", displacement=" + displacement +
                ", topSpeed=" + topSpeed +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, modelName, horsePower, displacement, topSpeed, type);
    }
}
