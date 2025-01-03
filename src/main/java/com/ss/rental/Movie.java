package com.ss.rental;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private Price price;

    private String _title;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }


    public String getTitle() {
        return _title;
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }
    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR -> price = new RegularPrice();
            case CHILDRENS -> price = new ChildrenPrice();
            case NEW_RELEASE -> price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public Price price() {
        return price;
    }



}