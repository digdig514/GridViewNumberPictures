package com.example.digdig.creategriedviewexemple.model;

import android.graphics.Color;

/**
 * Created by digdig on 17-05-18.
 */

public class Numbers {

    private String numbers;
    private int textColor;

    public Numbers(String numbers, int textColor) {
        this.numbers = numbers;
        this.textColor = textColor;
    }

    public Numbers(String numbers) {
        this(numbers, Color.BLACK);
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    @Override
    public String toString() {
        return getNumbers();
    }
}
