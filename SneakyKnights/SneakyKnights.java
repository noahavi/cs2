// Noah Avizemer
// no886776
// COP 3503, Fall 2019

import java.util.*;
import java.awt.*;

public class SneakyKnights
{

	public static boolean allTheKnightsAreSafe(ArrayList<String> coordinateStrings, int boardsize)
	{
		// puts coords in arrays
		int[] ccoords = coordConvert(coordinateStrings, 26);
		int[] rcoords = coordHelp(coordinateStrings);

		// checks if knights are safe
		if (checkKnights(ccoords, rcoords, coordinateStrings))
		{
			return true;
		}
		else
		{
			return false;
		}

		
	}

	public static boolean checkKnights(int [] ccoords, int [] rcoords, ArrayList<String> coordinateStrings)
	{
		// creates a hashset to put coords of knights in
		HashSet<Point> coords = new HashSet<Point>(coordinateStrings.size());

		// for each set of coords, check if any possible moves are occupied
		// if so, returns false since the knight can be attacked
		for (int i = 0; i < ccoords.length; i++)
		{
			Point knight = new Point(ccoords[i], rcoords[i]);
			coords.add(knight);

			Point p = new Point(ccoords[i] + 1, rcoords[i] - 2);

			if (coords.contains(p))
			{
				return false;
			}

			p = new Point(ccoords[i] + 1, rcoords[i] + 2);

			if (coords.contains(p))
			{
				return false;
			}

			p = new Point(ccoords[i] - 1, rcoords[i] - 2);

			if (coords.contains(p))
			{
				return false;
			}

			p = new Point(ccoords[i] - 1, rcoords[i] + 2);

			if (coords.contains(p))
			{
				return false;
			}

			p = new Point(ccoords[i] - 2, rcoords[i] + 1);

			if (coords.contains(p))
			{
				return false;
			}

			p = new Point(ccoords[i] - 2, rcoords[i] - 1);

			if (coords.contains(p))
			{
				return false;
			}

			p = new Point(ccoords[i] + 2, rcoords[i] + 1);

			if (coords.contains(p))
			{
				return false;
			}

			p = new Point(ccoords[i] + 2, rcoords[i] - 1);

			if (coords.contains(p))
			{
				return false;
			}

		}

		// knights are safe so return true

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
		return 4;
	}

	public static double hoursSpent()
	{
		return 7;
	}
}