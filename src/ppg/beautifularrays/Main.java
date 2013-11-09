package ppg.beautifularrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("test.txt"));
		int n = 300000; //in.nextInt();
		int k = 395000; //in.nextInt();
		int upperBound = 1000001;
		int lower = 1000001;
		int[] array = new int[n];
		for (int i=0;i<n;i++) {
			int next;
			if (i == 0) next = 395001;
			else next = 799998-i; //in.nextInt();
			if (next > k && next < upperBound) upperBound = next;
			else if (next <= k && next < lower) lower = next;
			array[i] = next;
		}
		in.close();
		long timer = System.nanoTime();
		int beauty = upperBound;
		if (lower < 1000001) {
			System.out.println(lower);
			return;
		}
		while (true) {
			boolean broken = false;
			if (!broken) for (int a : array) {
				if (a % beauty > k) {
					broken = true;
					break;
				}
			}
			if (!broken) {
				System.out.println(beauty);
				System.out.println((System.nanoTime()-timer)/1000000.0);
				return;
			}
			if (beauty%10000 == 0) {
				System.out.println(beauty);
				System.out.println((System.nanoTime()-timer)/1000000.0);
			}
			beauty--;
		}
	}

}
