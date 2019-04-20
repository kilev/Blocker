package com.kil.components;

import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class ComBase extends MyComponent {

    private String text1 = "Start";
    private String text2 = "End";

    Pane pane1 = new Pane();
    Pane pane2 = new Pane();


    public ComBase() {

        getLocalPoints().add(new Point2D(40,60));

        setDeleteRes(true);
        setTranslateX(20);
        setTranslateY(20);

        draw();
        setPoints();
    }

    private void recombine() {

    }


    //drawing Component
    @Override
    public void draw() {
        Ellipse ellipse1 = new Ellipse(40, 20);
        ellipse1.setFill(Color.WHITE);
        ellipse1.setStroke(Color.BLACK);
        ellipse1.setCenterX(40);
        ellipse1.setCenterY(20);

        Line line1 = new Line();
        line1.setStartX(40.0f);
        line1.setStartY(40.0f);
        line1.setEndX(40.0f);
        line1.setEndY(60.0f);
        line1.setStroke(Color.BLACK);
        line1.setStrokeWidth(2);

        Label label1 = new Label(text1);
        label1.setFont(new Font("Arial", 30));
        label1.setTranslateX(7);


        Ellipse ellipse2 = new Ellipse(40, 20);
        ellipse2.setFill(Color.WHITE);
        ellipse2.setStroke(Color.BLACK);
        ellipse2.setCenterX(40);
        ellipse2.setCenterY(40);

        Line line2 = new Line();
        line2.setStartX(40.0f);
        line2.setStartY(0.0f);
        line2.setEndX(40.0f);
        line2.setEndY(20.0f);
        line2.setStroke(Color.BLACK);
        line2.setStrokeWidth(2);

        Label label2 = new Label(text2);
        label2.setFont(new Font("Arial", 30));
        label2.setTranslateX(13);
        label2.setTranslateY(20);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                40.0, 20.0,
                35.0, 10.0,
                45.0, 10.0);

        pane1.getChildren().addAll(ellipse1, line1, label1);
        pane2.getChildren().addAll(ellipse2, line2, label2, polygon);
        pane2.setTranslateY(60);

        this.getChildren().removeAll();
        this.getChildren().addAll(pane1, pane2);
        this.setPrefHeight(120);
    }

    private void setPoints(){
        for (Point2D point: getLocalPoints()) {
            Circle circle = new Circle(point.getX(), point.getY(), 3);
            circle.setOnMouseEntered(e->{
                circle.setRadius(6);
                circle.setFill(Color.RED);
            });
            circle.setOnMouseExited(e->{
                circle.setRadius(3);
                circle.setFill(Color.BLACK);
            });
            this.getChildren().add(circle);
        }
    }
}
