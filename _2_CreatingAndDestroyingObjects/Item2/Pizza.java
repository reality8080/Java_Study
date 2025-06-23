package _2_CreatingAndDestroyingObjects.Item2;

import java.util.ArrayList;
import java.util.Collections;
// import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// public class Pizza {
//     private final List<String> toppings;
//     private final String size;
//     private final String crustType;

//     private Pizza(List<String> toppings, String size, String crustType) {
//         this.toppings = toppings;
//         this.size = size;
//         this.crustType = crustType;
//     }

//     public String getCrustType() {
//         return crustType;
//     }

//     public String getSize() {
//         return size;
//     }

//     public List<String> getToppings() {
//         return toppings;
//     }
// }

public class Pizza {
    private final List<String> toppings;
    private final String size;
    private final String crustType;

    private Pizza(Builder build) {
        this.toppings = Collections
                .unmodifiableList(new ArrayList<>(build.toppings));
        this.size = build.size;
        this.crustType = build.crustType;
    }

    public String getCrustType() {
        return crustType;
    }

    public String getSize() {
        return size;
    }

    public List<String> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                ", size='" + size + '\'' +
                ", crustType='" + crustType + '\'' +
                '}';
    }

    public static class Builder {
        private List<String> toppings = new ArrayList<>();
        private String size;
        private String crustType;

        public Builder addTopping(String topping) {
            Objects.requireNonNull(topping, "Topping cannot be null");
            if (topping.trim().isEmpty()) {
                throw new IllegalArgumentException("Topping cannot be empty");
            }
            this.toppings.add(topping);
            return this;
        }

        public Builder setSize(String size) {
            Objects.requireNonNull(size, "Size cannot be null");
            if (size.trim().isEmpty()) {
                throw new IllegalArgumentException("Size cannot be empty");
            }
            this.size = size;
            return this;
        }

        public Builder setCrustType(String crustType) {
            Objects.requireNonNull(crustType, "Crust type cannot be null");
            if (crustType.trim().isEmpty()) {
                throw new IllegalArgumentException("Crust type cannot be empty");
            }
            this.crustType = crustType;
            return this;
        }

        public Pizza build() {
            this.size = Objects.requireNonNull(size, "Size cannot be null").trim();
            if (!Set.of("small", "medium", "large").contains(size.toLowerCase())) {
                throw new IllegalArgumentException("Size must be one of: small, medium, large");
            }
            this.crustType = Objects.requireNonNull(crustType, "Crust type cannot be null").trim();
            if (!Set.of("thin", "thick", "stuffed").contains(crustType.toLowerCase())) {
                throw new IllegalArgumentException("Crust type must be one of: thin, thick, stuffed");
            }

            this.toppings = new ArrayList<>(this.toppings);
            return new Pizza(this);
        }
    }
}