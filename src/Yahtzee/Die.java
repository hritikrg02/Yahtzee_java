package Yahtzee;

/**
 * A single die object.
 * @author hritikgupta
 */
public class Die extends Yahtzee {

    private int rolledValue;

    public Die (int numDice, int sides) {
        super(numDice, sides);
        this.rolledValue = 1;
    }

    public void roll() {
        this.rolledValue = (int) (1 + (Math.random() * (super.sides)));
    }

    public int getRolledValue() {
        return this.rolledValue;
    }
}
