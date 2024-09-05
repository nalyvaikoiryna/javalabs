import java.util.ArrayList;
import java.util.Collections;
// Підготовка
public class NumberOperations {
    public static void main(String[] args) {
        ArrayList<Number> numList = new ArrayList<>();
        numList.add(10);
        numList.add(20.5);
        numList.add(30);
        numList.add(40.7);
        numList.add(50);
        numList.add(60.3);
        numList.add(70);
        numList.add(80.1);
        numList.add(90);
        numList.add(100.9);
        // 1)
        byte byteNumber = 0;
        short shortNumber = 2;
        int intNumber = 93;
        long longNumber = 898956899L;
        float floatNumber = 8.898f;
        double doubleNumber = 90.783;
        // 2,3)
        Collections.addAll(numList, shortNumber, byteNumber, intNumber, longNumber, floatNumber, doubleNumber);
        // 4)
        System.out.println("List:" + numList);
        // 5)
        ArrayList<Integer> integerList = new ArrayList<>();
        for (Number num : numList) {
            int newNumber = num.intValue();
            integerList.add(newNumber);
        }
        System.out.println("Integers:" + integerList);
        // 6)
        ArrayList<Double> decimalList = new ArrayList<>();
        for (Number num : numList) {
            double decimalNumber = num.doubleValue();
            decimalList.add(decimalNumber);
        }
        System.out.print("Decimals: [");
        for (int i = 0; i < decimalList.size(); i++) {
            System.out.printf("%.2f", decimalList.get(i));
            if (i < decimalList.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.print("]");
        // 7
        ArrayList<Byte> byteList = new ArrayList<>();
        ArrayList<Short> shortList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Long> longList = new ArrayList<>();
        ArrayList<Float> floatList = new ArrayList<>();
        ArrayList<Double> doubleList = new ArrayList<>();
        for (Number num : numList) {
            switch (num) {
                case Byte b -> byteList.add(b);
                case Integer i -> intList.add(i);
                case Short s -> shortList.add(s);
                case Long l -> longList.add(l);
                case Float f -> floatList.add(f);
                case Double d -> doubleList.add(d);
                case null, default -> {
                }
            }
        }
        System.out.println("\nByte elements: " + byteList);
        System.out.println("Short elements: " + shortList);
        System.out.println("Integer elements: " + intList);
        System.out.println("Long elements: " + longList);
        System.out.println("Float elements: " + floatList);
        System.out.println("Double elements: " + doubleList);
        // Індивідуальне завдання(10)
        ArrayList<Double> resultList = new ArrayList<>();
        for (Number num : numList) {
            double result = (num.doubleValue() + 10) / 2;
            resultList.add(result);
        }
        System.out.println("Result List: " + resultList);
    }

}