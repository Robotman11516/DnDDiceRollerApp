package com.ung.dndDiceRollerApp;

import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Polyhedral {
    public static int LARGEST_NUM = 6;
    public static int SMALLEST_NUM = 1;
    private int mNumber = SMALLEST_NUM;
    private int mImageId;
    private String mTextId;
    private final Random mRandomGenerator;


    public Polyhedral(int number) //"Rolls the die"
    {
        setNumber(number);
        mRandomGenerator = new Random();
    }

    public void setNumber(int number) //Pairs the RNG to a string
    {
        if (number >= SMALLEST_NUM && number <= LARGEST_NUM) {
            mNumber = number;
            switch (number) {
                case 1:
                    break;
                case 2:
                    mTextId = "2";
                    break;
                case 3:
                    mTextId = "3";
                    break;
                case 4:
                    mTextId = "4";
                    break;
                case 5:
                    mTextId = "5";
                    break;
                case 6:
                    mTextId = "6";
                    break;
            }
        }
    }

    /*
    public int getImageId() {
        return mImageId;
    }

    public void addOne() {
        setNumber(mNumber + 1);
    }

    public void subtractOne() {
        setNumber(mNumber - 1);
    }
    */

    public void roll() {
        setNumber(mRandomGenerator.nextInt(LARGEST_NUM) + 1);
    }

}
