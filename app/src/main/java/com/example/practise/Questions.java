package com.example.practise;

public class Questions {

    private int answerid;
    private boolean answertrue;

    public Questions(int answerid, boolean answertrue) {
        this.answerid = answerid;
        this.answertrue = answertrue;
    }

    public int getAnswerid() {
        return answerid;
    }

    public void setAnswerid(int answerid) {
        this.answerid = answerid;
    }

    public boolean isAnswertrue() {
        return answertrue;
    }

    public void setAnswertrue(boolean answertrue) {
        this.answertrue = answertrue;
    }
}
