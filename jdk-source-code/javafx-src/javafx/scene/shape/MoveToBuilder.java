/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javafx.scene.shape;

/**
Builder class for javafx.scene.shape.MoveTo
@see javafx.scene.shape.MoveTo
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class MoveToBuilder<B extends javafx.scene.shape.MoveToBuilder<B>> extends javafx.scene.shape.PathElementBuilder<B> implements javafx.util.Builder<javafx.scene.shape.MoveTo> {
    protected MoveToBuilder() {
    }

    /** Creates a new instance of MoveToBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.shape.MoveToBuilder<?> create() {
        return new javafx.scene.shape.MoveToBuilder();
    }

    private int __set;
    public void applyTo(javafx.scene.shape.MoveTo x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setX(this.x);
        if ((set & (1 << 1)) != 0) x.setY(this.y);
    }

    private double x;
    /**
    Set the value of the {@link javafx.scene.shape.MoveTo#getX() x} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B x(double x) {
        this.x = x;
        __set |= 1 << 0;
        return (B) this;
    }

    private double y;
    /**
    Set the value of the {@link javafx.scene.shape.MoveTo#getY() y} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B y(double x) {
        this.y = x;
        __set |= 1 << 1;
        return (B) this;
    }

    /**
    Make an instance of {@link javafx.scene.shape.MoveTo} based on the properties set on this builder.
    */
    public javafx.scene.shape.MoveTo build() {
        javafx.scene.shape.MoveTo x = new javafx.scene.shape.MoveTo();
        applyTo(x);
        return x;
    }
}