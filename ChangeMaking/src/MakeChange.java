package csci232.prog4;

import java.util.*;

/********************************
 * Author: Joshua Stephenson-Losey, beau anderson, arash ajam
 * Date: 4/17/18
 * Overview: dynamic change making
 *********************************/
public class MakeChange {
    public static List makeChange(Integer[] coinSyst, int goal) {
        /*
            minCoin is an array where the index holds the min #coin to get that val
            coinSyst is the coin system
            goal is the amount we are making change for
            chan is the change required to make that amount
         */
        ArrayList<Integer> chan = new ArrayList<Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int[] minCoin = new int[goal+1];
        //initialize to max
        for (int i = 0; i < minCoin.length; i++) {
            minCoin[i] = i+1;
        }

        //if there is no system throw exception
        if (coinSyst.length == 0) {
            throw new IllegalArgumentException("Array of size 0 is not allowed");
        }

        //sort descending (largest at beginning)
        //Arrays.sort(coinSyst, Collections.reverseOrder());

        //for each number 0-goal
        //were looking for the min number of coins it takes to get said number
        for (int num = 0; num < goal+1; num++) {
            //number of coins is set to num to assume that worst case is all pennies
            int count = num;
            //new coin is set to 1 again to follow that assumption
            int newCoin = 1;
            //for each previous entry in the array
            for (int value = 0; value < num+1; value++) {
                //for each coin in the system
                for (int coin : coinSyst) {
                    //if the coin is smaller than our current number
                    if (coin <= num) {
                        //we check to see if the minimum of all the previous values..
                        //plus one valid coin..
                        //is lower than the minimum of the last value plus one penny
                        if (minCoin[num - coin] + 1 < count) {
                            count = minCoin[num - coin] + 1;
                            //set the coin to the largest one used
                            newCoin = coin;
                        }
                    }
                }
            }
            //add the min number of coins to the array
            minCoin[num] = count;
            //and the coin used to get that minimum to the coin array
            chan.add(num, newCoin);
        }

        //set the actual answer to a list
        while (goal>0){
            //by finding the least amount of
            //coins needed using our two arrays
            int curCoin = chan.get(goal);
            answer.add(curCoin);
            //and subtracting the coin used
            //from the total change required
            goal = goal - curCoin;
        }

        //sort largest first
        answer.sort(Comparator.reverseOrder());

        return answer;
    }
}
