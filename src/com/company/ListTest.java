package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
  @author   Volodymyr Lakusta
  @project   vsem3
  @class  ListTest
  @version  1.0.0 
  @since 04.04.2021 - 19.35
**/

public class ListTest {

    public static List<Integer> createList (List<Integer> list, int n, String listType){
        Random random = new Random();
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 100000 ; i++) {
            list.add(random.nextInt(1000));
        }
        LocalDateTime finish = LocalDateTime.now();
        int duration = (int) ChronoUnit.MILLIS.between(start, finish);
        System.out.println(listType + ": " + duration);
        return list;
    }

    public static List<Integer> insertInList (List<Integer> list, int index, String listType){
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 1000; i++) {
            list.add(index,100);
        }
        LocalDateTime finish = LocalDateTime.now();
        int duration = (int) ChronoUnit.MILLIS.between(start, finish);
        System.out.println(listType + ": " + duration);
        return list;
    }

    public static List<Integer> updateList (List<Integer> list, int index, String listType){
        LocalDateTime start = LocalDateTime.now();
        for (int i = index; i < index+1000; i++) {
            list.set(i,100);
        }
        LocalDateTime finish = LocalDateTime.now();
        int duration = (int) ChronoUnit.MILLIS.between(start, finish);
        System.out.println(listType + ": " + duration);
        return list;
    }

    public static List<Integer> deleteListElements (List<Integer> list, int index, String listType){
        LocalDateTime start = LocalDateTime.now();
        for (int i = 0; i < 1000; i++) {
            list.remove(index);
        }
        LocalDateTime finish = LocalDateTime.now();
        int duration = (int) ChronoUnit.MILLIS.between(start, finish);
        System.out.println(listType + ": " + duration);
        return list;
    }

    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> arrayList = new ArrayList<>( );
        List<Integer> linkedList = new LinkedList<>();

        // Create list of 100000 elements
        System.out.println("------------Create 100000 elements------------");
        arrayList = createList(arrayList,100000,"ArrayList");
        linkedList = createList(linkedList,100000,"LinkedList");

        // Insert in list
        //Begin
        System.out.println("------------Insert in list------------");
        System.out.println("-----Begin");
        arrayList = insertInList(arrayList,0,"ArrayList");
        linkedList = insertInList(linkedList,0,"LinkedList");

        //Middle
        int index = arrayList.size() / 2;
        System.out.println("-----Middle");
        arrayList = insertInList(arrayList,index,"ArrayList");
        linkedList = insertInList(linkedList,index,"LinkedList");

        //End
        index = arrayList.size();
        System.out.println("-----End");
        arrayList = insertInList(arrayList,index,"ArrayList");
        linkedList = insertInList(linkedList,index,"LinkedList");

        // Update in list
        //Begin
        System.out.println("------------Update in list------------");
        System.out.println("-----Begin");
        arrayList = updateList(arrayList,0,"ArrayList");
        linkedList = updateList(linkedList,0,"LinkedList");

        //Middle
        index = arrayList.size() / 2;
        System.out.println("-----Middle");
        arrayList = updateList(arrayList,index,"ArrayList");
        linkedList = updateList(linkedList,index,"LinkedList");

        //End
        index = arrayList.size()-1000;
        System.out.println("-----End");
        arrayList = updateList(arrayList,index,"ArrayList");
        linkedList = updateList(linkedList,index,"LinkedList");

        // Delete in list
        //Begin
        System.out.println("------------Delete in list------------");
        System.out.println("-----Begin");
        arrayList = deleteListElements(arrayList,0,"ArrayList");
        linkedList = deleteListElements(linkedList,0,"LinkedList");

        //Middle
        index = arrayList.size() / 2;
        System.out.println("-----Middle");
        arrayList = deleteListElements(arrayList,index,"ArrayList");
        linkedList = deleteListElements(linkedList,index,"LinkedList");

        //End
        index = arrayList.size()-1000;
        System.out.println("-----End");
        arrayList = deleteListElements(arrayList,index,"ArrayList");
        linkedList = deleteListElements(linkedList,index,"LinkedList");

    }
    /*Output:
        ------------Create 100000 elements------------
        ArrayList: 127
        LinkedList: 10
        ------------Insert in list------------
        -----Begin
        ArrayList: 54
        LinkedList: 1
        -----Middle
        ArrayList: 9
        LinkedList: 297
        -----End
        ArrayList: 0
        LinkedList: 1
        ------------Update in list------------
        -----Begin
        ArrayList: 0
        LinkedList: 2
        -----Middle
        ArrayList: 0
        LinkedList: 235
        -----End
        ArrayList: 0
        LinkedList: 1
        ------------Delete in list------------
        -----Begin
        ArrayList: 27
        LinkedList: 1
        -----Middle
        ArrayList: 7
        LinkedList: 194
        -----End
        ArrayList: 1
        LinkedList: 1
    */
}
