
import java.awt.Color;

public class GUI {
    double distance, height;
    int x = -600, y = 330;
    Color wallColor, doorColor;

    public void drawCompound(turtle.Turtle pen) {
        pen.st().setPos(600,-200);
        for (int i = 0; i < 2; i++) {
            pen.pd().lt(90).bk(800).rt(90).bk(600);
        }
        pen.setFillColor(new Color(190, 190, 190));
        pen.fill(-99, 310);
    }

    public void drawRoof(turtle.Turtle pen, double top, double height, double angle) {
        Color color = new Color((float) generateRandomNumber(0, 1), (float) generateRandomNumber(0, 1),
                (float) generateRandomNumber(0, 1));
        double side = calculateSideLength(height, angle);
        double baseLength = calculateBaseLength(height, angle);
        pen.setPenColor(new Color(0, 0, 0));
        pen.setPos(x, y);
        pen.label("Roof details");
        y -= 30;
        pen.setPos(x, y);
        pen.label("Color=" + "RGB(" + String.valueOf(color.getRed()) + "," + String.valueOf(color.getGreen()) + ","
                + String.valueOf(color.getBlue()) + ")");
        y -= 30;
        pen.setPos(x, y);
        pen.label("Top length=" + String.valueOf(top));
        y -= 30;
        pen.setPos(x, y);
        pen.label("Roof height=" + String.valueOf(height));
        y -= 30;
        pen.setPos(x, y);
        pen.label("Roof angle=" + String.valueOf(angle) + String.valueOf((char) 176));
        y -= 30;
        pen.setPos(x, y);
        pen.label("Roof base=" + String.valueOf((baseLength * 2) + top));
        y -= 30;
        pen.penUp();
        pen.setPos(330, 300);
        pen.setFillColor(color);
        pen.pd().rt(90).bk(top).rt(angle).fd(side).rt(180 - angle).bk((baseLength * 2) + top).rt(180 - angle).fd(side);
        pen.fill(pen.curX() - 1, pen.curY() - 1);
        pen.penUp().rt(angle - 90);
        pen.setPos(330 + baseLength / 2, 300 - height);
        distance = pen.distance(330 - (baseLength / 2) - top, 300 - height);
    }

    public void drawWalls(turtle.Turtle pen, double width) {
        for (int i = 0; i < 2; i++) {
            pen.pd().bk(width).rt(90).bk(distance).rt(90).pu();
        }
        height = width;
        pen.setPos(pen.curX() - 3 * distance / 4, pen.curY() - width);
    }

    public void drawDoor(turtle.Turtle pen) {
        doorColor = new Color((float) generateRandomNumber(0, 1), (float) generateRandomNumber(0, 1),
                (float) generateRandomNumber(0, 1));
        pen.setFillColor(doorColor);
        for (int i = 0; i < 2; i++) {
            pen.pd().rt(90).fd(distance / 9).rt(90).bk(height * 0.75).pu();
        }
        pen.fill(pen.curX() + 3, pen.curY() + 4);
        pen.setPos(pen.curX() + 5 * distance / 9, pen.curY() + height * 0.75);
    }

    public void drawWindow(turtle.Turtle pen) {
        for (int i = 0; i < 4; i++) {
            Color color = new Color((float) generateRandomNumber(0, 1), (float) generateRandomNumber(0, 1),
                    (float) generateRandomNumber(0, 1));
            pen.setFillColor(color);
            for (int j = 0; j < 4; j++) {
                pen.pd().rt(90).fd(height / 5);
            }
            if (i == 0) {
                pen.fill(pen.getX() + 1, pen.getY() - 1);
            }
            if (i == 1) {
                pen.fill(pen.getX() + 1, pen.getY() + 1);
            }
            if (i == 2) {
                pen.fill(pen.getX() - 1, pen.getY() + 1);
            }
            if (i == 3) {
                pen.fill(pen.getX() - 1, pen.getY() - 1);
            }
            pen.lt(90);
        }
        wallColor = new Color((float) generateRandomNumber(0, 1), (float) generateRandomNumber(0, 1),
                (float) generateRandomNumber(0, 1));
        pen.setFillColor(wallColor);
        pen.fill(pen.curX() - 60, pen.curY());
        pen.setPos(x, y);
        pen.label("Wall details");
        y -= 30;
        pen.setPos(x, y);
        pen.label("Color=" + "RGB(" + String.valueOf(wallColor.getRed()) + "," + String.valueOf(wallColor.getGreen())
                + "," + String.valueOf(wallColor.getBlue()) + ")");
        y -= 30;
        pen.setPos(x, y);
        pen.label("Height=" + String.valueOf(height));
        y -= 30;
        pen.setPos(x, y);
        pen.label("Width=" + String.valueOf(distance));
        y -= 30;
        pen.setPos(x, y);
        pen.label("Door details");
        y -= 30;
        pen.setPos(x, y);
        pen.label("Height=" + String.valueOf(height * 0.75));
        y -= 30;
        pen.setPos(x, y);
        pen.label("Width=" + String.valueOf(distance / 9));
        y -= 30;
        pen.setPos(x, y);
        pen.label("Color=" + "RGB(" + String.valueOf(doorColor.getRed()) + "," + String.valueOf(doorColor.getGreen())
                + "," + String.valueOf(doorColor.getBlue()) + ")");
        y -= 30;
        pen.setPos(x, y);
        pen.label("Window details");
        y -= 30;
        pen.setPos(x, y);
        pen.label("Side=" + String.valueOf(height * 0.2 * 2));
        y -= 30;
    }

    public void drawRose(turtle.Turtle pen, Color color, double c, double d) {
        pen.setPenColor(color).setFillColor(color);
        pen.pd().drawOval(c + 71, d + 171, 70, 40).fill(pen.curX() - 1, pen.curY() - 1);
        pen.drawOval(c + 86, d + 186, 40, 70).fill(pen.curX() - 20, pen.curY() - 30).fill(pen.curX() - 20,
                pen.curY() + 30);
        pen.setPenColor(new Color(0, 0, 0));
        pen.pd().drawArc(c + 50, d + 180, 25, 30, 345, 150);
        pen.drawArc(c + 45, d + 205, 25, 30, 160, -105);
        pen.drawArc(c + 60, d + 220, 30, 20, 230, -105);
        pen.drawArc(c + 77, d + 203, 30, 20, 290, -120);
        pen.drawArc(c + 87, d + 178, 25, 30, 345, -120);
        pen.drawArc(c + 60, d + 158, 30, 20, 50, -70);
        pen.setPenColor(Color.GREEN);
        pen.setPos(pen.curX() + 18, pen.curY() - 31).lt(25);
        for (int i = 0; i < 2; i++) {
            pen.fd(90).lt(90).fd(3).lt(90);
        }
        pen.setFillColor(Color.GREEN).fill(pen.curX() + 1, pen.curY() - 20);
    }

    protected double calculateSideLength(double height, double angle) {
        return height / Math.cos(Math.toRadians(angle - 90));
    }

    protected double calculateBaseLength(double height, double angle) {
        return (height * Math.tan(Math.toRadians(angle - 90)));
    }

    public double generateRandomNumber(double a, double b) {
        return a + Math.random() * (b - a);
    }
}