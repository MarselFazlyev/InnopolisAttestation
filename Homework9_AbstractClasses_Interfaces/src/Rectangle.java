public class Rectangle extends Figure {
    protected int sideA;
    protected int sideB;

    public Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle() {
    }

    @Override
    int getPerimeter() {
        System.out.printf("Периметр прямоугольника составит %d ед.", 2 * (sideA + sideB));
        System.out.println("\n*******************************");
        return 2 * (sideA + sideB);
    }
}
