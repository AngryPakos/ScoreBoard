package com.example.sr.validator;
import org.apache.commons.lang3.StringUtils;

import com.example.sr.exception.ValidationError;

public class NewMatchValidator {

	public static boolean validateNewMatchTeamNames(String homeTeam, String awayTeam) throws ValidationError {
		
		if (StringUtils.isEmpty(awayTeam)){
			throw new ValidationError("Away Team name is empty");
		}
		
		if (StringUtils.isEmpty(homeTeam)){
			throw new ValidationError("Home Team name is empty");
		}
		
		if (awayTeam.equals(homeTeam)){
			throw new ValidationError("Both names are equal");
		}
		
		return true;
	}

}
