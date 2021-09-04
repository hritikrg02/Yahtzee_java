package Yahtzee;

import java.util.*;

/**
 * A die roller that allows a user to pick the number of sides per die,
 * and roll however many dice they wish. Re-rolls continue until all
 * dice land on the same face.
 * @author Hritik "Ricky" Gupta
 */
public class Yahtzee {

    protected int numDice;
    protected int sides;

    public Yahtzee(int numDice, int sides) {
        this.numDice = numDice;
        this.sides = sides;
    }

    public List<Integer> rollDice() {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < this.numDice; i++) {
            Die die = new Die(this.numDice, this.sides);
            die.roll();
            rolls.add(die.getRolledValue());
        }
        return rolls;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> yahtzeeRoll = new ArrayList<>();
        // HashMap<Integer, Integer> freqList = new HashMap<>();
        int totalRolls = 0;
        int numDice;
        int sides;
        // boolean boolFreqList = false;

        if (args.length == 2) {
            numDice = Integer.parseInt(args[0]);
            sides = Integer.parseInt(args[1]);
            /*if (args[2].equals("y")) {
                boolFreqList = true;
                for (int i = 1; i <= sides; i++) {
                    freqList.put(i, 0);
                }
            }*/
        } else {
            System.out.print("How many dice? ");
            numDice = in.nextInt();

            System.out.print("How many sides per die? ");
            sides = in.nextInt();

            /*System.out.print("Would you like a frequency table? ");
            if (in.nextLine().equals("y")) {
                boolFreqList = true;
                for (int i = 1; i <= sides; i++) {
                    freqList.put(i, 0);
                }
            }*/

            System.out.println();
        }


        long startTime = System.nanoTime();

        while (true) {
            List<Integer> diceRoll = new Yahtzee(numDice, sides).rollDice();

            /*if (boolFreqList) {
                for (int roll : diceRoll) {
                    freqList.put(roll, freqList.get(roll) + 1);
                }
            }*/

            if (diceRoll.stream()
                    .distinct()
                    .count() == 1
            ) {
                yahtzeeRoll.addAll(diceRoll);
                break;
            }
            totalRolls += 1;
        }

        long endTime = System.nanoTime();
        double totalTime = (endTime - startTime) * .000001;

        System.out.println("Yahtzee.Yahtzee rolled: " + yahtzeeRoll);
        System.out.println("Total number of rolls: " + totalRolls + "\n");

        /*if (boolFreqList) {
            System.out.println("Frequency Table: ");
            for (Integer side : freqList.keySet()) {
                System.out.println(side + ": " + freqList.get(side));
            }
        }*/

        System.out.println("Time taken: " + totalTime + " ms");

    }
}
