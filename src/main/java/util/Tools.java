package util;

public class Tools {
    // convert unit Oz to ml
    public static double exchangeSize(String sizeOz) {
        // “Oz” * 0.033814 ＝“ml”
        return Double.parseDouble(sizeOz) * Constants.CONVERT_SIZE;
    }

    // convert unit Lb to Kg
    public static double exchangeWeight(String weightLb) {
        // “lb” * 0.45 ＝“kg”
        return Double.parseDouble(weightLb) * Constants.CONVERT_WEIGHT;
    }
}