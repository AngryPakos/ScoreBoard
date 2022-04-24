package com.example.sr.model;

import java.util.ArrayList;
import java.util.List;

import com.example.sr.exception.ActiveMatchException;
import com.example.sr.validator.NewMatchValidator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
//This class is not really a model ... 
public class ScoreBoard {
	
	private Match activeMatch;
	private List<Match> matchHistory;
	
	public ScoreBoard() {
		matchHistory = new ArrayList<>();
	}
	
	
	public Match startNewMatch(String homeTeamName, String awayTeamName) throws ActiveMatchException {
	
		if (activeMatch == null) {			
			NewMatchValidator.validateNewMatchTeamNames(homeTeamName, awayTeamName);
			activeMatch = new Match(homeTeamName, awayTeamName);
			return activeMatch;
		} else {
			throw new ActiveMatchException("Active match already exists");
		}

	}
	
	public void endMatch() throws ActiveMatchException {
		if (activeMatch == null) {
			throw new ActiveMatchException("Active match doesn't exists");
		}
		matchHistory.add(activeMatch);
		activeMatch = null;
		
	}
	
	
	
}
