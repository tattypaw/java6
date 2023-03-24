/* cоздать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
NoteBook notebook1 = new NoteBook
NoteBook notebook2 = new NoteBook
NoteBook notebook3 = new NoteBook
NoteBook notebook4 = new NoteBook
NoteBook notebook5 = new NoteBook

Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет

Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

Класс сделать в отдельном файле

приветствие
Выбор параметра
выбор конкретнее
вывод подходящих */

import java.util.*;

public class program3 {
    public static void main(String[] args) {

        Laptop l1 = new Laptop(1, 2, 128, "Windows10", "Сиреневый");
        Laptop l2 = new Laptop(2, 4, 256, "Windows11", "Красный");
        Laptop l3 = new Laptop(3, 32, 512, "Windows10", "Серый");
        Laptop l4 = new Laptop(4, 16, 256, "Windows11", "Черный");
        Laptop l5 = new Laptop(5, 32, 512, "Linux", "Красный");

        Set<Laptop> laptops = new HashSet<Laptop>();
        laptops.add(l1);
        laptops.add(l2);
        laptops.add(l3);
        laptops.add(l4);
        laptops.add(l5);

        System.out.println(laptops.toString());

        Scanner sc = new Scanner(System.in,"ibm866");
        boolean flag = false;
        
        while(!flag){
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - SSD");
            System.out.println("3 - OS");
            System.out.println("4 - цвет");
            Integer choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("Введите минимальное значение ОЗУ: ");
                    Integer ram_min = sc.nextInt();
                    System.out.printf("Введите максимальное значение ОЗУ: ");
                    Integer ram_max = sc.nextInt();
                    ram_filter(ram_min, ram_max, laptops);                 
                    break;
                case 2:
                    System.out.printf("Введите минимальное значение SSD: ");
                    Integer ssd_min = sc.nextInt();
                    System.out.printf("Введите максимальное значение SSD: ");
                    Integer ssd_max = sc.nextInt();
                    ssd_filter(ssd_min, ssd_max, laptops);
                    break;
                case 3:
                    System.out.println("Введите название OS из списка(Windows10, Windows11, Linux):");
                    String os = sc.next();
                    os_filter(os, laptops);
                    break;
                case 4:
                    System.out.println("Введите цвет из списка (Сиреневый, Красный, Серый, Черный):");
                    String color = sc.next();
                    color_filter(color, laptops);
                    break;
                default:
                    System.out.println("Вы ошиблись. Программа завершает свою работу");
                    flag = true;
                    break;
            } 
            if (flag) break;  
        }             
       }
        public static void ram_filter(Integer n1, Integer n2, Set<Laptop> laptops) {
            boolean flag = false;
            for(Laptop lp : laptops){
                if(lp.getRam()>=n1 && lp.getRam()<=n2 ){
                    System.out.println(lp.toString());
                    flag = true;
                }
            }
            if (!flag) System.out.println("Извините, таких ноутбуков нет.");
        }

        public static void ssd_filter(Integer n1, Integer n2, Set<Laptop> laptops) {
            boolean flag = false;
            for(Laptop lp : laptops){
                if(lp.getSsd()>=n1 && lp.getSsd()<=n2 ){
                    System.out.println(lp.toString());
                    flag = true;
                }
            }
            if (!flag) System.out.println("Извините, таких ноутбуков нет.");
        }

        public static void os_filter(String n1, Set<Laptop> laptops) {
            boolean flag = false;
            for(Laptop lp : laptops){
                if(lp.getOs().equals(n1)){
                    System.out.println(lp.toString());
                    flag = true;
                }
            }
            if (!flag) System.out.println("Извините, таких ноутбуков нет.");
        }

        public static void color_filter(String n1, Set<Laptop> laptops) {
            boolean flag = false;
            for(Laptop lp : laptops){
                if(lp.getColor().equals(n1)){
                    System.out.println(lp.toString());
                    flag = true;
                }
            }
            if (!flag) System.out.println("Извините, таких ноутбуков нет.");
        }
        }
