package com.kil.components;

import com.kil.Logic;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class ComAction extends MyComponent {

    private String alternativeText;

    ComAction(){
        alternativeText = "x = 0";
        setSizeY(80);
        setSizeX(80);
        reDraw();
    }


    @Override
    protected void reDraw() {

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                0.0, 20.0,
                80.0, 20.0,
                80.0, 60.0,
                0.0, 60.0);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);

        Label label = new Label(alternativeText);
        label.setFont(new Font("Arial", 20));
        label.setTranslateX(14);
        label.setTranslateY(26);

        Polygon polygon1 = new Polygon();
        polygon1.getPoints().addAll(
                40.0, 20.0,
                35.0, 10.0,
                45.0, 10.0);

        Line line1 = new Line();
        line1.setStartX(40.0f);
        line1.setStartY(0.0f);
        line1.setEndX(40.0f);
        line1.setEndY(20.0f);
        line1.setStrokeWidth(2);

        Line line2 = new Line();
        line2.setStartX(40.0f);
        line2.setStartY(60.0f);
        line2.setEndX(40.0f);
        line2.setEndY(80.0f);
        line2.setStrokeWidth(2);

        polygon.setOnMouseClicked(e-> Logic.setCurrentCom(this));
        label.setOnMouseClicked(e-> Logic.setCurrentCom(this));

        this.getChildren().addAll(polygon, line1, line2, polygon1, label);
    }

    @Override
    public List getCod() { return Logic.getCorrectCod_action(alternativeText); }

    @Override
    public List getAlternativeText() {
        List<String> result = new ArrayList<>();
        result.add(alternativeText);
        return result;
    }

    @Override
    public void setAlternativeText(List list) {
        alternativeText = list.get(0).toString();
    }

    @Override
    protected void computeSize() {
    }

    @Override
    protected void setPoints() {

    }

    @Override
    protected void drawPoints() {
    }

    @Override
    public void recombine() {
        reDraw();
    }
}
