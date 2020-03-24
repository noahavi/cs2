// Stephanie Cardenas
// COP 3503, Fall 2019
// Extra testcases for SneakyQueens

import java.io.*;
import java.util.*;

public class TestCaseExtras
{
	private static void checkTest(boolean success)
	{
		System.out.println(success ? "Hooray!" : "fail whale :(");
	}

	public static void main(String [] args)
	{
		ArrayList<String> list = new ArrayList<String>();

		// If we have a boardSize of 1 and try to place 2 queens that can attack.
		list.clear();
		list.add("a1");
		list.add("b2");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 1) == false);

		// If we have a boardSize of 1 and only place one queen.
		list.clear();
		list.add("a1");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 1) == true);

		// If we have a boardSize of 2 and try to place 2 queens that can attack.
		list.clear();
		list.add("a2");
		list.add("b1");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 2) == false);

		// If we have a boardSize of 2 and try to place 1 queen.
		list.clear();
		list.add("a2");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 2) == true);

		// If we have a boardSize of 3 and try to place 2 queens that can't attack.
		list.clear();
		list.add("a1");
		list.add("c2");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 3) == true);

		// If we have a boardSize of 3 and try to place 2 queens that can attack.
		list.clear();
		list.add("a1");
		list.add("c1");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 3) == false);

		// If we have a boardSize of 3 and try to place a queen that can't fit on the board.
		list.clear();
		list.add("d1");
		list.add("a1");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 3) == false);

		// If we have a boardSize of 4 and try to place 1 queen.
		list.clear();
		list.add("a2");
		checkTest(SneakyQueens.allTheQueensAreSafe(list, 4) == true);
	}
}
