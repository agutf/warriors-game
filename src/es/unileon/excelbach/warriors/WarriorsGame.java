package es.unileon.excelbach.warriors;

import java.util.Random;

public class WarriorsGame {

    private final int MAX_POWER = 10;

    private Warrior warrior1;
    private Warrior warrior2;

    private int shift;

    private Random random;

    public WarriorsGame(String firstWarriorName, int firstWarriorHealth, String secondWarriorName, int secondWarriorHealth) throws WarriorsGameException {
        warrior1 = new Warrior(firstWarriorName, firstWarriorHealth);
        warrior2 = new Warrior(secondWarriorName, secondWarriorHealth);

        this.shift = 0;

        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    public String getShift() {
        if(this.shift % 2 == 0) {
            return this.warrior1.getName();
        }

        return this.warrior2.getName();
    }

    public void attack() {
        Warrior defendingWarrior;

        if(this.shift % 2 == 0) {
            defendingWarrior = warrior2;
        }
        else {
            defendingWarrior = warrior1;
        }

        int power = random.nextInt(this.MAX_POWER) + 1;

        defendingWarrior.receiveAttack(power);

        this.shift++;
    }

    public void addShield() {
        Warrior attackingWarrior;

        if(this.shift % 2 == 0) {
            attackingWarrior = warrior1;
        }
        else {
            attackingWarrior = warrior2;
        }

        int shield = random.nextInt(this.MAX_POWER / 4) + 1;

        attackingWarrior.addShield(shield);

        this.shift++;
    }

    public boolean hasWinner() {
        return this.warrior1.isDefeated() || this.warrior2.isDefeated();
    }

    public String getWinner() {
        StringBuilder result = new StringBuilder();

        if(this.hasWinner()) {
            result.append(this.warrior1.isDefeated() ? this.warrior2.toString() : this.warrior1.toString());
        }

        return result.toString();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(this.warrior1.toString());
        result.append("\n");
        result.append(this.warrior2.toString());
        result.append("\n");

        return result.toString();
    }
}
