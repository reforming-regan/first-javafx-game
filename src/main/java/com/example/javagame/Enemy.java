package com.example.javagame;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

public abstract class Enemy {

    private double myHealth;

    private double mySpeed;

    private ImageView myImage;

    private boolean myAlive;

    public void takeDamage(double theDmg) {
        myHealth -= theDmg;
    }

    public void moveAlongPath(Path thePath) {

    }

}
