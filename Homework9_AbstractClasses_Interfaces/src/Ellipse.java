public class Ellipse extends Figure {
    protected int majorAxis;
    protected int minorAxis;

    public Ellipse(int majorAxis, int minorAxis) {
        if (minorAxis > 0 && majorAxis > minorAxis) {
            this.majorAxis = majorAxis;
            this.minorAxis = minorAxis;
        } else throw new IllegalArgumentException("majorAxis меньше, чем minorAxis");
    }

    public Ellipse() {
    }

    @Override
    int getPerimeter() {
        System.out.printf("Периметр эллипса составит %d ед.", (int) Math.round(2 * Math.PI *
                Math.sqrt(majorAxis * majorAxis + minorAxis * minorAxis)));
        System.out.println("\n*******************************");
        return (int) Math.round(2 * Math.PI * Math.sqrt(majorAxis * majorAxis + minorAxis * minorAxis));
    }
}
