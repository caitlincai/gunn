package josephus;

import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {
       populateList(list, 4);
       System.out.println(josephus(4));
    }  

    public static int populateList(ArrayList<Integer> alist, int n) {
        writeList(n);
        boolean kill = false;
        int i = 0;
        while (list.size() > 0) {
            if (kill == true) {
                alist.remove(i);
                kill = false;
            }
            else {
                kill = true;
                i++;
            }
        }
         return alist.get(0);
    }
    public static int josephus(int n) {
        String binary = Integer.toString(Integer.toBinary(n));
        char c = binary.charAt(0);
        binary = binary.substring(1) + c;
        int num = Integer.parseInt(Integer.valueOf(binary), 2);
        return num;
    }
    public static void writeList(int n) {
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
    }
}
