import java.util.Scanner;

/*Разработать класс для хранения информации о горах:
        Название, место_расположения, высота
        и реализовать алгоритм работы с массивом данных объектов, в котором
        требуется:
        – определить самую высокую вершину;
        – определить вершины с высотой более 1000 м;
        – упорядочить массив по возрастанию высот;
        – организовать поиск по названию вершины, исправление одного из полей
        и вывод полной информации о вершине после редактирования.*/
class Mountain1{
    String name,location;
    double height;
}
public class InfoAboutMountainswometh {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("count:");
        int count = sc.nextInt();
        Mountain[] mountains= new Mountain[count];
        for(int i = 0; i < mountains.length; i++){
            sc.nextLine();
            mountains[i] = new Mountain();
            System.out.println("Name: ");
            mountains[i].name = sc.nextLine();
            System.out.println("Location: ");
            mountains[i].location = sc.nextLine();
            System.out.println("Height: ");
            mountains[i].height = sc.nextInt();
        }
        sc.nextLine();

        System.out.println("info about mountains: ");
        for(int i = 0; i < mountains.length; i++){
            System.out.println("Name = " +  mountains[i].name +
                    " Location = " + mountains[i].location +
                    " Height = " + mountains[i].height);
        }
        int nhighest = 0;
        double highest = mountains[nhighest].height;
        for(int i = 1; i < mountains.length; i++){
            if(mountains[i].height > highest){
                highest = mountains[i].height;
                nhighest = i;
            }
        }
        System.out.println("The highest mountain: ");
        System.out.println("Name = " +mountains[nhighest].name +
                " Location = " +mountains[nhighest].location +
                " Height = " + mountains[nhighest].height);
        for(int i = 0; i < mountains.length - 1; i++)
            for(int j = 0; j < mountains.length - 1 - i; j++)
                if(mountains[j].height > mountains[j + 1].height){
                    Mountain rab = mountains[j];
                    mountains[j] = mountains[j+1];
                    mountains[j+1] = rab;
                }
        double s = 1000;
        for(int i = 0; i < mountains.length; i++);
        double sr = s;
        System.out.println("Mountain heights over 1000m: ");
        for(int i = 0; i < mountains.length; i++){
            if(mountains[i].height > sr)
                System.out.println("Name = " +mountains[i].name +
                        " Location = " +mountains[i].location +
                        " Height = " + mountains[i].height);
        }

        System.out.println("to the top:");
        for(int i = 0; i < mountains.length; i++){
            System.out.println("Name = " +mountains[i].name +
                    " Location = " +mountains[i].location +
                    " Height = " + mountains[i].height);
        }

        System.out.println("Type searchName");
        String nameSearch = sc.nextLine();
        int nomS = -1;
        for(int i = 0; i < count; i++){
            if(mountains[i].name.equals(nameSearch)){
                nomS = i;
            }
        }
        if(nomS!= -1){
            System.out.println("input index");
            System.out.println("name, location, height");
            String strPole = sc.nextLine();
            switch (strPole){
                case "name":{
                    System.out.println("input new name");
                    String newName = sc.nextLine();
                    mountains[nomS].name = newName;
                    break;
                }
                case "location":{
                    System.out.println("input new location");
                    String newLocation = sc.nextLine();
                    mountains[nomS].location = newLocation;
                    break;
                }
                case "height":{
                    System.out.println("input new height");
                    int newHeight = sc.nextInt();
                    mountains[nomS].height = newHeight;
                    break;
                }
                default:{
                    System.out.println("error");
                }
            }
            System.out.println("new version");
            System.out.println("Name = " + mountains[nomS].name +
                    " Location = " + mountains[nomS].location +
                    " Height = " + mountains[nomS].height);
        }
        else{
            System.out.println("error");
        }
    }
}
