package boardScreen;

public class steps {
    private static int aux;
    private static boolean justone;

    public static void stepCalculator(Player player, int steps, int direction){
        justone = true;
        if(player.getPath() == "mainPath"){
            if(player.getPosition() + steps > axes.pathSize("mainPath") ){
                player.setPosition(player.getPosition() + steps - 50);
                player.movePlayer(XYAxes.mainXY.get(player.getPosition()));
                justone = false;

            }

        }

        if(direction == 0 & player.getPosition() + steps < axes.pathSize(player.getPath()) & justone){
            player.setPosition(player.getPosition()+steps);
            System.out.println(player.getPosition());
            player.movePlayer(XYAxes.mainXY.get(player.getPosition()));
        }

        DirectionButtons.defaultColor();
    }
}
