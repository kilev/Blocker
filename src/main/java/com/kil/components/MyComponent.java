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
                this.setRadius(7);
                this.setFill(Color.RED);
            });
            this.setOnMouseExited(e -> {
                this.setRadius(3);
                this.setFill(Color.BLACK);
            });
        }
    }

    void addNew(int index) {
        switch (Logic.currentTool) {
            case "Ввод":
                localContent.add(index, new ComInPut());
                break;
            case "Вывод":
                localContent.add(index, new ComOutPut());
                break;
            case "Процесс":
                localContent.add(index, new ComFunc());
                break;
            case "Присваивание":
                localContent.add(index, new ComAction());
                break;
            case "Если...то...иначе":
                localContent.add(index, new ComIfElse());
                break;
        }
        recombine();
    }

    public void delete() {
        if (this.getParent() instanceof MyComponent) {
            ((MyComponent) this.getParent()).getLocalContent().remove(this);
            ((MyComponent) this.getParent()).recombine();
        } else {
            this.getLocalContent().clear();
            this.recombine();
        }
    }
    protected  abstract void setPoints();

    protected abstract void drawPoints();

    public abstract void recombine();

    protected abstract void reDraw();

    protected abstract void computeSize();

    public abstract List getCod();

    public abstract List getAlternativeText();

    public abstract void setAlternativeText(List list);

}
