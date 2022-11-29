package com.smallworldfs.tennis;

public enum ResultEnum {
    LOVE {
        @Override
        public boolean isLove() {
            return true;
        }
        @Override
        public void setScoreText() {
            this.scoreText="Love";
        }
    },
    FIFTEEN  {
        @Override
        public boolean isFifteen() {
            return true;
        }
        @Override
        public void setScoreText() {
            this.scoreText="Fifteen";
        }
    } ,
    THIRTY {
        @Override
        public boolean isThirty() {
            return true;
        }
        @Override
        public void setScoreText() {
            this.scoreText="Thirty";
        }
    },
    FORTY {
        @Override
        public boolean isForty() {
            return true;
        }
        @Override
        public void setScoreText() {
            this.scoreText="Forty";
        }
    },
    DEUCE,
    ALL,
    ADVANTAGE;

    public int score;
    public String scoreText;

    public void setScoreText() {
        scoreText="";
    }
    public boolean isLove() {
        return false;
    }
    public boolean isFifteen() {
        return false;
    }

    public boolean isThirty() {
        return false;
    }

    public boolean isForty() {
        return false;
    }

    public void setScore(int score) {
        this.score= score;
    }
    public String getScoreText() {
        return this.scoreText;
    }
}
