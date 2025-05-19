import java.util.Scanner;

public class Assin5Quest3New {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the total number of items (n): ");
	        int n = scanner.nextInt();
	        System.out.print("Enter the team size (m): ");
	        int k = scanner.nextInt();

	        int[] currentTeam = new int[k];
	        teamCombo(n, k, currentTeam, 0, 1);

	        scanner.close();
	    }
	
	public static void teamCombo(int n, int k, int[] comboTeam, int currentIndex, int start) {
        if (k == 0) {
            // Base case: When the team size (k) reaches 0, print the current team
        	showTeam(comboTeam);
            return;
        }

        // Recursive case: Generate all combinations
        for (int i = start; i <= n; i++) {
        	comboTeam[currentIndex] = i;
            teamCombo(n, k - 1, comboTeam, currentIndex + 1, i + 1);
        }
    }

    public static void showTeam(int[] team) {
        for (int i = 0; i < team.length; i++) {
            System.out.print(team[i] + " ");
        }
        System.out.println();
    }
	
}
