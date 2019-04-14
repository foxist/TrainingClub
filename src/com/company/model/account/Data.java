package com.company.model.account;

import com.company.io.DataText;
import com.company.view.training.Training;

import java.io.IOException;

public class Data {
    private String name, surname, login, password, gender;
    private int dayTrain, checkBox, counter, approach;
    private int[][] checkDay;
    private int[] attempt;
    private boolean[] pass;

    public Data() {
        checkDay = new int[40][2];
        attempt = new int[41];
        pass = new boolean[40];
        for (int i = 0; i < 40; i++) {
            attempt[i] = 0;
            checkDay[i][0] = 0;
            checkDay[i][1] = 0;
            pass[i] = false;
        }
        attempt[40] = 0;
        this.approach = 0;
    }

    public Data(String name, String surname, String gender, String login, String password, int dayTrain, int checkBox) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.dayTrain = dayTrain;
        this.checkBox = checkBox;
        checkDay = new int[40][2];
        attempt = new int[41];
        pass = new boolean[40];
        for (int i = 0; i < 40; i++) {
            attempt[i] = 0;
            checkDay[i][0] = 0;
            checkDay[i][1] = 0;
            pass[i] = false;
        }
        attempt[40] = 0;
        this.approach = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDayTrain() {
        this.dayTrain++;
    }

    public void setElementDayTrain(int num) {
        this.dayTrain = num;
    }

    public void setCheckBox(int checkBox) {
        this.checkBox = checkBox;
    }

    public void setElement(int dayTrain, int checkBox, int pass) {
        counter++;
        for (int i = 0; i < counter; i++) {
            if (dayTrain == i) {
                checkDay[i][0] = dayTrain + 1;
                checkDay[i][1] = checkBox;
                if (checkDay[i][0] != 0)
                    setAttemptElement(i);
                if (pass == 1)
                    setTrue(dayTrain);
            }
        }
    }

    public void setAttempt(int i, int num) {
        this.attempt[i] = num;
    }

    public void setAttemptElement(int i) {
        this.attempt[i] += 1;
    }

    public int getAttemptElement(int i) {
        return this.attempt[i];
    }

    public void setTrue(int i) {
        pass[i] = true;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getDay(int i) {
        return this.checkDay[i][0];
    }

    public int getCheck(int i) {
        return this.checkDay[i][1];
    }

    public void setDay(int i, int num) { this.checkDay[i][0] = num; }

    public void setCheck(int i, int num) { this.checkDay[i][1] = num; }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public int getDayTrain() {
        return dayTrain;
    }

    public int getCheckBox() {
        return checkBox;
    }

    public boolean getTrueFalse(int i) {
        return pass[i];
    }

    public void setApproach(int approach) {
        this.approach = approach;
    }

    public void incrementApproach() {
        this.approach++;
    }

    public int getApproach() {
        return approach;
    }

    public String getDay(Training training) throws IOException {
        return new DataText().getExerciseOfTrainingDay(training.getFlag());
    }

    public String getExercise(Training training) throws IOException {
        return new DataText().getDayOfTraining(this, training.getFlag());
    }

    public void setDayCheckBox(String login, int day, int check, boolean pass) throws IOException {
        new DataText().setDayCheckBoxText(login, day, check, pass);
    }

    public int getCounter(String login, Data data) throws IOException {
        return new DataText().getDayCheckBoxText(login, data);
    }

    public void setNewUser(String name, String surname, String gender, String login, String password) throws IOException {
        new DataText().setTextFile(name, surname, gender, login, password);
    }

    public Data getUser(String login) throws IOException {
        return new DataText().getTextFile(login);
    }

    public void setNewUserLogin(String login) throws IOException {
        new DataText().setLogin(login);
    }

    public boolean getCompareLogin(String login) throws IOException {
        return new DataText().getCompareLogin(login);
    }

    public boolean getComparePassword(String login, String password) throws IOException {
        return new DataText().getComparePassword(login, password);
    }

    public String getString() throws IOException {
        return new DataText().getString();
    }
}
