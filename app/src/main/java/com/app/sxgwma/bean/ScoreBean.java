package com.app.sxgwma.bean;


import io.realm.RealmObject;

/**
 * our data object
 */
public class ScoreBean extends RealmObject {

    private float totalScore;

    private int scoreNr;

    private String playerName;

    public ScoreBean() {
    }

    public ScoreBean(float totalScore, int scoreNr, String playerName) {
        this.scoreNr = scoreNr;
        this.playerName = playerName;
        this.totalScore = totalScore;
    }

    // all getters and setters...

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    public int getScoreNr() {
        return scoreNr;
    }

    public void setScoreNr(int scoreNr) {
        this.scoreNr = scoreNr;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}