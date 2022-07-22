public class Square extends Rectangle implements Moveable {
    private final int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getPerimeter() {
        System.out.printf("Периметр квадрата составит %d ед.", 4 * side);
        System.out.println();
        return 4 * side;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.printf("Этот квадрат перемещен по координатам x= %d, y=%d", x, y);
    }
}
