public class Circle extends Ellipse implements Moveable {
    private final int radius;

    public Circle(int radius) {
        super();
        this.radius = radius;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.printf("Круг перемещен по координатам x= %d, y=%d", x, y);
        System.out.println("\n*******************************");
    }

    @Override
    int getPerimeter() {
        System.out.printf("Периметр круга составит %d ед.", (int) Math.round(2 * Math.PI * radius));
        System.out.println();
        return (int) Math.round(2 * Math.PI * radius);
    }
}
