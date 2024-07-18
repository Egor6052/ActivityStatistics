import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        folder();
    }
    public static void folder() {
        System.out.println("Подсчет активности за день.");
        // Округление до 3 знаков после запятой;
        DecimalFormat decimalFormat = new DecimalFormat("#.###");


        System.out.print("Введите количество записей: ");
        Scanner scanner = new Scanner(System.in);
        int countOfActivity = scanner.nextInt();
        scanner.nextLine(); // Считываем символ новой строки после ввода числа
        scanner.useLocale(Locale.US);

        List<Activity> activitiesList = new ArrayList<>();

        for (int i = 0; i < countOfActivity; i++) {
            System.out.println("Введите название " + (i + 1) + "-ой активности: ");
            String name = scanner.nextLine();


            System.out.println("Введите время начала активности: ");
            String startTimeInput = scanner.nextLine();
            // Замена символа ":" на "."
            startTimeInput = startTimeInput.replace(":", ".");
            // Парсинг времени после замены
            double startTime = Double.parseDouble(startTimeInput);


            System.out.println("Введите время окончания активности: ");
            String endTimeInput = scanner.nextLine();
            // Замена символа ":" на "."
            endTimeInput = endTimeInput.replace(":", ".");
            // Парсинг времени после замены
            double endTime = Double.parseDouble(endTimeInput);

            activitiesList.add(new Activity(name, startTime, endTime));
        }

        // Часов на каждый пердмет;
        int i = 0;
        for (Activity activity : activitiesList) {
            i ++;
            System.out.println("№" + i + " " + activity);
        }

        // Часов всего;
        double totalHours = calculateTotalHours(activitiesList);
        System.out.println("Общее количество часов за день: " + decimalFormat.format(totalHours));
    }

    // Подсчет общего количества часов;
    public static double calculateTotalHours(List<Activity> activities) {
        double totalHours = 0.0;
        for (Activity activity : activities) {
            totalHours += activity.gethours();
        }
        return totalHours;
    }
}