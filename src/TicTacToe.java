import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        String[][] field = new String[3][3];

        Scanner sc = new Scanner(System.in);
        System.out.println("Tic-Tac-Toe program :)");
        System.out.println("A)Two players; q)Quit");
        char choose = sc.next().charAt(0);
        choose = Character.toUpperCase(choose);
        while (!(choose == 'q' || choose == 'Q')) {
            switch (choose) {
                case 'A':
                    System.out.println("Enter first player nickname: ");
                    String nickname1 = sc.next();
                    System.out.println("Enter second player nickname: ");
                    String nickname2 = sc.next();
                    System.out.println("First begin - " + nickname1);
                    String choose2 = "Y";
                    System.out.println("Choose your sign: 1) X   2) 0 ");
                    System.out.println(nickname1 + "  Your choice: ");
                    String firstCh = sc.next();
                    String secondCh;
                    if (firstCh.equals("X") || firstCh.equals("x")) {
                        secondCh = "0";
                    } else if (firstCh.equals("0")) {
                        secondCh = "X";
                    } else {
                        System.out.println("Incorrect input :( Try again");
                        continue;
                    }
                    boolean moveFirst = true;
                    int numbOfCalls = 0;
                    while (choose2.equals("Y") || choose2.equals("y")) {

                        if (moveFirst) {
                            System.out.println(nickname1 + " Enter a location of " + firstCh + " from 1 to 9");
                            printNumbOfPosition();
                        } else {
                            System.out.println(nickname2 + " Enter a location of your sign from 1 to 9");
                            printNumbOfPosition();
                        }
                        String location = sc.next();
                        if (!putValue(field, location, moveFirst,firstCh,secondCh)) {
                            continue;
                        }
                        printGameField(field);
                        moveFirst = !moveFirst;
                        boolean end = false;
                          if (checkWin(field,numbOfCalls) == firstCh) {
                            System.out.println("Player: " + nickname1 + " Won!!!!!");
                            end = true;
                        } else if (checkWin(field,numbOfCalls) == secondCh) {
                            System.out.println("Player: " + nickname2 + " Won!!!!!");
                            end = true;
                        } else if (checkWin(field,numbOfCalls) == "equal") {
                            System.out.println("Draw");
                            end = true;
                        }
                          if (end) {
                              field = new String[3][3];
                              numbOfCalls = 0;
                              System.out.println("Do you want play again? (Y) - Yes / (N) - Return to menu");
                              choose2 = sc.next();
                              moveFirst = true;
                          }
                        numbOfCalls++;
                        System.out.println("Game continue");

                    }
                    break;
            }
            System.out.println("(A) Change name and start; (Q) - Quit");
            choose = sc.next().charAt(0);
            choose = Character.toUpperCase(choose);
        }

        field[0][2] = "X";
        printGameField(field);

    }
    static void printGameField(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printNumbOfPosition() {
        int field1[][] = new int[3][3];
        for (int i = 0; i < field1.length; i++){
            for(int j = 0; j < field1[i].length; j++) {
                field1[i][j] = j + 1;
                if (i == 1) {
                    field1[i][j] = j + 4;
                }
                if (i == 2) {
                    field1[i][j] = j + 7;
                }
                System.out.print(field1[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static String  comparingSign(boolean moveFirst, String firstCh, String secondCh) {
                String compare;
            if (moveFirst) {
                compare = firstCh;
            } else {
                compare = secondCh;
            }
            return compare;
    }

    static String checkWin(String field[][],int numbOfCalls) {

        for(int i = 0; i < field.length; i++) {
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != null) {
                return field[0][i];
            }
        }
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != null) {
                return field[i][0];
            }
        }
        for (int i = 0; i < field.length - 2; i++) {
            if (field[i][0] == field[i + 1][1] && field[i][0] == field[i + 2][2] && field[i][0] != null) {
                return field[i][0];
            }
        }
        for (int i = 0; i < field.length - 2; i++) {
            if (field[i][2] == field[i + 1][1] && field[i][2] == field[i + 2][0] && field[i][2] != null) {
                return field[i][2];
            }
        }

        String equal = "equal";
        if (numbOfCalls == 8 ) {
            return equal;
        }

        return null;
    }

    static boolean putValue(String field[][], String location, boolean moveFirst, String firstCh, String secondCh) {
        switch (location) {
            case "1":
                if (field[0][0] != null) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                field[0][0] = comparingSign(moveFirst,firstCh,secondCh);
                return true;
            case "2":
                //if (field[0][1] == firstCh || field[0][1] == secondCh) {
                if (field[0][1] != null) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                field[0][1] = comparingSign(moveFirst,firstCh,secondCh);
                return true;
            case "3":
                if (field[0][2] != null ) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                field[0][2] = comparingSign(moveFirst,firstCh,secondCh);
                return true;
            case "4":
                if (field[1][0] != null) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                //field[1][0] = firstCh;
                field[1][0] = comparingSign(moveFirst,firstCh,secondCh);
                return true;
            case "5":
                if (field[1][1] != null) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                field[1][1] = comparingSign(moveFirst,firstCh,secondCh);
                return true;
            case "6":
                if (field[1][2] != null) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                field[1][2] = comparingSign(moveFirst,firstCh,secondCh);
                return true;
            case "7":
                if (field[2][0] != null) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                field[2][0] = comparingSign(moveFirst,firstCh,secondCh);
                return true;
            case "8":
                if (field[2][1] != null) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                field[2][1] = comparingSign(moveFirst,firstCh,secondCh);
                return true;
            case "9":
                if (field[2][2] != null) {
                    System.out.println("Sorry, There is sign in this location :(");
                    return false;
                }
                field[2][2] = comparingSign(moveFirst,firstCh,secondCh);

                return true;

            default:
                System.out.println("Badly input,Try again!");
                return false;
        }
    }
}
