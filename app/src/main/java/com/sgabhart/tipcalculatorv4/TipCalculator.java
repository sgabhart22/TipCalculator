package com.sgabhart.tipcalculatorv4;


public class TipCalculator {
    private float tip, bill;

    public TipCalculator(float newTip, float newBill) {
        setTip(newTip);
        setBill(newBill);
    }

    public float getTip() {
        return tip;
    }

    public float getBill() {
        return bill;
    }

    public void setTip(float newTip) {
        if(newTip > 0) this.tip = newTip;
    }

    public void setBill(float newBill) {
        if(newBill > 0) this.bill = newBill;
    }

    public float tipAmount() {
        return bill * (tip / 100);
    }

    public float totalAmount() {
        return bill + tipAmount();
    }
}
