package com.example.sr.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Match {

	private String homeTeam;

	private String awayTeam;
	private int homeScore;
	private int awayScore;

	public Match(String homeTeam, String awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = 0;
		this.awayScore = 0;
	}

	/**
	 * updates score for both teams
	 * 
	 * @return {@code true} if the update was successful
	 */
	public boolean bothScore(int homeChange, int awayChange) {
		if (homeChange != 0 && awayChange != 0) {
			return homeScores(homeChange) && awayScores(awayChange);
		}
		return false;
	}

	public boolean homeScores(int change) {
		if (change != 0) {
			homeScore += change;
			return true;
		}
		return false;
	}

	public boolean awayScores(int change) {
		if (change != 0) {
			awayScore += change;
			return true;
		}
		return false;
		
	}
}
