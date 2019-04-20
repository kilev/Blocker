package com.kil.components;

import com.kil.Logic;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MyComponent extends Pane {

    private List<MyComponent> localContent = new ArrayList<>();
    private List<Point2D> localPoints = new ArrayList<>();

    private boolean deleteRes;
    private int size;

    class MyCircle{
        MyCircle(){
            super();
        }
    }

    MyComponent() {

        this.setOnMouseClicked(e -> {
            String color = "abcdef";
            this.setStyle("-fx-background-color: #" + color);
            Logic.currentPane = this;
        });
    }

    public void draw() {
    }

    public int computeSize(){
        return size;
    }
}
