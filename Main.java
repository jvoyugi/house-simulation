/**
 *
 * @author Javan Oyugi
 */

import turtle.Turtle;
import turtle.TurtleFrame;
import java.awt.Color;

public class Main {
        public static void main(String[] args) {
                TurtleFrame frame = new TurtleFrame(1200, 730);
                Turtle pen = new Turtle(frame);
                pen.ht().speed(100);
                GUI gui = new GUI();
                gui.drawRoof(pen, gui.generateRandomNumber(200, 250), gui.generateRandomNumber(60, 90),
                                gui.generateRandomNumber(130, 160));
                gui.drawWalls(pen, gui.generateRandomNumber(90, 120));
                gui.drawDoor(pen);
                gui.drawWindow(pen);
                double x = -300, y = -100;
                pen.setPos(gui.x, gui.y);
                pen.label("Rose details");
                gui.y -= 30;
                for (int i = 1; i <= 7; i++) {
                        Color[] roseColor = {
                                        Color.red,
                                        Color.pink, Color.yellow,
                                        new Color((float) gui.generateRandomNumber(0.8, 1),
                                                        (float) gui.generateRandomNumber(0, 0.3),
                                                        (float) gui.generateRandomNumber(0.6, 0.9)) };
                        Color color = roseColor[(int) gui.generateRandomNumber(0, roseColor.length)];
                        pen.setPos(gui.x, gui.y);
                        pen.setPenColor(new Color(0,0,0));
                        pen.label("Rose " + i + "= " + "RGB(" + String.valueOf(color.getRed()) + ","
                                        + String.valueOf(color.getGreen()) + "," + String.valueOf(color.getBlue())
                                        + ")");
                        gui.y -= 30;
                        gui.drawRose(pen, color, y, x);
                        x += 100;
                }
                gui.drawCompound(pen);
        }
}
