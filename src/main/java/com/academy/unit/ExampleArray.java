package com.academy.unit;

import com.academy.unit.models.CustomType;
import gherkin.deps.com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class ExampleArray {

    String[] myStringArray;
    int[] myIntArray;

    ArrayList<String> myArrayListString;

    public ExampleArray() {
        this.myIntArray = new int[] {10, 21, 3, 0 ,8};
        this.myStringArray = new String[] {"Zero", "Uno", "Due"};
        this.myArrayListString = new ArrayList<String>();
    }

    public void changeValue(String value, int position) {
        this.myStringArray[position] = value;
        printArray(this.myStringArray);
    }

    private void printArray(String[] array){
        for(int i =0; i<array.length;i++) {
            System.out.println("Array[" + i + "] = " + array[i]);
        }
    }

    public void addItemArrayList(String item){
        this.myArrayListString.add(item);
        printArrayList(this.myArrayListString);
    }

    public void addItemArrayList(String item, int position){
        this.myArrayListString.add(position,item);
        printArrayList(this.myArrayListString);
    }

    public void removeItemArrayList(int position){
        this.myArrayListString.remove(position);
        printArrayList(this.myArrayListString);
    }

    public int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for(int i=0; i<n; i++) {
            swapped = false;
            for(int j=1; j<(n-i); j++)
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            if (!swapped)
                break;
        }
        return arr;
    }

    private void printArrayList(ArrayList<String> arrayList){
        for(int i =0; i<arrayList.size();i++) {
            System.out.println("ArrayList[" + i + "] = " + arrayList.get(i));
        }
    }

    public void customArrayList(){
        printCustomArray(getArrayList());
    }

    public ArrayList<CustomType> getArrayList(){
        ArrayList<CustomType> myArrayCustom =  new ArrayList<CustomType>();
        myArrayCustom.add(new CustomType("Fabio","Ziviello",32));
        myArrayCustom.add(new CustomType("Giuseppe","Di Biase",32));
        return myArrayCustom;
    }

    private void printCustomArray(ArrayList<CustomType> arrayCustom){
        for (CustomType customType : arrayCustom) {
            System.out.println("Name: " +customType.getName());
            System.out.println("Surname: " +customType.getSurname());
            System.out.println("Age: " +customType.getAge());
        }
    }

    public void matrix(int row, int col){

        int[][] matrix = new int[row][col];

        //CARICAMENTO
        for (int i=0 ; i<matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }

        System.out.println ("STAMPA VERTICALE");

        //STAMPA VERTICALE
        for (int i=0 ; i<matrix.length ; i++) {
            System.out.print ("\n");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println ("[ " + i + " ] [ " + j + " ] => " + matrix[i][j]);
            }
        }

        System.out.println ("\n STAMPA ORIZZONTALE \n");

        //STAMPA ORIZZONTALE
        for (int i=0 ; i<matrix.length ; i++) {
            System.out.print (" | ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print (matrix[i][j] + " | ");
            }
            System.out.print ("\n");
        }

    }

    public String arrayListToJson(ArrayList<CustomType> arrayList){
        return new Gson().toJson(arrayList);
    }

    public ArrayList<CustomType> jsonToArrayList(String json){
        return new ArrayList<>(Arrays.asList(new Gson().fromJson(json, CustomType[].class)));
    }

}
