import java.util.List;
import java.util.Scanner;
import java.lang.System;

public class Test {
    public static int count = 0;
    public static String course = null;
    public static void EndofGame() {
        Scanner key = new Scanner(System.in);
        System.out.println("******************************");
        System.out.println("Keep playing? y or n:");
        System.out.println("******************************");
        String bool = key.next();
        if (bool.equals("y") || bool.equals("Y")) {
            count = 0;
            main(null);
        }
        else if (bool.equals("n") || bool.equals("N")) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid input");
            EndofGame();
        }

    }


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Choose game option:");
        System.out.println("[1] 50 man tournament");
        System.out.println("[2] Tournament with added players");
        System.out.println("[3] 50 man season");
        System.out.println("[4] Season with added players");
        System.out.println("[5] Quit");
        int game = keyboard.nextInt();

        if (game == 1) {
            System.out.println("Input course:");
            String course = keyboard.next();
            String[] ins = new String[2];
            ins[0] = "0";
            ins[1] = course;
            GolfGame.main(ins);
            System.out.println("----------------------------------");
            EndofGame();
        }
        if (game == 2) {
            System.out.println("Input number of added players");
            String players = keyboard.next();
            System.out.println("Input course:");
            String course = keyboard.next();
            String[] ins = new String[2];
            ins[0] = players;
            ins[1] = course;
            GolfGame.main(ins);
            System.out.println("----------------------------------");
            EndofGame();
        }
        if (game == 3) {
            System.out.println("How many tournaments in season:");
            int games = keyboard.nextInt();
            System.out.println("Which courses to play(comma no space):");
            String courses = keyboard.next();
            String[] courseList = courses.split(",");
            System.out.println(courseList[0]);
            System.out.println(courseList[1]);
            String[] ins = new String[2];
            ins[0] = "0";

            for (int i = 0; i < games; i++) {
                ins[1] = courseList[i];
                course = courseList[i];
                List list = GolfGame.main(ins);
                System.out.println("----------------End of Tournament----------------\n");
                Points.main(list);
                count++;
                //String first = (String) list.get(i);
                //do this for everyone receiving points?
               // System.out.println("Points awarded- ");
               // System.out.println("1st - " + first.substring(0, 13) + " 25 pts");
                //need print, but to add together like in GolfGame, make new list of players and points
                //then add like GolfGame
            }

            EndofGame();
        }
        if (game == 4) {
            System.out.print("How many tournaments in season:");
            int games = keyboard.nextInt();
            System.out.println("Input number of added players:");
            String players = keyboard.next();
            System.out.print("Which courses to play(comma no space):");
            String courses = keyboard.next();
            String[] courseList = courses.split(",");
            String[] ins = new String[2];
            ins[0] = players;

            for (int i = 0; i < games; i++) {
                ins[1] = courseList[i];
                course = courseList[i];
                List list = GolfGame.main(ins);
                System.out.println("----------------End of Tournament----------------\n");
                Points.main(list);
                count++;
            }
            EndofGame();
        }
        if (game == 5) {
            System.out.println("Quitting...");
            System.exit(0);
        }
    }
}
