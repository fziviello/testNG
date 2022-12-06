package com.academy.unit;

public class Costruct {

    public Costruct() { }

    public int _for(int index, int condition){

        int i = 0;

        for(i = index; i<condition; i++){
            System.out.println("Index: "+ i);
        }

        return i;

    }

    public int _forEach(int[] numbers){
        int cont = 0;

        for (int number : numbers) {
            cont ++;
            System.out.println("Numero: " + number + " posizione: " + cont);
        }

        return cont;
    }

    public int _while(int index, int condition){

       int i = index;

       while (i != condition){
           System.out.println("Index: "+ i);
           i ++;
       }

       return i;
    }

    public int _doWhile(int index, int condition){

        int i = index;

        do{
            System.out.println("Index: "+ i);
            i++;
        }
        while (i != condition);

        return i;
    }

    public boolean _ifelse(int a, int b){

        if(a==b) {
            return true;
        }
        else {
            return false;
        }
    }

    public int _switchCase(int code){

        switch (code){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return -1;
        }

    }

    public void pyramid(int base){
        for(int i = 0; i < base; i++) {
            for (int j = base; j > i; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j < 2*i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
