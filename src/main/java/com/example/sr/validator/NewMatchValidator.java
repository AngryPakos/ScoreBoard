package com.example.sr.validator;
import org.apache.commons.lang3.StringUtils;

import com.example.sr.exception.ValidationException;

public class NewMatchValidator {

	public static boolean validateNewMatchTeamNames(String homeTeam, String awayTeam) throws ValidationException {
		
		if (StringUtils.isEmpty(awayTeam)){
			throw new ValidationException("Away Team name is empty");
		}
		
		if (StringUtils.isEmpty(homeTeam)){
			throw new ValidationException("Home Team name is empty");
		}
		
		if (awayTeam.equals(homeTeam)){
			throw new ValidationException("Both names are equal");
		}
		
		return true;
	}

}
