package com.example;

import java.util.List;

public class Lion extends Feline{

    boolean hasMane;

    private Catlike catlike;

    public Lion(Catlike catlike, String sex) throws Exception {
        this.catlike = catlike;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }



    public int getKittens() {
        return catlike.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return super.getFood("Хищник");
    }
}
