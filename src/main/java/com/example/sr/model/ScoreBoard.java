package com.example.sr.model;

import com.example.sr.exception.ActiveMatchAlreadyExists;
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
	

	public Match startNewMatch(String homeTeamName, String awayTeamName) throws ActiveMatchAlreadyExists {
	
		if (activeMatch == null) {			
			NewMatchValidator.validateNewMatchTeamNames(homeTeamName, awayTeamName);
			activeMatch = new Match(homeTeamName, awayTeamName);
			return activeMatch;
		} else {
			throw new ActiveMatchAlreadyExists();
		}

	}
	
	
	
	
}
