package es.unileon.excelbach.warriors;

public class MainWarriors {
    public static void main(String[] args) {
        WarriorsTextUI ui = null;
        WarriorsGame game = null;

        if (args.length != 4) {
            System.out.println(
                    "La forma correcta de ejecutar el juego es MainWarriors nombreGuerrero1 vidaGuerrero1 nombreGuerrero2 vidaGuerrero2");
        } else {
            try {
                String nameWarrior1 = args[0];
                int healthWarrior1 = Integer.parseInt(args[1]);
                String nameWarrior2 = args[2];
                int healthWarrior2 = Integer.parseInt(args[3]);

                game = new WarriorsGame(nameWarrior1, healthWarrior1, nameWarrior2, healthWarrior2);

                ui = new WarriorsTextUI(game);
                ui.play();
            } catch (NumberFormatException e) {
                System.out.println(
                        "La forma correcta de ejecutar el juego es MainWarriors nombreGuerrero1 vidaGuerrero1 nombreGuerrero2 vidaGuerrero2");
            } catch (WarriorsGameException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}