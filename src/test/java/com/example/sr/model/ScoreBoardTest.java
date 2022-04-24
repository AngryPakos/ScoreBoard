package com.example.sr.model;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.sr.exception.ActiveMatchException;
import com.example.sr.exception.ValidationException;

public class ScoreBoardTest {

	ScoreBoard board;
	
	@Before
	public void init() {
		board = new ScoreBoard();
	}
	
	@Test
	public void startNewMatchTest() {
		board.startNewMatch("a", "b");
		assertTrue(board.getActiveMatch().getAwayScore() == 0);
		assertTrue(board.getActiveMatch().getHomeScore() == 0);
		
	}
	
	@Test(expected = ActiveMatchException.class)
	public void multipleActiveMatchesTest() {
		board.startNewMatch("a", "b");
		board.startNewMatch("b", "c");
	}
	
	@Test(expected = ValidationException.class)
	public void emptyHomeTeamNameTest() {
		board.startNewMatch("", "b");
	}

	@Test(expected = ValidationException.class)
	public void emptyAwayTeamNameTest() {
		board.startNewMatch("", "b");
	}

	@Test(expected = ValidationException.class)
	public void equalTeamNamesTest() {
		board.startNewMatch("", "b");
	}
	
	@Test(expected = ActiveMatchException.class)
	public void endNonExistingMatchTest() {
		board.endMatch();
	}
	
	@Test()
	public void endMatchTest() {
		var match = board.startNewMatch("a", "b");
		board.endMatch();
		assertTrue(board.getActiveMatch() == null);
		assertTrue(board.getMatchHistory().get(0).equals(match));
	}
}
