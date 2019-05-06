package com.kil.components;

import com.kil.Logic;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ComIfElse extends MyComponent {

    @Getter
    private List<MyComponent> localContentLeft = new ArrayList<>();
    @Getter
    private List<MyComponent> localContentRight = new ArrayList<>();

    private List<Point2D> localPointsLeft = new ArrayList<>();
    private List<Point2D> localPointsRight = new ArrayList<>();

    private String alternativeText;

    private float maxX;
    private int sizeYL;
    private int sizeYR;


    ComIfElse() {
        alternativeText = "x > 0?";
        setSizeY(100);
        setSizeX(140);

        computeSize();

        localPointsLeft.add(new Point2D(0.0f + maxX/2, 60));
        localPointsRight.add(new Point2D(140.0f + maxX/2, 60));

        this.setMinWidth(maxX + 60.0f + maxX);
        reDraw();
        drawPoints();
    }


    @Override
    public void recombine() {
        computeSize();
        reDraw();
        setPoints();
        drawPoints();
        this.setPrefWidth(maxX + 60.0f + maxX);
        ((MyComponent)this.getParent()).recombine();
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
        int maxXR = 80;
        int maxXL = 80;
        sizeYL = 0;
        sizeYR = 0;

        for (MyComponent component : localContentLeft) {
            sizeYL += component.getSizeY();
            if (component.getSizeX() > maxXL)
                maxXL = component.getSizeX();
        }

        for (MyComponent component : localContentRight) {
            sizeYR += component.getSizeY();
            if (component.getSizeX() > maxXR)
                maxXR = component.getSizeX();
        }

        if(maxXL >= maxXR)
            maxX = maxXL;
        else
            maxX = maxXR;

        setSizeX((int) ( maxX + 60 + maxX));
        if (sizeYL >= sizeYR)
            setSizeY((int) 80.0f + sizeYL + (int) 20.0f);
        else
            setSizeY((int) 80.0f + sizeYR + (int) 20.0f);
    }



    @Override
    protected void reDraw() {
        this.getChildren().clear();

        //
        //input arrow draw start
        Line line1 = new Line();
        line1.setStartX(30.0f + maxX);
        line1.setStartY(0.0f);
        line1.setEndX(30.0f + maxX);
        line1.setEndY(20.0f);
        line1.setStrokeWidth(2);

        Polygon polygon1 = new Polygon();
        polygon1.getPoints().addAll(
                30.0 + maxX, 20.0,
                25.0 + maxX, 10.0,
                35.0 + maxX, 10.0);
        //input arrow draw end
        //

        //
        // if/else body draw start
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(
                maxX + 30.0, 20.0,
                maxX + 80.0, 40.0,
                maxX + 30.0, 60.0,
                maxX - 20.0, 40.0);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);

        Line line2 = new Line();
        line2.setStartX(maxX - 20.0f);
        line2.setStartY(40.0f);
        line2.setEndX(0 + maxX/2);
        line2.setEndY(40.0f);
        line2.setStrokeWidth(2);

        Line line3 = new Line();
        line3.setStartX(80.0f + maxX + maxX/2 - 20.0f);
        line3.setStartY(40.0f);
        line3.setEndX(80.0f + maxX);
        line3.setEndY(40.0f);
        line3.setStrokeWidth(2);

        Label label = new Label(alternativeText);
        label.setFont(new Font("Arial", 20));
        label.setTranslateX(maxX);
        label.setTranslateY(27);

        Line line4 = new Line();
        line4.setStartX(0.0f + maxX/2);
        line4.setStartY(40.0f);
        line4.setEndX(0.0f + maxX/2);
        line4.setEndY(60.0f);
        line4.setStrokeWidth(2);

        Line line5 = new Line();
        line5.setStartX(60.0f + maxX + maxX/2);
        line5.setStartY(40.0f);
        line5.setEndX(60.0f + maxX + maxX/2);
        line5.setEndY(60.0f);
        line5.setStrokeWidth(2);
        // if/else body draw end
        //

        //
        //draw components start
        int offsetL = 60;
        for (MyComponent com : localContentLeft) {
            com.setTranslateY(offsetL);
            com.setTranslateX(maxX/2 - (float) com.getSizeX()/2);
            this.getChildren().addAll(com);
            offsetL += com.getSizeY();
        }

        int offsetR = 60;
        for (MyComponent com : localContentRight) {
            com.setTranslateY(offsetR);
            com.setTranslateX(60.0f + maxX + maxX/2 - (float) com.getSizeX()/2);
            this.getChildren().addAll(com);
            offsetR += com.getSizeY();
        }
        //draw components end
        //

        //
        // if/else tail draw start
        Line line6 = new Line();
        line6.setStartX(60.0f + maxX + maxX/2);
        line6.setStartY(60.0f + sizeYR);
        line6.setEndX(60.0f + maxX + maxX/2);
        line6.setEndY(getSizeY() - 20.0f);
        line6.setStrokeWidth(2);

        Line line7 = new Line();
        line7.setStartX(0.0f + maxX/2);
        line7.setStartY(60.0f + sizeYL);
        line7.setEndX(0.0f + maxX/2);
        line7.setEndY(getSizeY() - 20.0f);
        line7.setStrokeWidth(2);

        Line line8 = new Line();
        line8.setStartX(0.0f + maxX/2);
        line8.setStartY(getSizeY() - 20.0f);
        line8.setEndX(30.0f + maxX);
        line8.setEndY(getSizeY() - 20.0f);
        line8.setStrokeWidth(2);

        Line line9 = new Line();
        line9.setStartX(60.0f + maxX + maxX/2);
        line9.setStartY(getSizeY() - 20.0f);
        line9.setEndX(30.0f + maxX);
        line9.setEndY(getSizeY() - 20.0f);
        line9.setStrokeWidth(2);

        Line line10 = new Line();
        line10.setStartX(30.0f + maxX);
        line10.setStartY(getSizeY() - 20.0f);
        line10.setEndX(30.0f + maxX);
        line10.setEndY(getSizeY());
        line10.setStrokeWidth(2);
        // if/else tail draw end
        //

        polygon.setOnMouseClicked(e -> Logic.setCurrentCom(this));
        label.setOnMouseClicked(e -> Logic.setCurrentCom(this));

        this.getChildren().addAll(line1, polygon1, polygon, line2, line3, label, line4, line5, line6, line7, line8, line9, line10);
    }

    @Override
    protected void setPoints() {
        localPointsLeft.clear();
        localPointsRight.clear();
        localPointsLeft.add(new Point2D(0.0f + maxX/2, 60));
        localPointsRight.add(new Point2D(60.0f + maxX + maxX/2, 60));

        int offsetYL = 60;
        for (MyComponent component : localContentLeft) {
            localPointsLeft.add(new Point2D(0.0f + maxX/2, offsetYL + component.getSizeY()));
            offsetYL += component.getSizeY();
        }

        int offsetYR = 60;
        for (MyComponent component : localContentRight) {
            localPointsRight.add(new Point2D(60.0f + maxX + maxX/2, offsetYR + component.getSizeY()));
            offsetYR += component.getSizeY();
        }
    }

    @Override
    protected void drawPoints() {
        for (Point2D point : localPointsLeft) {
            MyCircle myCircle = new MyCircle(point);
            myCircle.setOnMouseClicked(e -> {
                switch (Logic.currentTool) {
                    case "Ввод":
                        localContentLeft.add(localPointsLeft.indexOf(point), new ComInPut());
                        break;
                    case "Вывод":
                        localContentLeft.add(localPointsLeft.indexOf(point), new ComOutPut());
                        break;
                    case "Процесс":
                        localContentLeft.add(localPointsLeft.indexOf(point), new ComFunc());
                        break;
                    case "Присваивание":
                        localContentLeft.add(localPointsLeft.indexOf(point), new ComAction());
                        break;
                    case "Если...то...иначе":
                        localContentLeft.add(localPointsLeft.indexOf(point), new ComIfElse());
                        break;
                }
                recombine();
            });
            this.getChildren().add(myCircle);
        }
        for (Point2D point : localPointsRight) {
            MyCircle myCircle = new MyCircle(point);
            myCircle.setOnMouseClicked(e -> {
                switch (Logic.currentTool) {
                    case "Ввод":
                        localContentRight.add(localPointsRight.indexOf(point), new ComInPut());
                        break;
                    case "Вывод":
                        localContentRight.add(localPointsRight.indexOf(point), new ComOutPut());
                        break;
                    case "Процесс":
                        localContentRight.add(localPointsRight.indexOf(point), new ComFunc());
                        break;
                    case "Присваивание":
                        localContentRight.add(localPointsRight.indexOf(point), new ComAction());
                        break;
                    case "Если...то...иначе":
                        localContentRight.add(localPointsRight.indexOf(point), new ComIfElse());
                        break;
                }
                recombine();
            });
            this.getChildren().add(myCircle);
        }
    }


    @Override
    public List getCod() {
        List<String> cod = new ArrayList<>();

        //write top part
        cod.add(Logic.getCorrectCod_startIf(alternativeText));
        for (MyComponent com : localContentLeft) {
            List<String> list = com.getCod();
            for (String str : list) {
                cod.add("\t" + str);
            }
        }

        //write middle part
        List<String> mid = Logic.getCorrectCod_midIf();
        for (String str : mid) {
            cod.add(str);
        }

        //write bottom part
        for (MyComponent com : localContentRight) {
            List<String> list = com.getCod();
            for (String str : list) {
                cod.add("\t" + str);
            }
        }
        if (Logic.getCorrectCod_endIf() != "")
            cod.add(Logic.getCorrectCod_endIf());
        return cod;
    }
}
