import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.sr.exception.ActiveMatchAlreadyExists;
import com.example.sr.exception.ValidationError;
import com.example.sr.model.ScoreBoard;

import lombok.var;

public class ScoreBoardTest {

	@Test
	public void startNewMatchTest() {
		var board = new ScoreBoard();
		board.startNewMatch("a", "b");
		assertTrue(board.getActiveMatch().getAwayScore() == 0);
		assertTrue(board.getActiveMatch().getHomeScore() == 0);
		
	}
	
	@Test(expected = ActiveMatchAlreadyExists.class)
	public void multipleActiveMatchesTest() {
		var board = new ScoreBoard();
		board.startNewMatch("a", "b");
		board.startNewMatch("b", "c");
	}
	
	@Test(expected = ValidationError.class)
	public void emptyHomeTeamNameTest() {
		var board = new ScoreBoard();
		board.startNewMatch("", "b");
	}

	@Test(expected = ValidationError.class)
	public void emptyAwayTeamNameTest() {
		var board = new ScoreBoard();
		board.startNewMatch("", "b");
	}

	@Test(expected = ValidationError.class)
	public void equalTeamNamesTest() {
		var board = new ScoreBoard();
		board.startNewMatch("", "b");
	}


}
