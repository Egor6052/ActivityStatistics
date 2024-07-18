import java.text.DecimalFormat;
import java.text.DecimalFormat;

public class Activity {
    private String name;
    private double startTime;
    private double andTime;

    public Activity(String name, double startTime, double andTime) {
        this.name = name;
        this.startTime = startTime;
        this.andTime = andTime;
    }

    public double gethours() {

        return andTime - startTime;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        return name + " = " + decimalFormat.format(gethours());
    }
}
