package com.company.io;

import com.company.model.account.Data;

import java.io.*;

public class DataText {

    public void setTextFile(String name, String surname, String gender, String login, String password) throws IOException {
        FileWriter fw = new FileWriter("C:/Users/zayil/ideaProjects/Gym/resources/account/" + login + ".txt");
        fw.write(name + "\n");
        fw.write(surname + "\n");
        fw.write(gender + "\n");
        fw.write(login + "\n");
        fw.write(password + "\n");
        fw.flush();
        fw.close();
    }

    public Data getTextFile(String login) throws IOException {
        Data data = new Data();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:/Users/zayil/ideaProjects/Gym/resources/account/" + login + ".txt")));
        data.setName(br.readLine());
        data.setSurname(br.readLine());
        data.setGender(br.readLine());
        data.setLogin(br.readLine());
        data.setPassword(br.readLine());

        br.close();
        return data;
    }

    public boolean getComparePassword(String login, String password) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:/Users/zayil/ideaProjects/Gym/resources/account/" + login + ".txt")));
        br.readLine();
        br.readLine();
        br.readLine();
        br.readLine();

        if ((password.equals(br.readLine())))
            return true;

        br.close();
        return false;
    }

    public void setDayCheckBoxText(String login, int day, int check, boolean pass) throws IOException {
        FileWriter fw = new FileWriter(
                "C:/Users/zayil/ideaProjects/Gym/resources/statistic/of_" + login + ".txt", true);
        if (day >= 10) {
            int i = day / 10;
            int c = day - i * 10;
            fw.write(Integer.toString(i));
            fw.write("\n");
            fw.write(Integer.toString(c));
        } else {
            fw.write(Integer.toString(day));
        }
        fw.write(" ");
        fw.write(Integer.toString(check));
        fw.write(" ");
        if (pass)
            fw.write(Integer.toString(1));
        else
            fw.write(Integer.toString(0));
        fw.write("\n");

        fw.flush();
        fw.close();
    }

    public int getDayCheckBoxText(String login, Data data) throws IOException {
        FileReader fr = new FileReader("C:/Users/zayil/ideaProjects/Gym/resources/statistic/of_" + login + ".txt");
        int day, counter = 0;
        for (int i = 0; i < 40; i++) {
            if (data.getAttemptElement(i) == 0)
                break;
            data.setAttempt(i, 0);
        }
        while ((day = fr.read()) != -1) {
            int sp = fr.read();
            if (sp == 10) {
                if (day - 48 == 1)
                    day += 9;
                else if (day - 48 == 2)
                    day += 18;
                else if (day - 48 == 3)
                    day += 27;
                else if (day - 48 == 4)
                    day += 36;
                day = day + fr.read() - 48;
                fr.read();
            }
            int check = fr.read();
            fr.read();
            int pass = fr.read();
            data.setElement(day - 48, check - 48, pass - 48);
            fr.read();
        }
        for (int i = 0; data.getAttemptElement(i) != 0; i++)
            counter++;

        fr.close();
        return counter;
    }

    public String getDayOfTraining(Data data, int num) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
                "C:/Users/zayil/ideaProjects/Gym/resources/exercise/exercises.txt"), "cp1251"));
        StringBuilder stringBuilder = new StringBuilder();
        String day = "День " + Integer.toString(num) + ")", str;
        while ((str = br.readLine()) != null) {
            if (day.equals(str)) {
                br.readLine();
                br.readLine();
                while (!((str = br.readLine()).equals(""))) {
                    stringBuilder.append(str);
                    stringBuilder.append("\n");
                    data.incrementApproach();
                }
                data.setApproach(data.getApproach() / 2);
                if (str.equals(""))
                    break;
            }
        }
        br.close();
        return stringBuilder.toString();
    }

    public String getExerciseOfTrainingDay(int num) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
                "C:/Users/zayil/ideaProjects/Gym/resources/exercise/exercises.txt"), "cp1251"));
        StringBuilder stringBuilder = new StringBuilder();
        String day = "День " + Integer.toString(num) + ")", str;
        while ((str = br.readLine()) != null) {
            if (day.equals(str)) {
                stringBuilder.append(day);
                stringBuilder.append("\n");
                stringBuilder.append(br.readLine());
                break;
            }
        }
        br.close();
        return stringBuilder.toString();
    }

    public void setLogin(String login) throws IOException {
        FileWriter fw = new FileWriter("C:/Users/zayil/ideaProjects/Gym/resources/login/login.txt", true);
        fw.write(login + "\n");
        fw.flush();
        fw.close();
    }

    public boolean getCompareLogin(String login) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:/Users/zayil/ideaProjects/Gym/resources/login/login.txt")));
        String string;
        while ((string = br.readLine()) != null) {
            if (login.equals(string)) {
                br.close();
                return false;
            }
        }
        br.close();
        return true;
    }

    public String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
                "C:/Users/zayil/ideaProjects/Gym/resources/exercise/help.txt"), "cp1251"));
        String[] string = {"10/2; 10 - вес снаряда в кг\n2 - кол-во подходов\n",
                "(5 х 10) 5 - кол-во подходов\n10 - это кол-во повторений в одном подходе\n"};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string[0]);
        stringBuilder.append(string[1]);
        String str;
        while (!((str = br.readLine()).equals("Help"))) {
            stringBuilder.append(str);
            if (str.equals(""))
                stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }
}
