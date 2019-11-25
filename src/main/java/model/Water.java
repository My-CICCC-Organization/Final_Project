package model;

public class Water {
    private int totalQuantity;
    private int requiredQuantity;
    private int takenQuantity;
    private int water;


    public Water(int totalQuantity, int requiredQuantity, int water) {
        this.totalQuantity = totalQuantity;
        this.requiredQuantity = requiredQuantity;
        this.water = water;
    }

    public int calculateRequiredQuantity() {
        int weight = 0;
        boolean training = false;
        double exerciseHours = 0;

        double requiredQuantity = weight * 43.6;
        if (training)
            requiredQuantity = requiredQuantity + (350 * exerciseHours);

        return (int) Math.ceil(requiredQuantity);
    }

    public int addQuantity(){
        int input = 0;
        int takenQuantity = 0;
        int totalQuantity =+ takenQuantity;
        return totalQuantity;
    }

    public int convertToCoffee() {
        int water = 0;
        double coffee = water * 0.8;

        return (int) Math.ceil(coffee);
    }

    public int convertToTea() {
        int water = 0;
        double tea = water * 0.85;

        return (int) Math.ceil(tea);

    }
}