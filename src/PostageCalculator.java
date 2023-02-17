public class PostageCalculator {
    private static final double BASE_COST = 3.75;
    public static double calculatePostage(int zipCode1, int zipCode2, double weight, double length, double width, double height) {
        return(BASE_COST + ((int) (weight / 10) * 0.05 + (int) (weightOver40(weight) / 10) * 0.1) + (dimensionsOver36(length + width + height) * 0.1) + ((double) Math.abs(zipCode1 - zipCode2) / 100));
    }
    public static double calculatePostage(Address address1, Address address2, double weight, double length, double width, double height) {
        return(calculatePostage(address1.getZipCode(), address2.getZipCode(), weight, length, width, height));
    }
    public static double calculatePostage(Package pack) {
        return calculatePostage(pack.getFrom(), pack.getTo(), pack.getWeight(), pack.getLength(), pack.getWidth(), pack.getHeight());
    }
    private static double weightOver40(double weight) {
        if(weight > 40) {
            return weight - 40;
        }
        return 0;
    }
    private static double dimensionsOver36(double dimensions) {
        if(dimensions > 36) {
            return dimensions - 36;
        }
        return 0;
    }
}
