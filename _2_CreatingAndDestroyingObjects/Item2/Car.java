package _2_CreatingAndDestroyingObjects.Item2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Car {
    private final String model;
    private final String color;
    private final String engineType;
    private final List<String> optionalFeatures;

    private Car(Builder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.engineType = builder.engineType;
        this.optionalFeatures = Collections.unmodifiableList(new ArrayList<>(builder.optionalFeatures));
    }

    public String getColor() {
        return color;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getModel() {
        return model;
    }

    public List<String> getOptionalFeatures() {
        return Collections.unmodifiableList(optionalFeatures);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engineType='" + engineType + '\'' +
                ", optionalFeatures=" + optionalFeatures +
                '}';
    }

    public static class Builder {
        private String model;
        private String color;
        private String engineType;
        private List<String> optionalFeatures = new ArrayList<>();

        public Builder addModel(String model) {
            this.model = Objects.requireNonNull(model, "Model cannot be null").trim();
            if (this.model.isEmpty()) {
                throw new IllegalArgumentException("Model cannot be empty");
            }
            return this;
        }

        public Builder addColor(String color) {
            this.color = Objects.requireNonNull(color, "Color cannot be null").trim();
            if (this.color.isEmpty()) {
                throw new IllegalArgumentException("Color cannot be empty");
            }
            return this;
        }

        public Builder addEngineType(String engineType) {
            this.engineType = Objects.requireNonNull(engineType, "Engine type cannot be null").trim();
            if (this.engineType.isEmpty()) {
                throw new IllegalArgumentException("Engine type cannot be empty");
            }
            return this;
        }

        public Builder addOptionalFeatures(String optionalFeatures) {
            String trimmedString = Objects.requireNonNull(optionalFeatures, "Optional features cannot be null").trim();
            if (trimmedString.isEmpty()) {
                throw new IllegalArgumentException("Optional features cannot be empty");
            }
            this.optionalFeatures.add(trimmedString);
            return this;
        }

        public Builder addOptionalFeatures(List<String> optionalFeatures) {
            Objects.requireNonNull(optionalFeatures, "Optional features list cannot be null");
            for (String feature : optionalFeatures) {
                String trimmedString = Objects.requireNonNull(feature, "Feature cannot be null").trim();
                if (trimmedString.isEmpty()) {
                    throw new IllegalArgumentException("Feature cannot be empty");
                }
                this.optionalFeatures.add(trimmedString);
            }
            return this;
        }

        public Car build() {
            this.model = Objects.requireNonNull(model, "Model cannot be null").trim();
            if (this.model.isEmpty() || this.color.isEmpty() || this.engineType.isEmpty()) {
                throw new IllegalArgumentException("Model, color, and engine type cannot be empty");
            }
            return new Car(this);
        }
    }
}
