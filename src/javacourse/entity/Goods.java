package javacourse.entity;

import java.io.Serializable;

public class Goods implements Serializable{
    private int id;
    private String name;
    private String kind;//种类
    private String path;//图片路径
    private double price;
    private String information;//商品信息
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public Goods() {
    }

    public Goods(String name, String kind, String path, double price, String information) {

        this.name = name;
        this.kind = kind;
        this.path = path;
        this.price = price;
        this.information = information;
    }

    public void setInformation(String information) {
        this.information = information;
    }


    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", path='" + path + '\'' +
                ", price=" + price +
                ", information='" + information + '\'' +
                '}';
    }
}
