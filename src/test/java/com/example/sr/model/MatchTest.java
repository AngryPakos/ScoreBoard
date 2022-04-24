package com.example.sr.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MatchTest {

	Match match;

	@Before
	public void init() {
		match = new Match("a", "b");
	}

	@Test
	public void homeTeamScoreTest() {
		assertFalse(match.homeScores(0));
		assertTrue(match.homeScores(3));
		match.homeScores(7);
		assertTrue(match.getHomeScore() == 10);
	}

	@Test
	public void awayTeamScoreTest() {
		assertFalse(match.awayScores(0));
		assertTrue(match.awayScores(3));
		match.awayScores(7);
		assertTrue(match.getAwayScore() == 10);
	}

	@Test
	public void bothTeamsScoreTest() {
		assertFalse(match.bothScore(0, 6));
		assertFalse(match.bothScore(2, 0));
		assertTrue(match.bothScore(3, 6));
		match.bothScore(4, -2);
		
		assertTrue(match.getAwayScore() == 4);
		assertTrue(match.getHomeScore() == 7);
	}

}
