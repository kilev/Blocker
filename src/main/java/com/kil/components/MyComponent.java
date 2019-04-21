package com.kil.components;

import com.kil.Logic;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class MyComponent extends Pane {

    private List<MyComponent> localContent = new ArrayList<>();
    private List<Point2D> localPoints = new ArrayList<>();


    private int sizeX;
    private int sizeY;

    class MyCircle extends Circle {
        MyCircle(Point2D point) {
            super(point.getX(), point.getY(), 3);
            this.setOnMouseEntered(e -> {
                this.setRadius(6);
                this.setFill(Color.RED);
            });
            this.setOnMouseExited(e -> {
                this.setRadius(3);
                this.setFill(Color.BLACK);
            });
        }
    }

    MyComponent() {
        this.setOnMouseClicked(e -> {
            String color = "abcdef";
            this.setStyle("-fx-background-color: #" + color);
        });
    }

    public void addNew(int index) {
        switch (Logic.currentTool) {
            case "Ввод":
                localContent.add(index, new ComInPut());
                break;
            case "Вывод":
                localContent.add(index, new ComOutPut());
                break;
        }
        this.recombine();
    }


    protected abstract void drawPoints();

    protected abstract void recombine();

    protected abstract void reDraw();

    protected abstract int computeSizeX();

    protected abstract int computeSizeY();

    public abstract List getCod();

}
