package com.smallworldfs.tennis;

public class Player {
    private int totalScore=0;
    private String Name;
    private ResultEnum scoreEnum= ResultEnum.LOVE;

    public Player(String playerName)
    {
        this.Name= playerName;
        this.scoreEnum.LOVE.setScoreText();
    }

    public int getTotalScore(){
        return this.totalScore;
    }

    public void setTotalScore(int points) {
        this.scoreEnum.setScore(points);
        switch(points) {
            case 0:
                this.scoreEnum= ResultEnum.LOVE;
                this.scoreEnum.LOVE.setScoreText();
                break;
            case 1:
                this.scoreEnum= ResultEnum.FIFTEEN;
                this.scoreEnum.FIFTEEN.setScoreText();
                break;
            case 2:
                this.scoreEnum= ResultEnum.THIRTY;
                this.scoreEnum.THIRTY.setScoreText();
                break;
            case 3:
                this.scoreEnum= ResultEnum.FORTY;
                this.scoreEnum.FORTY.setScoreText();
        }
    }

    public void addTotalScore(int points) {
        this.totalScore+=points;
        setTotalScore(totalScore);
    }

    public String getResString() {
        return this.scoreEnum.getScoreText();
    }

    public String getName() {return this.Name;}
}
