public class Dice {
    private int diceSize;

    Dice(int diceSize) {
        this.diceSize = diceSize * 6;
    }

    Dice() {
        this(6);
    }

    public int getDiceSize() {
        return diceSize;
    }

    public int rollDice() {
        return (int) (Math.random() * diceSize + 1);
    }
}
