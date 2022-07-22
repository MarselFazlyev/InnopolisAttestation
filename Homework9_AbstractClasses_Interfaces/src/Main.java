public class Main {
    public static void main(String[] args) {
        // Демонстрация приведена конкретными явными значениями чисел
        Figure[] figures = {new Circle(10), new Ellipse(20, 3),
                new Rectangle(3, 7), new Square(100)};
        for (int i = 0; i < figures.length; i++) {
            figures[i].getPerimeter();
            if (figures[i] instanceof Circle || figures[i] instanceof Square)
                ((Moveable) figures[i]).move(25, 40);
        }
    }
}
