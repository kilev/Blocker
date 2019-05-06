package com.kil.components;

import com.kil.Logic;
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

    private String alternativeText1 = "Start";
    private String alternativeText2 = "End";

    int biggestX;
    int offsetX;


    public ComBase(){
        setSizeX(80);
        //setTranslateX(20);
        recombine();
    }


    //drawing Component
    @Override
    public void reDraw() {
        this.getChildren().clear();

        Ellipse ellipse1 = new Ellipse(40, 20);
        ellipse1.setFill(Color.WHITE);
        ellipse1.setStroke(Color.BLACK);
        ellipse1.setCenterX(40 + offsetX);
        ellipse1.setCenterY(20);

        Line line1 = new Line();
        line1.setStartX(40.0f + offsetX);
        line1.setStartY(40.0f);
        line1.setEndX(40.0f + offsetX);
        line1.setEndY(60.0f);
        line1.setStrokeWidth(2);

        Label label1 = new Label(alternativeText1);
        label1.setFont(new Font("Arial", 30));
        label1.setTranslateX(7 + offsetX);

        //draw com
        int offsetY = 60;
        for (MyComponent com : getLocalContent()) {
            com.setTranslateY(offsetY);
            com.setTranslateX((float)(biggestX/2 - com.getSizeX()/2));
            this.getChildren().add(com);
            offsetY += com.getSizeY();
        }


        Ellipse ellipse2 = new Ellipse(40, 20);
        ellipse2.setFill(Color.WHITE);
        ellipse2.setStroke(Color.BLACK);
        ellipse2.setCenterX(40 + offsetX);
        ellipse2.setCenterY(40 + offsetY);

        Line line2 = new Line();
        line2.setStartX(40.0f + offsetX);
        line2.setStartY(0.0f + offsetY);
        line2.setEndX(40.0f + offsetX);
        line2.setEndY(20.0f + offsetY);
        line2.setStrokeWidth(2);

        Label label2 = new Label(alternativeText2);
        label2.setFont(new Font("Arial", 30));
        label2.setTranslateX(13 + offsetX);
        label2.setTranslateY(20 + offsetY);

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                40.0 + offsetX, 20.0 + offsetY,
                35.0 + offsetX, 10.0 + offsetY,
                45.0 + offsetX, 10.0 + offsetY);

        //add click listener
        ellipse1.setOnMouseClicked(e-> Logic.setCurrentCom(this));
        ellipse2.setOnMouseClicked(e-> Logic.setCurrentCom(this));
        label1.setOnMouseClicked(e-> Logic.setCurrentCom(this));
        label2.setOnMouseClicked(e-> Logic.setCurrentCom(this));


        this.getChildren().addAll(ellipse1, line1, label1, ellipse2, line2, label2, polygon);
    }



    @Override
    public void recombine() {
        computeSize();
        setPoints();
        reDraw();
        drawPoints();
    }


    @Override
    public List getCod() {
        List<String> cod = new ArrayList<>();
        cod.add(Logic.getCorrectCod_start());

        for (MyComponent com : getLocalContent()) {
            List<String> list = com.getCod();
            for (String str : list) {
                cod.add("\n\t" + str);
            }
        }

        cod.add("\n" + Logic.getCorrectCod_end());
        return cod;
    }

    @Override
    public List getAlternativeText() {
        return null;
    }

    @Override
    public void setAlternativeText(List list) {

    }

    @Override
    protected void computeSize() {
        biggestX = 80;
        for (MyComponent component: getLocalContent()) {
            if(component.getSizeX() > biggestX)
                biggestX = component.getSizeX();
        }
        offsetX = biggestX/2 - this.getSizeX()/2;
    }

    @Override
    protected void setPoints() {
        getLocalPoints().clear();
        getLocalPoints().add(new Point2D(40 + offsetX, 60));

        int offset = 0;
        for (MyComponent com: getLocalContent()){
            offset +=com.getSizeY();
            getLocalPoints().add(new Point2D(40 + offsetX, 60 + offset));
        }
    }

    @Override
    protected void drawPoints() {
        for (Point2D point : getLocalPoints()) {
            MyCircle myCircle = new MyCircle(point);
            myCircle.setOnMouseClicked(e -> addNew(getLocalPoints().indexOf(point)));
            this.getChildren().add(myCircle);
        }
    }
}
