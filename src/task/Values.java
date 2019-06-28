package task;

public class Values {
    private double angleInDegrees;
    private double angleInRadians;
    private double result;

    public Values(double angleInDegrees, double angleInRadians, double result) {
        this.angleInDegrees = angleInDegrees;
        this.angleInRadians = angleInRadians;
        this.result = result;
    }

    public String[] getAsStringMassive() {
        return new String[]{String.format("%.2f", angleInDegrees), String.format("%.2f", angleInRadians), String.format("%.2f", result)};
    }
}
