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
public class MyComponent extends Pane {

    private List<MyComponent> localContent = new ArrayList<>();
    private List<Point2D> localPoints = new ArrayList<>();

    private boolean deleteResistance;
    private int size;
    private String alternativeText;

    class MyCircle extends Circle {
        MyCircle(Point2D point) {
            super(point.getX(), point.getY(), 3);
            this.setOnMouseEntered(e->{
                this.setRadius(6);
                this.setFill(Color.RED);
            });
            this.setOnMouseExited(e->{
                this.setRadius(3);
                this.setFill(Color.BLACK);
            });
            this.setOnMouseClicked(e->{

            });
        }
    }

    MyComponent() {

        this.setOnMouseClicked(e -> {
            String color = "abcdef";
            this.setStyle("-fx-background-color: #" + color);
        });
    }

    public void draw() {
    }

    public int computeSize() {
        return size;
    }
}
