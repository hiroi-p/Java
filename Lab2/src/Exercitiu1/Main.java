package Exercitiu1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Vector<String> v = new Vector<>(41,1);
        Scanner sc = new Scanner(new File("src/Exercitiu1/judete_in.txt"));
        Scanner afis = new Scanner(System.in);
        while(sc.hasNextLine()) {
            v.add(sc.nextLine());
        }
        String[] array = v.toArray(new String[0]);
        //Arrays.sort(array);
        Arrays.sort(array, 0,40);
        sc.close();
        String a = afis.nextLine();
        System.out.println(Arrays.binarySearch(array,a));
        }
    }

