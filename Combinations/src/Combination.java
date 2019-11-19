import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        int n, k;
        do {
            System.out.println("Please insert n");
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();
        } while (n <= 0);

        do {
            System.out.println("Please insert k");
            Scanner scan = new Scanner(System.in);
            k = scan.nextInt();
        } while (k <= 0 || k > n);

        printCombinations(k, n);
    }

    private static void printCombinations(int k, int n) {
        // init combination array
        int row[] = new int[k];

        int index = 0; // index for combination row
        int value = 1; // value for elements of row

        while (index >= 0) {
            //biggest value for every index will be n - k + real index(index + 1)
            // forward step if    value < (n - k + index + 1)
            if (value <= (n - k + index + 1)) {
                row[index] = value;
                // if all indexes in row are full, print row and increment value;
                if (index == k - 1) {
                    for (int j : row) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                    value++;
                } else {
                    // if row is not full yet, select next element
                    value = row[index] + 1;
                    index++;
                }
            }
            // step back
            else {
                index--;
                if (index >= 0)
                    value = row[index] + 1;

            }
        }
    }
}
