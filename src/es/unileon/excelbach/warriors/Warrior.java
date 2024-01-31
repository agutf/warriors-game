package es.unileon.excelbach.warriors;

public class Warrior {

    private String name;
    private int health;
    private int shield;

    public Warrior(String name, int health) throws WarriorsGameException {
        if(health < 5 || health > 20) {
            throw new WarriorsGameException("Minimum health for warriors is 5.");
        }
        else if(name.length() < 5) {
            throw new WarriorsGameException("The warrior's name must be at least 5 letters long.");
        }

        this.name = name;
        this.health = health;
        this.shield = 0; 
    }

    public void receiveAttack(int power) {
        if(this.shield >= power) {
            this.shield = this.shield - power;
            power = 0;
        }
        else if(this.shield > 0) {
            power = power - this.shield;
            this.shield = 0;
        }

        this.health = this.health - power;

        if(this.health < 0) {
            this.health = 0;
        }
    }

    public void addShield(int shield) {
        this.shield = this.shield + shield;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDefeated() {
        return this.health == 0;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(this.name);
        result.append("\n");
        
        for(int i=0; i<this.health; i++) {
            result.append('*');
        }

        result.append("\n");

        for(int i=0; i<this.shield; i++) {
            result.append('+');
        }

        return result.toString();
    }
}
