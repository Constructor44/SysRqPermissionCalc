import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Bitte geben Sie den Rechte-Wert ein: ");
        Scanner sc = new Scanner(System.in);
        int permInt;
        try{
            permInt = sc.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("Falsche Eingabe!");
            return;
        }
        System.out.println("Der Wert " + permInt + " hat folgende Rechte: ");
        ArrayList<Integer> r = getPerms(permInt);
        for (int p : r) {
            System.out.print(p + "\t");
            appendDescription(p);
        }
    }

    private static void appendDescription(int curr) {
        switch (curr) {
            case 2:
                System.out.println("enable control of console logging level");
                break;
            case 4:
                System.out.println("enable control of keyboard (SAK, unraw)");
                break;
            case 8:
                System.out.println("enable debugging dumps of processes etc.");
                break;
            case 16:
                System.out.println("enable sync command");
                break;
            case 32:
                System.out.println("enable remount read-only");
                break;
            case 64:
                System.out.println("enable signalling of processes (term, kill, oom-kill)");
                break;
            case 128:
                System.out.println("allow reboot/poweroff");
                break;
            case 256:
                System.out.println("allow nicing of all RT tasks");
                break;
        }
    }

    private static ArrayList<Integer> getPerms(int permInt) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (int k = 1; k <= 8; k++) {
            int res = permInt & (int) Math.pow(2,k);
            if (res != 0) {
                out.add(res);
            }
        }
        return out;
    }
}
