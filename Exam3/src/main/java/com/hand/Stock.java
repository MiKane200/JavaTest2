package com.hand;

public class Stock {
    private String name;
    private String open;
    private String close;
    private String current;
    private String high;
    private String low;

    public Stock(String[] singles) {
        this.name = singles[0];
        this.open = singles[1];
        this.close = singles[2];
        this.current = singles[3];
        this.high = singles[4];
        this.low = singles[5];
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }
}
