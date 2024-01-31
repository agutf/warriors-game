package es.unileon.excelbach.warriors;

public class WarriorsTextUI {

    private WarriorsGame game;

    public WarriorsTextUI(WarriorsGame game) {
        this.game = game;
    }

    public void play() {
        System.out.println();
        System.out.println("¡¡Comienza la batalla!!\n\n");

        while(!game.hasWinner()) {
            System.out.println(this.game.toString());

            System.out.println("Turno del guerrero " + this.game.getShift());
            System.out.println();

            this.letPlayerPlay();
        }

        System.out.println("¡¡Tenemos un ganador!!");
        System.out.println();

        System.out.println(this.game.getWinner());

        System.out.println();
        System.out.println("Te esperamos para la siguiente batalla...");
        System.out.println("- - - - -");
    }

    private void letPlayerPlay() {
        System.out.println("¿Qué acción deseas realizar?");
        System.out.println("A - Attack | S - Add shield");
        System.out.println();

        char option = Keyboard.readChar();
        option = Character.toUpperCase(option);

        switch (option) {
            case 'A':
                this.game.attack();
                break;
            case 'S':
                this.game.addShield();
                break;
        }
    }
}
