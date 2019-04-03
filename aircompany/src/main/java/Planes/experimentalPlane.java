package Planes;

import models.ClassificationLevel;

import java.util.Objects;

public class experimentalPlane extends Plane {

    private ClassificationLevel classificationLevel;

    public experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        experimentalPlane that = (experimentalPlane) o;
        return classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classificationLevel);
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "classificationLevel=" + classificationLevel +
                '}';
    }
}
