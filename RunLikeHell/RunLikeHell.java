// Noah Avizemer
// COP 3503, Fall 2019
// no886776

import java.util.*;
import java.io.*;

public class RunLikeHell{

  public static int maxGain(int [] blocks)
  {
    int blockLength = blocks.length;
    int [] maxK = new int[blockLength];

    // initialize base cases in array
    // greatest value at 2nd block based on which is greater
    maxK[0] = blocks[0];
    maxK[1] = Math.max(blocks[0], blocks[1]);

    // loops through all the blocks
    for (int i = 2; i < blockLength; i++)
    {
      // new max is max from i - 2 plus new block or prev max
      // checks if new max is greater or old max
      maxK[i] = Math.max(maxK[i - 2] + blocks[i], maxK[i - 1]);
    }

    return maxK[blockLength - 1];
  }

  public static double difficultyRating()
  {
    return 2.5;
  }
  public static double hoursSpent()
  {
    return 2.5;
  }
}