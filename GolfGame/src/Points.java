import java.util.*;

public class Points {
    public static LinkedHashMap<String, Integer> total = new LinkedHashMap<String, Integer>();
    public static int[] ps = new int[15];

    public static void point(List list) {
        LinkedHashMap<String, Integer> d = new LinkedHashMap<String, Integer>();
        LinkedHashSet<String> scores = new LinkedHashSet<String>();
        String[] names = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String sc = String.valueOf(list.get(i));
            sc = sc.substring(15);
            scores.add(sc);
        }
        String[] finScore = new String[scores.size()];
        scores.toArray(finScore);

        for (int i = 0; i < list.size(); i++) {
            String temp = String.valueOf(list.get(i));
            names[i] = temp.substring(0, 13);

                //System.out.println(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            String sc = String.valueOf(list.get(i));
            sc = sc.substring(15);
            if (sc.equals(finScore[0])) {
                    d.put(names[i], ps[0]);
            }
            else if (sc.equals(finScore[1])) {
                d.put(names[i], ps[1]);
            }
            else if (sc.equals(finScore[2])) {
                d.put(names[i], ps[2]);
            }
            else if (sc.equals(finScore[3])) {
                d.put(names[i], ps[3]);
            }
            else if (sc.equals(finScore[4])) {
                d.put(names[i], ps[4]);
            }
            else if (sc.equals(finScore[5])) {
                d.put(names[i], ps[5]);
            }
            else if (sc.equals(finScore[6])) {
                d.put(names[i], ps[6]);
            }
            else if (sc.equals(finScore[7])) {
                d.put(names[i], ps[7]);
            }
            else if (sc.equals(finScore[8])) {
                d.put(names[i], ps[8]);
            }
            else if (sc.equals(finScore[9])) {
                d.put(names[i], ps[9]);
            }
            else if (sc.equals(finScore[10])) {
                d.put(names[i], ps[10]);
            }
            else if (sc.equals(finScore[11])) {
                d.put(names[i], ps[11]);
            }
            else if (sc.equals(finScore[12])) {
                d.put(names[i], ps[12]);
            }
            else if (sc.equals(finScore[13])) {
                d.put(names[i], ps[13]);
            }
            else if (sc.equals(finScore[14])) {
                d.put(names[i], ps[14]);
            }
            else {
                d.put(names[i], 0);
            }
        }

        if (Test.count == 0) {
            total = d;
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                if (total.containsKey(names[i])) {
                    String n = String.format("%-14s", names[i]);

                    total.replace(names[i], total.get(names[i]) + d.get(names[i]));
                }
            }
        }

        List<Map.Entry<String, Integer>> fin = sortMap(total);
        int game = Test.count+1;
        System.out.println("Points Leaders After Tournament " + game + " at the " + Test.course +  ":\n");
        for (Map.Entry<String, Integer> entry : fin) {
            String[] sv = String.valueOf(entry).split("=");
            System.out.println(entry.getKey() + " | " + sv[1]);
        }

    }

    public static List sortMap(LinkedHashMap map) {
        List<Map.Entry<String, Integer>> capitalList = new LinkedList<>(map.entrySet());
        Collections.sort(capitalList, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));
        Collections.reverse(capitalList);

        return capitalList;
    }


    public static void main (List list) {
        ps[0] = 45;
        ps[1] = 38;
        ps[2] = 33;
        ps[3] = 29;
        ps[4] = 25;
        ps[5] = 21;
        ps[6] = 18;
        ps[7] = 15;
        ps[8] = 12;
        ps[9] = 10;
        ps[10] = 8;
        ps[11] = 6;
        ps[12] = 4;
        ps[13] = 2;
        ps[14] = 1;
        point(list);
    }

}
