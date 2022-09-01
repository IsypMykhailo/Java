package MyStream.Base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseStream {

    public void run(){
        fillArray();
        //long time = System.nanoTime();
        DivStreams();
        // System.out.println((System.nanoTime() - time) + " ns:  by function");
    }

    /**
     * Методы деления и соединения потоков
     */
    private void DivStreams(){
//        var newIntP = Arrays.stream(num).filter(n-> n > 47).toArray();
//        var newIntN = Arrays.stream(num).filter(n-> n < -47).toArray();
//
//        System.out.println("Pos ");
//        Arrays.stream(newIntP).forEach(n-> System.out.print(n + " "));
//        System.out.println("\n\n Neg ");
//        Arrays.stream(newIntN).forEach(n-> System.out.print(n + " "));
//
//        IntStream p = Arrays.stream(newIntP);
//        IntStream n = Arrays.stream(newIntN);
//
//        System.out.println("\n\n res: ");
//
//        // IntStream.concat(p,n).forEach(el->System.out.print(el + " "));
//        var res = IntStream.concat(p,n).toArray();
//
//        System.out.println("\n\n res distinct: ");
//
//        var resD = Arrays.stream(res).distinct().toArray();
//        Arrays.stream(resD).forEach(el->System.out.print(el + " "));


        System.out.println("\n\n res: ");
        Arrays.stream(
                        IntStream.concat(
                                Arrays.stream(num).filter(el-> el > 40).limit(3),
                                Arrays.stream(num).filter(el-> el < -40).limit(3)
                        ).toArray())
                .distinct()
                .sorted()
                .forEach(el->System.out.print(el + " "));
    }


    /**
     * Использование меперов
     */
    private void useMap() {
        @AllArgsConstructor
        @Data
        class User { String name; int age; };
        Stream<User> users = Stream.of(new User("Sasha", 45), new User("Sveta", 46));

        users.flatMap(u->Stream.of(u.getName(), u.getAge()))
                .forEach(el-> System.out.println(el));

        //users.map(user -> user.getName()).forEach(n -> System.out.println(n));

    }



    /**
     * примеры выполнения в числовых потоках
     */
    private void intStream(){
        IntStream intStr = Arrays.stream(num).parallel();
        long time = System.nanoTime();

        intStr.forEach(el ->{
            if (el > 48)
                System.out.print(el + " ");
        });
        System.out.println("\n\n" + (System.nanoTime() - time) + " ns:  by forEach");

        intStr = Arrays.stream(num).parallel();

        time = System.nanoTime();
        intStr.filter(el-> el > 48).forEach(el -> System.out.print(el + " "));
        System.out.println("\n\n" + (System.nanoTime() - time) + " ns:  by filter");

    }

    /**
     * Примеры выполнения потоков в строках
     */
    private void stringStreams(){
        ArrayList<String> cities  = new ArrayList<>();
        Collections.addAll(cities, "Одесса", "Киев", "Никоалев", "Львов", "Черноморск");

        long time = System.nanoTime();
        Stream<String> citesStream = cities.stream(); //.parallel();
        citesStream.forEach( el -> {
            if(el.length() > 5)
                System.out.println(el);
        });
        System.out.println((System.nanoTime() - time) + " ns:  by forEach");

        time = System.nanoTime();
        cities.stream().filter(el-> el.length()> 5).forEach(el -> System.out.println(el));
        System.out.println((System.nanoTime() - time) + " ns:  by filter");

    }



    /**
     * Базовые операции с потоками
     */
    private void methods() {

        var min =  Arrays.stream(num).min();
        var max =  Arrays.stream(num).max();
        var average =  Arrays.stream(num).average();
        var first = Arrays.stream(num).findFirst();

        var skip = Arrays.stream(num).skip(10).toArray();
        var take = Arrays.stream(num).takeWhile(el -> el > 10).toArray();
        var sort = Arrays.stream(num).sorted().toArray();

        var myEl = Arrays.stream(num).parallel()
                .skip(10)
                .takeWhile(el -> el > 10)
                .filter(el -> el != 20)
                .toArray();


    }


    /**
     * Применение такой же операции в потоковом стиле
     * Уровень 10 класса
     * Мы передаем правила перебора коллекции JAVA - запустив промежуточную операцию
     * (intermediate) ==> filter (Predicate (lambda ))
     * Нам важен результат (terminal) ==> count
     *
     */
    private void apiStyle(){
        int countP = 0;
        int countN = 0;
        // IntStream str = IntStream.of(num).parallel();
//        countP = (int) str.filter(el->el>0).count();
//        countN = (int) str.filter(el->el<0).count();
        // str.close();

        // countP = (int) IntStream.of(num).parallel().filter(el-> el > 0).count();
        countN = (int) Arrays.stream(num).parallel().filter(el-> el < 0).count();

        System.out.println("Положительных числе в массиве: " + countP);
        System.out.println("Отрицательных числе в массиве: " + countN);
    }

    /**
     * Алгоритмический вариант перебора массива
     * Уровень 1 класса - а в умелых руках - верх профи - в компаниях класса Google, Oracle, Bing
     * Мы сами осуществялем перебор (движение) по набору данных
     * Мы контролируем все операции - и работаем в одном потоке
     */
    private void cStyle(){
        int countN =0;
        int countP =0;

        for (int i = 0; i < num.length; i++) {
            if(num[i] < 0) countN++;
            if(num[i] > 0) countP++;
        }

        System.out.println("Положительных числе в массиве: " + countP);
        System.out.println("Отрицательных числе в массиве: " + countN);
    }

    int[] num; // = {-5,4,-3,2,-1,0,1,-2,3,-4,5};
    Random rnd = new Random();

    /**
     * Заполнение массива значениями
     */
    private void fillArray(){
        int size = 999;
        num = new int[size];

        for (int i = 0; i < size; i++) {
            num[i] = rnd.nextInt(100) - 50;
        }

    }
}