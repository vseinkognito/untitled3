/*Вариант 6
        Разработать класс для хранения информации о горах:
        Название, место_расположения, высота
        и реализовать алгоритм работы с массивом данных объектов, в котором
        требуется:
        – определить самую высокую вершину;
        – определить вершины с высотой более 1000 м;
        – упорядочить массив по возрастанию высот;
        – организовать поиск по названию вершины, исправление одного из полей
        и вывод полной информации о вершине после редактирования.*/

import java.util.Scanner;

class Mountain{
    String name, location;
    int height;
}

public class InfoAboutMountains {
    static Scanner sc;

    public static Mountain[] fillMountains(int count){
        Scanner sc=new Scanner(System.in,"cp1251");
        Mountain[] mountains = new Mountain[count];

        System.out.println("Input info about mountains: ");
        for (int i = 0; i < mountains.length; i++){
            mountains[i] = new Mountain();
            System.out.println("Name: ");
            mountains[i].name = sc.nextLine();
            System.out.println("Location: ");
            mountains[i].location = sc.nextLine();
            System.out.println("Height: ");
            mountains[i].height = sc.nextInt();
            sc.nextLine();
        }
        return mountains;
    }

    public static void printInfoMountains(Mountain[] mountains) {
        for (int i = 0; i < mountains.length; i++) {
            System.out.println("Name: " + mountains[i].name +
                    "Location: " + mountains[i].location +
                    "Height: " + mountains[i].height);
        }
    }
    public static void findHighestMountain(Mountain mountains){
        System.out.println("Name: " + mountains.name +
                "Location: " + mountains.location +
                "Height: " + mountains.height);
    }
    public static int NomMax(Mountain[] mountains) {
        int nommax = 0;
        double max = mountains[nommax].height;
        for (int i = 0; i < mountains.length; i++)
            if (mountains[i].height > max) {
                max = mountains[i].height;
                nommax = i;
            }
        return nommax;
    }

    public static void findMountainOverTh(Mountain[] mountains){
        for(int i = 0; i< mountains.length;i++){
            if(mountains[i].height>1000){
                System.out.println("Name: " + mountains[i].name +
                        "Location: " + mountains[i].location +
                        "Height: " + mountains[i].height);
            }
        }
    }

    public  static void sortHeight(Mountain[]mountains){
        for(int i = 0; i < mountains.length-1; i++)
            for(int j =0; j < mountains.length-1-i; j++)
                if(mountains[j].height>mountains[j+1].height){
                    Mountain rab=mountains[j];
                    mountains[j]=mountains[j+1];
                    mountains[j+1]=rab;
                }
    }

    public static Mountain findForName(Mountain mountain[],String name){
        int n = -1;
        for(int i =0; i < mountain.length; i++)
            if(name.equals(mountain[i].name))
                n=i;
        if(n!=-1){
            return mountain[n];
        }
        else return null;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Count: ");
        int count = sc.nextInt();
        Mountain[]mountains = fillMountains(count);

        printInfoMountains(mountains);

        int nommax = NomMax(mountains);
        System.out.println("\nThe highest mountain: ");
        findHighestMountain(mountains[nommax]);

        System.out.println("\nMountains over 1000: ");
        findMountainOverTh(mountains);

        sortHeight(mountains);
        System.out.println("\nSorted list by top: ");
        printInfoMountains(mountains);

        System.out.println("\nMountain search \n Input mountain's name: ");
        sc.nextLine();
        String sname=sc.nextLine();
        Mountain sfind = findForName(mountains, sname);
        if(sfind!=null){
            findHighestMountain(sfind);
        } else {
            System.out.println("Error!");
        }
    }
}


