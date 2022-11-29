package com.smallworldfs.tennis;

public class TennisGame

{
    public Player player1;
    public Player player2;
    public Player winning;
    public Player losing;

    public ResultEnum resultString;

    public TennisGame(String player1Name, String player2Name) {
        player1= new Player(player1Name);
        player2= new Player(player2Name);
    }

    public void addScore(Player play) {
        play.addTotalScore(1);
    }

    public String sameScore() {
        String score="";
        score= player1.getResString() + "-All";
        return score;
    }

    public void determineSituation (Player player1, Player player2) {
        if (player1.getTotalScore() > player2.getTotalScore()) {
            winning= player1;
            losing= player2;
        } else {
            winning= player2;
            losing= player1;
        }
    }

    public String isGameStillGoingOn(Player winning, Player losing, String score) {
        if ((winning.getTotalScore() > 0 && losing.getTotalScore() == 0)
                || (losing.getTotalScore() > 0 && winning.getTotalScore() == 0)
                || (winning.getTotalScore() > losing.getTotalScore() && winning.getTotalScore() < 4)
                || (losing.getTotalScore() > winning.getTotalScore() && losing.getTotalScore() < 4)) {
           return player1.getResString() + "-" + player2.getResString();
        }
        return score;
    }

    public String setAdvantage(Player winning, Player losing){
        if (winning.getTotalScore() > losing.getTotalScore() && losing.getTotalScore() >= 3) {
            return "Advantage ".concat(winning.getName()) ;
        }
        return "";
    }

    public String setWin(Player winning, Player losing, String score){
        if (isEndGameStage(winning, losing)
                && winning.getTotalScore() >= 4 && losing.getTotalScore() >= 0
                && (winning.getTotalScore() - losing.getTotalScore()) >= 2) {
            return "Win for ".concat(winning.getName()) ;
        }
        return score;
    }

    public boolean isEndGameStage(Player player, Player other) {
        return player.getTotalScore() > 3 || other.getTotalScore() > 3 || (player.getTotalScore() == 3 && other.getTotalScore()  == 3);
    }

    public String getScore() {
        String score = "";
        int P1point = player1.getTotalScore();
        int P2point = player2.getTotalScore();

        if ((P1point == P2point && P1point < 4)) {
            score+= sameScore();
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce";

        score =  isGameStillGoingOn(winning, losing, score);

        score =  score + setAdvantage(winning, losing);

        score = setWin(winning, losing, score);

        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            addScore(player1);
        else
           addScore(player2);
    }
}
