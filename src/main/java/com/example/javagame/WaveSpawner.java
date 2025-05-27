package com.example.javagame;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.List;

public class WaveSpawner {

    private final Group root;
    private final Path path;
    private final List<List<String>> waveImagePaths; // Each wave contains a list of enemy image file names
    private final Duration enemyInterval;
    private final Duration waveInterval;

    private int currentWave = 0;

    public WaveSpawner(Group root, Path path, List<List<String>> waveImagePaths, Duration enemyInterval, Duration waveInterval) {
        this.root = root;
        this.path = path;
        this.waveImagePaths = waveImagePaths;
        this.enemyInterval = enemyInterval;
        this.waveInterval = waveInterval;
    }

    public void start() {
        if (waveImagePaths.isEmpty()) return;

        Timeline waveTimeline = new Timeline();

        for (int i = 0; i < waveImagePaths.size(); i++) {
            final int waveIndex = i;

            waveTimeline.getKeyFrames().add(new KeyFrame(waveInterval.multiply(i), event -> {
                spawnWave(waveImagePaths.get(waveIndex));
            }));
        }

        waveTimeline.play();
    }

    private void spawnWave(List<String> enemyImages) {
        Timeline enemyTimeline = new Timeline();
        enemyTimeline.setCycleCount(enemyImages.size());

        for (int i = 0; i < enemyImages.size(); i++) {
            final String imageName = enemyImages.get(i);

            enemyTimeline.getKeyFrames().add(
                    new KeyFrame(enemyInterval.multiply(i), e -> spawnEnemy(imageName))
            );
        }

        enemyTimeline.play();
    }

    private void spawnEnemy(String imageFileName) {
        Image enemyImage = new Image(getClass().getResource("/images/" + imageFileName).toExternalForm());
        ImageView enemy = new ImageView(enemyImage);
        enemy.setFitWidth(90);
        enemy.setFitHeight(90);
        enemy.setTranslateX(-100);
        enemy.setTranslateY(-100);

        PathTransition transition = new PathTransition();
        transition.setNode(enemy);
        transition.setPath(path);
        transition.setDuration(Duration.seconds(7));
        transition.setCycleCount(1);

        root.getChildren().add(enemy);
        transition.play();
    }
}
