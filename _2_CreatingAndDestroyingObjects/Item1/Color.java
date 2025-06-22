package _2_CreatingAndDestroyingObjects.Item1;

public class Color {
    private final String typeOfColor;

    private Color(String typeColor) {
        typeOfColor = typeColor;
    }

    public static Color red() {
        return new Color("red");
    }

    public static Color blue() {
        return new Color("blue");
    }

    public static Color green() {
        return new Color("green");
    }

    public String getTypeOfColor() {
        return typeOfColor;
    }
}
