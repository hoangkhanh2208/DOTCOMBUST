import java.util.ArrayList;

public class SinkAShip {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> shipList = new ArrayList<Ship>();
    private int numOfShots = 0;

    private void setUpGame() {
        Ship one = new Ship();
        one.setName("Tàu 1");
        Ship two = new Ship();
        one.setName("Tàu 2");
        Ship three = new Ship();
        one.setName("Tàu 3");

        shipList.add(one);
        shipList.add(two);
        shipList.add(three);

        System.out.println("Your goal is to sink three ships");

        for (Ship shipSet : shipList) {
            ArrayList<String> newLocation = helper.placeShip(3);
            shipSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!shipList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfShots++;
        String result = "miss";

        for (Ship shipToTest : shipList) {
            result = shipToTest.check(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                shipList.remove(shipToTest);
                break;
            }
        }
        System.out.println(result);
    }
    
    private void finishGame() {
        System.out.println("All the ships are sunk!");
        if (numOfShots <= 18) {
            System.out.println("It only took you " + numOfShots + " guesses");
        } else {
            System.out.println("Took you long enough. " + numOfShots + " guesses.");
        }
    }

    public static void main(String[] args) {
        SinkAShip game = new SinkAShip();
        game.setUpGame();
        game.startPlaying();
    }

}
