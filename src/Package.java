public class Package {
    private Address from;
    private Address to;
    private double weight;
    private double length;
    private double width;
    private double height;

    public Package(Address origin, Address destination, double weight, double length, double width, double height) {
        from = origin;
        to = destination;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public Address getFrom() {
        return from;
    }

    public Address getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

}
