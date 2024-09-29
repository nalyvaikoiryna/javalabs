import java.util.Scanner;
abstract class Device {
    protected double figure;

    public void inputFigure() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введіть виміряне значення: ");
            if (scanner.hasNextDouble()) {
                figure = scanner.nextDouble();
                if (isWithinRange()) {
                    break;
                } else {
                    System.out.println("Значення поза допустимим діапазоном. Спробуйте ще раз.");
                }
            } else {
                System.out.println("Некоректне значення. Спробуйте ще раз.");
                scanner.next();
            }
        }
    }

    public double getFigure() {
        return figure;
    }

    public void setFigure(double figure) {
        this.figure = figure;
    }

    public boolean isWithinRange(double lowerLimit, double upperLimit) {
        return figure >= lowerLimit && figure <= upperLimit;
    }
    public abstract boolean isWithinRange();

    public abstract void showFigure();

}
class Thermometer extends Device {
    @Override
    public boolean isWithinRange() {
        return super.isWithinRange(-50, 50);
    }
    @Override
    public void showFigure() {
        System.out.print("Температура: " + getFigure() + " C");
    }
}
class Barometer extends Device {
    @Override
    public boolean isWithinRange() {
        return super.isWithinRange(700, 800);
    }
    @Override
    public void showFigure() {
        System.out.print("Тиск: " + getFigure() + "мм рт. ст.");
    }
}
class Hygrometer extends Device {
    @Override
    public boolean isWithinRange() {
        return super.isWithinRange(0, 100);
    }
    @Override
    public void showFigure() {
        System.out.print("Вологість: " + getFigure() + "%");
    }
} class HeatIndexCalculator {
    public static double calculate(double t, double h){
        return -42.379 +
                (2.04901523 * t) +
                (10.14333127 * h) +
                (-0.22475541 * t * h) +
                (-0.00683783 * Math.pow(t, 2)) +
                (-0.05481717 * Math.pow(h, 2)) +
                (0.00122874 * Math.pow(t, 2) * h) +
                (0.00085282 * t * Math.pow(h, 2)) +
                (-0.00000199 * Math.pow(t, 2) * Math.pow(h, 2));
    }
}
class DewPointCalculator{
    public static double calculate (double t, double h) {
        if (h == 0) {
            System.out.println("Вологість не може бути нульовою для розрахунку точки роси.");
            return Double.NaN;
        }
        double alpha = (17.27 * t) / (237.7 + t) + Math.log(h);
        return (237.7 * alpha) / (17.27 - alpha);
    }
}
class WeatherAnalyser {
    public static void weatherEstimation (double t,double h,double p) {
        if (p<760){
            if  (t>26) {
                System.out.print("Ймовірне наближення грози або погіршення погоди");
            } else {
                System.out.print("Можливі опади або шторм.");
            }
        } else if (h>70 && (t>26 || t<10)) {
            System.out.print("Є ймовірність туману.");
        } else {
            System.out.print("Неможливо спрогнозувати зміни за данними показниками.");
        }
    }
    public static void comparisonForecast(double t1, double t2, double h1, double h2, double p1, double p2) {
        double tDiff = Math.abs(t1 - t2);
        double hDiff = Math.abs(h1 - h2);
        double pDiff = Math.abs(p1 - p2);

        if (tDiff > 10 && t2 < t1 && p2 > p1) {
            System.out.print("Передбачається вторгнення холодного фронту.");
        } else if (tDiff > 10 && t1 < t2 && (pDiff < 6 || p2 > 760)) {
            if (h2 > 70) {
                System.out.print("Показники свідчать про теплову хвилю.");
            } else if (h2 < h1) {
                System.out.print("Є ймовірність сухої і спекотної погоди.");
            }
        } else if (tDiff < 10 && pDiff < 6) {
            System.out.print("Показники свідчать про спокійну, безхмарну погоду.");
        } else if (h2 > 70 && t2 < t1) {
            System.out.print("Передбачається утворення туману.");
        } else if (t2 > t1 && p2 < 760) {
            System.out.print("Є ризик грози чи буревію.");
        } else if (pDiff > 6 && p2 < p1) {
            System.out.print("Показники свідчать про наближення циклону або шторму.");
        } else if (h2 < h1 && t2 < t1) {
            System.out.print("Можливі опади.");
        }
    }
}


public class Main {
    public static void main(String[] args) {

        Thermometer thermometer = new Thermometer();
        Barometer barometer = new Barometer();
        Hygrometer hygrometer = new Hygrometer();


        System.out.println("Введіть дані для термометра:");
        thermometer.inputFigure();
        thermometer.showFigure();
        System.out.println();

        System.out.println("Введіть дані для барометра:");
        barometer.inputFigure();
        barometer.showFigure();
        System.out.println();

        System.out.println("Введіть дані для гігрометра:");
        hygrometer.inputFigure();
        hygrometer.showFigure();
        System.out.println();


       /*
        thermometer.setFigure(30.5); // Наприклад, 30.5 градусів
        barometer.setFigure(755);    // Наприклад, 755 мм рт. ст.
        hygrometer.setFigure(65);    // Наприклад, 65% вологості


        thermometer.showFigure();
        System.out.println();
        barometer.showFigure();
        System.out.println();
        hygrometer.showFigure();
        System.out.println();
        */
        // Обчислення індексу тепла
        double t = thermometer.getFigure();
        double h = hygrometer.getFigure();
        double heatIndex = HeatIndexCalculator.calculate(t, h);
        System.out.println("\nІндекс тепла: " + heatIndex);

        // Обчислення точки роси
        double dewPoint = DewPointCalculator.calculate(t, h);
        System.out.println("Точка роси: " + dewPoint);

        // Аналіз погоди на основі показників
        System.out.println("\nПрогноз погоди на основі показників:");
        double p = barometer.getFigure();
        WeatherAnalyser.weatherEstimation(t, h, p);
        System.out.println();



        double previousT = t - 5;
        double previousH = h - 10;
        double previousP = p + 5;

        System.out.println("\nПрогноз погоди на основі порівняння  з попередніми даними:");
        WeatherAnalyser.comparisonForecast(previousT, t, previousH, h, previousP, p);
    }

}