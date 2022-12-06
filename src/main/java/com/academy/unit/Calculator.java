package com.academy.unit;

import com.academy.unit.interfaces.Screen;

import java.math.BigInteger;

public class Calculator implements Screen {

    public Calculator(){}

    public int sum(int a , int b){
        return a+b;
    }

    public int diff(int a , int b){
        return a-b;
    }

    public int mpy(int a , int b){
        return a*b;
    }

    public float div(int a , int b){
        float result = a/b;
        stampa(result);
        return result;
    }

    public int mod(int a , int b){
        int result = a%b;
        stampa(result);
        return result;
    }

    public boolean isPrime(int num){
        if (num<2){
            return false;
        }

        for (int i=2; i<num; i++) {
            if (num%i==0){
                return false;
            }
        }

        return true;
    }

    public BigInteger factorial (BigInteger number ) {
        BigInteger result = BigInteger.valueOf(1);
        for (long factor = 2; factor <= number.longValue(); factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }

    @Override
    public void stampa(int result) {
        System.out.println(result);
    }

    @Override
    public void stampa(float result) {
        System.out.println(result);
    }
}
