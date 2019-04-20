package com.kil.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.PseudoClass;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;


public class ComponentTest extends Region {

    private Label textLabel;
    private StringProperty textProperty = new SimpleStringProperty(this, "text");

    private static final PseudoClass ARMED_PSEUDOCLASS_STATE = PseudoClass.getPseudoClass("armed");

    public ComponentTest(String text) {

        textLabel = new Label();
        textLabel.textProperty().bind(textProperty);

        setFocusTraversable(true);
        setText(text);

        addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
            pseudoClassStateChanged(ARMED_PSEUDOCLASS_STATE, true);
            requestFocus();
        });

        addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
            pseudoClassStateChanged(ARMED_PSEUDOCLASS_STATE, false);
        });

    }


    public final StringProperty getTextProperty() {
        return textProperty;
    }

    public final String getText() {
        return textProperty.get();
    }

    public final void setText(String text) {
        textProperty.set(text);
    }


    @Override
    protected double computePrefWidth(double height) {
        return textLabel.prefWidth(height) + snappedLeftInset() + snappedRightInset();
    }

    @Override
    protected double computePrefHeight(double width) {
        return textLabel.prefHeight(width) + snappedTopInset() + snappedBottomInset();
    }

    @Override
    protected double computeMinWidth(double height) {
        return textLabel.minWidth(height);
    }

    @Override
    protected double computeMinHeight(double width) {
        return textLabel.minWidth(width);
    }

    @Override
    protected double computeMaxWidth(double height) {
        return computePrefWidth(height);
    }

    @Override
    protected double computeMaxHeight(double width) {
        return computePrefHeight(width);
    }

    @Override
    protected void layoutChildren() {
        final double x = snappedLeftInset();
        final double y = snappedTopInset();

        final double w = getWidth() - (snappedLeftInset() + snappedRightInset());
        final double h = getHeight() - (snappedTopInset() + snappedBottomInset());

        textLabel.resizeRelocate(x, y, w, h);
    }
}
