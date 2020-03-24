// Noah Avizemer
// no886776
// Cop 3503, Fall 2019

import java.util.*;


public class SneakyQueens
{
	public static boolean allTheQueensAreSafe(ArrayList<String> coordinateStrings, int boardSize)
	{
		int[] ccoords = coordConvert(coordinateStrings, 26);
		int[] rcoords = coordHelp(coordinateStrings);

		// if both true, then  queens safe
		if (checkRc(ccoords, rcoords, boardSize) && checkDia(ccoords, rcoords, boardSize))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public static boolean checkRc(int[] coords1, int[] coords2, int boardSize)
	{
		int[] board1 = new int[boardSize * 2 + 1];
		int[] board2 = new int[boardSize * 2 + 1];

		for (int i = 0; i < coords1.length; i++)
		{
			// sets flag
			if (board1[coords1[i]] != 1)
			{
				board1[coords1[i]] = 1;
			}
			// if flagged, then not safe
			else if (board1[coords1[i]] == 1)
			{
				return false;
			}
			if (board2[coords2[i]] != 1)
			{
				board2[coords2[i]] = 1;
			}
			else if (board2[coords2[i]] == 1)
			{
				return false;
			}
		}
		return true;
	}

	public static boolean checkDia(int[] coords1, int[] coords2, int boardSize)
	{
		int[] dia1 = new int[boardSize * 2 + 1];
		int[] dia2 = new int[boardSize * 2 + 1];

		// if the position is not flagged, then it gets flagged
		// if it is flagged then not safe
		for(int i = 0; i < coords1.length; i++)
		{
			int k = coords2[i] - coords1[i] + boardSize;
			int j = coords2[i] + coords1[i]; 

			if (dia1[k] != 1)
			{
				dia1[k] = 1;
			}
			else if (dia1[k] == 1)
			{
				return false;
			}
			if (dia2[j] != 1)
			{
				dia2[j] = 1;
			}
			else if (dia2[j] == 1)
			{
				return false;
			}
		}
		return true;
	}

	// converts the column str to integer
	public static int[] coordConvert(ArrayList<String> coords, int k)
	{
		int [] cols = new int[coords.size()];
		int j = 0;
		for (String s : coords)
		{
			int retval = 0;
			// converts only chars
			for (int i = 0; i < s.length(); i++)
			{
				if (Character.isLetter(s.charAt(i))) 
				{
					char c = s.charAt(i);
					int val = (int)c - 96; // converts 1-26

					retval = val + (retval * 26);
				}
				else
				{
					// stops after letters needed to convert
					break;
				}
			}
			cols[j++] = retval;
		}
		return cols;
	}

	public static int[] coordHelp(ArrayList<String> coords)
	{
		int [] rows = new int[coords.size()];
		int j = 0;
		// gets the row value
		for (String s : coords)
		{
			for (int i = 0; i < s.length(); i++)
			{
				if (Character.isDigit(s.charAt(i)))
				{
					// splits the digits from the chars, adds the digits to array
					String splitCoords = s.substring(i);
					rows[j] = Integer.parseInt(s.substring(i));
					break;
				}
			}
			j++;
		}
		return rows;
	}


	public static double difficultyRating()
	{
		return 5;
	}

	public static double hoursSpent()
	{
		return 8;
	}
}