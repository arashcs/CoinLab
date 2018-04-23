/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program4_minimumcoins;

/**
 *
 * @author beau
 * @Github: https://github.com/Xzylon/CoinLab/tree/Xzylon-patch-1
 */
public class minCoin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public int numCoins(int originalAmount, int[] coinList) {
        int numCoins= Integer.MAX_VALUE;
        if (originalAmount >= 0) { //checks to make sure we don't go negative
            for (int i = 0; i < coinList.length; i++) { //parses through the coins individually
                numCoins = numCoins + 1;
            }
        }
        return numCoins;
    }

}
