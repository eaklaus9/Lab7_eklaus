package com.cs60333.eaklaus.lab1_eklaus;

import java.io.Serializable;

/**
 * Created by eakla on 3/1/2017.
 */

public class Team implements Serializable {
    String teamname;
    String teamlogo;
    String gamedate;
    String detailtime;
    String detaillocation;
    String awaymascot;
    String awayrecord;
    String gamescore;
    String timeleft;

    public Team(String team_logo, String team_name, String game_date, String detail_time,
                String detail_location, String away_mascot, String away_record, String game_score, String time_left) {
        setTeamName(team_name); getTeamName();
        setTeamLogo(team_logo); getTeamLogo();
        setGameDate(game_date); getGameDate();
        setDetailTime(detail_time); getDetailTime();
        setDetailLocation(detail_location); getDetailLocation();
        setAwayMascot(away_mascot); getAwayMascot();
        setAwayRecord(away_record); getAwayRecord();
        setGameScore(game_score); getGameScore();
        setTimeLeft(time_left); getTimeLeft();

    }

    public void setTeamName(String team_name) {
        this.teamname = team_name;
    }
    public String getTeamName() {
        return this.teamname;
    }

    public void setTeamLogo(String team_logo) {
        this.teamlogo = team_logo;
    }
    public String getTeamLogo() {
        return this.teamlogo;
    }

    public void setGameDate(String game_date) {
        this.gamedate = game_date;
    }
    public String getGameDate() {
        return this.gamedate;
    }

    public void setDetailLocation(String detail_location) {
        this.detaillocation = detail_location;
    }
    public String getDetailLocation() {
        return this.detaillocation;
    }

    public void setDetailTime(String detail_time) {
        this.detailtime = detail_time;
    }
    public String getDetailTime() {
        return this.detailtime;
    }

    public void setAwayMascot(String away_mascot) {
        this.awaymascot = away_mascot;
    }
    public String getAwayMascot() {
        return this.awaymascot;
    }

    public void setAwayRecord(String away_record) {
        this.awayrecord = away_record;
    }
    public String getAwayRecord() {
        return this.awayrecord;
    }

    public void setGameScore(String game_score) {
        this.gamescore=game_score;
    }
    public String getGameScore() {return this.gamescore;}

    public void setTimeLeft(String time_left) {
        this.timeleft = time_left;
    }
    public String getTimeLeft() {return this.timeleft;
    }
}