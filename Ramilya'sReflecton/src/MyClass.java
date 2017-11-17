import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;

/**
 * @author Ramilia Nigmatullina
 * 11-402
 * Task25с
 */

public class MyClass {
    public static void main(String[] args) {
        HashMap<String, int[]> hm = new HashMap<String, int[]>();
        try {
            Class c = Class.forName("Vector2D");
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                Author annotation = method.getAnnotation(Author.class);
                if (annotation != null) {
                    String author = annotation.name();

                    Class[] paramTypes = method.getParameterTypes();
                    int num = paramTypes.length;

                    if (!hm.containsKey(author)) {
                        int[] arr = new int[6];
                        /*
                        Массив arr хранит следующие значения:
                        arr[0] - сумма длин названий всех методов (одного автора)
                        arr[1] - количесвто методов у одного автора
                        arr[2] - сумма длин названий всех имен параметра в методе (одного автора)
                        arr[3] - количесвто имен параметров
                        arr[4] - количество void-функций у автора
                        arr[5] - общее количество параметров в написанной функции
                         */
                        arr[0] = method.getName().length();
                        arr[1] = 1;

                        Parameter[] parameters = method.getParameters();
                        for (Parameter parameter: parameters) {
                            arr[2] = parameter.getName().length();
                            System.out.println(parameter.getName().length());
                            System.out.println(parameter.getName());
                            arr[3] = 1;
                        }

                        if (method.getReturnType().toString().equals("void"))
                            arr[4] = 1;
                        else
                            arr[4] = 0;
                        arr[5] = num;
                        hm.put(author, arr);
                    } else {
                        int[] arr = hm.get(author);
                        arr[0] += method.getName().length();
                        arr[1]++;
                        Parameter[] parameters = method.getParameters();
                        for (Parameter parameter: parameters) {
                            arr[2] += parameter.getName().length();
                            arr[3]++;
                        }
                        if (method.getReturnType().toString().equals("void"))
                            arr[4]++;
                        arr[5] += num;
                    }
                }
            }

            //1
            System.out.println("Средняя длина названия метода (по всем методам одного автора):");
            ArrayList<String> results = new ArrayList();
            for (String key : hm.keySet()) {
                int[] arr = hm.get(key);
                results.add(key);
                double d = (double) arr[0] / (double) arr[1];
                results.add(Double.toString(d));
            }
            TreeSet<Double> ts = new TreeSet();
            for (int[] arr : hm.values()) {
                ts.add((double)arr[0] / (double)arr[1]);
            }
            for (double d : ts) {
                for (int i = 1; i < results.size(); i = i + 2 ) {
                    if (Double.toString(d).equals(results.get(i))) {
                        System.out.println(" - " + results.get(i  - 1) + ": " + d);
                        results.set(i, "-1");
                        break;
                    }
                }
            }
            System.out.println();

            //2
            System.out.println("Средняя длина имени параметра в методе (по всем параметрам всх методов одного автора):");
            results = new ArrayList();
            for (String key : hm.keySet()) {
                int[] arr = hm.get(key);
                results.add(key);
                double d = (double) arr[2] / (double) arr[3];
                results.add(Double.toString(d));
            }
            ts = new TreeSet();
            for (int[] arr : hm.values()) {
                ts.add((double)arr[2] / (double)arr[3]);
            }
            for (double d : ts) {
                for (int i = 1; i < results.size(); i = i + 2 ) {
                    if (Double.toString(d).equals(results.get(i))) {
                        System.out.println(" - " + results.get(i  - 1) + ": " + d);
                        results.set(i, "-1");
                        break;
                    }
                }
            }
            System.out.println();

            //3
            System.out.println("Количесвто void-функций:");
            results = new ArrayList();
            for (String key : hm.keySet()) {
                int[] arr = hm.get(key);
                results.add(key);
                results.add(Integer.toString(arr[4]));
            }
            TreeSet<Integer> ts2 = new TreeSet<Integer>();
            for (int[] arr : hm.values())
                ts2.add(arr[4]);

            for (int d : ts2) {
                for (int i = 1; i < results.size(); i = i + 2 ) {
                    if (Integer.toString(d).equals(results.get(i))) {
                        System.out.println(" - " + results.get(i  - 1) + ": " + d);
                        results.set(i, "-1");
                        break;
                    }
                }
            }
            System.out.println();

            //4
            System.out.println("Количесвто параметров всех функций автора:");
            results = new ArrayList();
            for (String key : hm.keySet()) {
                int[] arr = hm.get(key);
                results.add(key);
                results.add(Integer.toString(arr[5]));
            }
            ts2 = new TreeSet<Integer>();
            for (int[] arr : hm.values())
                ts2.add(arr[5]);

            for (int d : ts2) {
                for (int i = 1; i < results.size(); i = i + 2 ) {
                    if (Integer.toString(d).equals(results.get(i))) {
                        System.out.println(" - " + results.get(i  - 1) + ": " + d);
                        results.set(i, "-1");
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
