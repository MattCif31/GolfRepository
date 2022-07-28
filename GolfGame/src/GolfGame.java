import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;





//Multiple runs to make season (1 run is 1 tournament)-
    //add points system to winners based on tournament place
    //degree of difficulty for different tournaments- in golfgame- course selections
    //multiple tournament runs determine season


public class GolfGame {
    public static int numpl;
    public static String[] names = new String[50+numpl];
    public static int[] scores = new int[50+numpl];
    public static int count = 1;
    public static String[] ps = new String[numpl];
    public static String dets = null;
    public static String nam = null;
    public static String[] details = new String[12];
    public static LinkedHashMap<String, Integer> total = new LinkedHashMap<String, Integer>();

    static List<Entry<String, Integer>> FINAL;

    public static List<Entry<String, Integer>> getFINAL() {
        return FINAL;
    }

    public static void setFINAL(List<Entry<String, Integer>> FINAL) {
        GolfGame.FINAL = FINAL;
    }

    public static String[] getNames() {
        return names;
    }

    public static void setNames(String[] names) {
        GolfGame.names = names;
    }

    public static int[] getScores() {
        return scores;
    }

    public static void setScores(int[] scores) {
        GolfGame.scores = scores;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        GolfGame.count = count;
    }

    public static List Rounds(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        if (count == 1) {
            int game = Test.count+1;
            System.out.println("\n\n-----------------------------------------");
            System.out.println("Tournament " + game);
            System.out.println("-----------------------------------------");
            System.out.println("Enter wind and rough (0 or 1)(seperated by space):");
            dets = keyboard.nextLine();
            details = dets.split(" ");
        }
        int userSeed;
        int x;
        int Score = 0;
        int j = 0;

        names[0] = "J. Spieth     ";
        names[1] = "S. Scheffler  ";
        names[2] = "S. Burns      ";
        names[3] = "J. Thomas     ";
        names[4] = "R. McIlroy    ";
        names[5] = "C. Smith      ";
        names[6] = "P. Cantlay    ";
        names[7] = "H. Matsuyama  ";
        names[8] = "M. Homa       ";
        names[9] = "J. Rahm       ";
        names[10] = "B. Horschel   ";
        names[11] = "T. Hoge       ";
        names[12] = "W. Zalitoris  ";
        names[13] = "T. Gooch      ";
        names[14] = "C. Young      ";
        names[15] = "V. Hovland    ";
        names[16] = "X. Schauffele ";
        names[17] = "C. Morikawa   ";
        names[18] = "D. Riley      ";
        names[19] = "S. Straka     ";
        names[20] = "D. Johnson    ";
        names[21] = "B. Koepka     ";
        names[22] = "A. Scott      ";
        names[23] = "J. Rose       ";
        names[24] = "G. Woodland   ";
        names[25] = "P. Reed       ";
        names[26] = "D. Berger     ";
        names[27] = "M. Wolf       ";
        names[28] = "T. Fleetwood  ";
        names[29] = "A. Hadwin     ";
        names[30] = "M. Fitzpatrick";
        names[31] = "C. Conners    ";
        names[32] = "A. Wise       ";
        names[33] = "S. Lowry      ";
        names[34] = "R. Henley     ";
        names[35] = "K. Kisner     ";
        names[36] = "T. Finau      ";
        names[37] = "K. Bradley    ";
        names[38] = "M. Hughes     ";
        names[39] = "M. Kuchar     ";
        names[40] = "B. Harman     ";
        names[41] = "A. Ancer      ";
        names[42] = "N. Lashley    ";
        names[43] = "J. Day        ";
        names[44] = "R. Fowler     ";
        names[45] = "B. Watson     ";
        names[46] = "S. Garcia     ";
        names[47] = "W. Simpson    ";
        names[48] = "B. Snedeker   ";
        names[49] = "A. Cook       ";
        if (count == 1 & numpl > 0) {
            System.out.println("player's names (space in between):");
            nam = keyboard.nextLine();
            ps = nam.split(" ");

        }

        for (int i = 0; i < numpl; i++) {
            names[50 + i] = String.format("%-14s", ps[i]);
        }



        int Wind = Integer.parseInt(details[0]);


        int rough = Integer.parseInt(details[1]);


        System.out.println("\nEnter a 6 digit seed: ");
        userSeed = keyboard.nextInt();

        Random rnd = new Random(userSeed);

        String tourney = args[1];

        int birdie = 0;
        int parmin;
        int parmax;
        if (tourney.equals("US Open")) {
            birdie = 10;
            parmin = 11;
            parmax = 88;
        } else if (tourney.equals("PGA Championship")) {
            birdie = 8;
            parmin = 9;
            parmax = 86;
        } else if (tourney.equals("Masters")) {
            birdie = 12;
            parmin = 13;
            parmax = 90;
        }
        else if (tourney.equals("Extreme")) {
            birdie = 32;
            parmin = 33;
            parmax = 67;
        }else {
            birdie = 10;
            parmin = 11;
            parmax = 88;
        }



        int i = 1;
        int max = 901;
        while (i < (max)) {
            x = rnd.nextInt(100);

            if ((x <= birdie)) {
                Score = Score - 1;
            } else if (x >= parmin && x <= parmax) {
                continue;
            } else {
                Score = Score + 1;
            }
            if (i % 18 == 0) {
                scores[j] = Score;
                j++;
                Score = 0;
            }
            i = i + 1;
        }
        for (int k = 0; k < 50; k++) {
            if (Wind < 10) {
                scores[k] = scores[k];
            } else if (Wind < 20) {
                scores[k]++;
            } else {
                scores[k] = scores[k] + 3;
            }

            if (rough == 1) {
                scores[k] = scores[k] + 2;
            }
        }

        LinkedHashMap<String, Integer> d = new LinkedHashMap<>();


        for (i = 0; i < 50; i++) {
            d.put(GolfGame.names[i], scores[i]);

        }

        for (i = 0; i < numpl; i++) {
            String shortname = ps[i];
            System.out.println(shortname + "'s score:");
            int temp = keyboard.nextInt();
            String pname = names[50+i];
            d.put(pname, temp);

        }

        if (count == 1) {
            total = d;
        }

        else {
            for (i = 0; i < 50+numpl; i++) {
                if (total.containsKey(names[i])) {
                    String n = String.format("%-14s", names[i]);

                    total.replace(names[i], total.get(names[i]) + d.get(n));
                }
            }
        }
        List<Entry<String, Integer>> fin = sortMap(total);

        System.out.print("Scores after round " + count + ":\n");
        for (Entry<String, Integer> entry : fin) {
            String[] sv = String.valueOf(entry).split("=");
            System.out.println(entry.getKey() + " | " + sv[1]);
        }

        count += 1;

        return fin;
    }

    public static List sortMap(LinkedHashMap map) {
        List<Entry<String, Integer>> capitalList = new LinkedList<>(map.entrySet());
        Collections.sort(capitalList, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));

        return capitalList;
    }



    public static List main(String[] args) {

        List[] arr = new List[5];
        for (int i = 0; i < 4; i++) {
            numpl = Integer.parseInt(args[0]);
            names = new String[50+numpl];
            scores = new int[50 + numpl];
            arr[i] = Rounds(args);

        }

        count = 1;
        return arr[3];
    }
}


