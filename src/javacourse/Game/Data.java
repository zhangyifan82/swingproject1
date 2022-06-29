package javacourse.Game;

import javax.swing.*;

public class Data {
    private static String bodyURL = "src/javacourse/Game/方块.png";
    private static ImageIcon body = new ImageIcon(bodyURL);
    private static ImageIcon food = new ImageIcon("src/javacourse/Game/球.png");

    private static ImageIcon up = new ImageIcon("src/javacourse/Game/右.png");
    private static ImageIcon down = new ImageIcon("src/javacourse/Game/下.png");
    private static ImageIcon left = new ImageIcon("src/javacourse/Game/左.png");
    private static ImageIcon right = new ImageIcon("src/javacourse/Game/右.png");

    public static ImageIcon getBody() {
        return body;
    }

    public static void setBody(ImageIcon body) {
        Data.body = body;
    }

    public static ImageIcon getUp() {
        return up;
    }

    public static void setUp(ImageIcon up) {
        Data.up = up;
    }

    public static ImageIcon getDown() {
        return down;
    }

    public static void setDown(ImageIcon down) {
        Data.down = down;
    }

    public static ImageIcon getLeft() {
        return left;
    }

    public static void setLeft(ImageIcon left) {
        Data.left = left;
    }

    public static ImageIcon getRight() {
        return right;
    }

    public static void setRight(ImageIcon right) {
        Data.right = right;
    }

    public static ImageIcon getFood() {
        return food;
    }

    public static void setFood(ImageIcon food) {
        Data.food = food;
    }
}

