package Matrix;

/**
 *
 * @author Odigras
 */
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixCalculator {

    //assigns letters to matrices as a way for the user to access them.
    static HashMap<String, Matrix> map = new HashMap<>();
    static char matrixNamer = 'A';

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //menu starts here
        String choice;
        menu:
        while (true) {
            System.out.println("------------ Main Menu ------------\n");
            System.out.println("1 -> Create a matrix");
            System.out.println("2 -> Add two matrices");
            System.out.println("3 -> Subtract two matrices");
            System.out.println("4 -> Multiply two matrices");
            //            System.out.println("...");
            System.out.println("r -> rename a matrix");
            System.out.println("d -> display a matrix");
            System.out.println("0 -> Exit\n");

            System.out.print("please choose your operation: ");

            choice = input.next().trim().toLowerCase();

            switch (choice) {
                //creates matrix
                case "1" -> {
                    String matrixName = String.valueOf(matrixNamer);
                    int nbOfRows, nbOfColumns;
                    //informs the user if input was not right
                    try {
                        System.out.print("Enter number of rows: ");
                        nbOfRows = input.nextInt();
                        System.out.print("Enter number of columns: ");
                        nbOfColumns = input.nextInt();
                        if (nbOfRows < 2 || nbOfColumns < 2) {
                            throw new InputMismatchException();
                        }
                    } catch (InputMismatchException iae) {
                        System.out.println("Error: Rows and Columns can only be integers greater than 1");
                        input.nextLine();
                        continue;
                    }
                    try {
                        map.put(matrixName, new Matrix(nbOfRows, nbOfColumns, 0));
                    } catch (InputMismatchException ime) {
                        System.out.println("matrix values can only be real numbers.");
                        input.nextLine();
                        continue;
                    }
                    System.out.print(map.get(matrixName));
                    matrixNamer++;
                }

                //adds two matrices
                case "2" -> {
                    while (true) {
                        if (Matrix.getTotalNbOfInputMatrices() < 1) {
                            System.out.println("You must create a matrix before performing this operation...");
                            break;
                        } else if (Matrix.getTotalNbOfInputMatrices() < 2) {
                            System.out.println("Not enough matrices...");
                            break;
                        }
                        //displays available matrices
                        System.out.println(map.keySet());
                        //chooses two matrices
                        System.out.print("Matrix1: ");
                        String matrix1 = input.next().trim();
                        System.out.print("Matrix2: ");
                        String matrix2 = input.next().trim();
                        Matrix result;//make sure matrix is available
                        try {
                            result = map.get(matrix1).add(map.get(matrix2));
                        } catch (NullPointerException npe) {
                            System.out.println("Please choose from the available matrecies!");
                            continue;
                        }
                        //informs the user if the chosen matrecies are addable(if the mul() method returns null, this means they are not addable)
                        if (result == null) {
                            System.out.println("    \n***Can't add the chosen matrecies.***");
                            System.out.println("***[ Matrix " + matrix1 + " has " + map.get(matrix1).getRows()
                                    + " rows and " + map.get(matrix1).getColumns()
                                    + " columns While Matrix " + matrix2 + " has " + map.get(matrix2).getRows()
                                    + " rows and " + map.get(matrix2).getColumns() + " columns]***");
                            System.out.println("***NOTE: To add two matrecies, they must have equal number of rows and equal number of columns.***\n");
                        } else {
                            System.out.print("\nResult of " + matrix1 + " + " + matrix2 + " =");
                            System.out.print(result);
                        }
                        //return to main menu?
                        System.out.print("Return to main menu? (y/n): ");
                        char back = input.next().toLowerCase().charAt(0);
                        if (back == 'y') {
                            break;
                        }
                    }
                }

                //subtracts two matrices
                case "3" -> {
                    while (true) {
                        if (Matrix.getTotalNbOfInputMatrices() < 1) {
                            System.out.println("You must create a matrix before performing this operation...");
                            break;
                        } else if (Matrix.getTotalNbOfInputMatrices() < 2) {
                            System.out.println("Not enough matrices...");
                            break;
                        }
                        //displays available matrices
                        System.out.println(map.keySet());
                        //chooses two matrices
                        System.out.print("Matrix1: ");
                        String matrix1 = input.next().trim();
                        System.out.print("Matrix2: ");
                        String matrix2 = input.next().trim();
                        Matrix result;//make sure matrix is available
                        try {
                            result = map.get(matrix1).sub(map.get(matrix2));
                        } catch (NullPointerException npe) {
                            System.out.println("Please choose from the available matrecies!");
                            continue;
                        }
                        //informs the user if the chosen matrecies are subtractable(if the mul() method returns null, this means they are not subtractable)
                        if (result == null) {
                            System.out.println("    \n***Can't subtract the chosen matrecies.***");
                            System.out.println("***[ Matrix " + matrix1 + " has " + map.get(matrix1).getRows()
                                    + " rows and " + map.get(matrix1).getColumns()
                                    + " columns While Matrix " + matrix2 + " has " + map.get(matrix2).getRows()
                                    + " rows and " + map.get(matrix2).getColumns() + " columns]***");
                            System.out.println("***NOTE: To subtract two matrecies, they must have equal number of rows and equal number of columns.***\n");
                        } else {
                            System.out.print("\nResult of " + matrix1 + " - " + matrix2 + " =");
                            System.out.print(result);
                        }
                        //return to main menu?
                        System.out.print("Return to main menu? (y/n): ");
                        char back = input.next().toLowerCase().charAt(0);
                        if (back == 'y') {
                            break;
                        }
                    }
                }

                //multiplies two matrices
                case "4" -> {
                    while (true) {
                        if (Matrix.getTotalNbOfInputMatrices() < 1) {
                            System.out.println("You must create a matrix before performing this operation...");
                            break;
                        } else if (Matrix.getTotalNbOfInputMatrices() < 2) {
                            System.out.println("Not enough matrices...");
                            break;
                        }
                        //displays available matrices
                        System.out.println(map.keySet());
                        //chooses two matrices
                        System.out.print("Matrix1: ");
                        String matrix1 = input.next().trim();
                        System.out.print("Matrix2: ");
                        String matrix2 = input.next().trim();
                        Matrix result;//make sure matrix is available
                        try {
                            result = map.get(matrix1).mul(map.get(matrix2));
                        } catch (NullPointerException npe) {
                            System.out.println("Please choose from the available matrecies!");
                            continue;
                        }
                        //informs the user if the chosen matrecies are multipliable(if the mul() method returns null, this means they are not multipliable)
                        if (result == null) {
                            System.out.println("    \n***Can't multiply the chosen matrecies.***");
                            System.out.println("***[ Matrix " + matrix1 + " has " + map.get(matrix1).getRows()
                                    + " rows and " + map.get(matrix1).getColumns()
                                    + " columns While Matrix " + matrix2 + " has " + map.get(matrix2).getRows()
                                    + " rows and " + map.get(matrix2).getColumns() + " columns]***");
                            System.out.println("""
                                               ***NOTE: To multiply two matrecies, number of columns in the first matrix must equal the number of rows in the second matrix.***
                                               """);
                        } else {
                            System.out.print("\nResult of " + matrix1 + " * " + matrix2 + " =");
                            System.out.print(result);
                        }
                        //return to main menu?
                        System.out.print("Return to main menu? (y/n): ");
                        char back = input.next().toLowerCase().charAt(0);
                        if (back == 'y') {
                            break;
                        }
                    }
                }

                case "r" -> {
                    if (Matrix.getTotalNbOfInputMatrices() < 1) {
                        System.out.println("You must create a matrix before performing this operation...");
                        continue;
                    }
                    System.out.println(map.keySet());
                    System.out.print("Choose the matrix you want to rename: ");
                    String chosenMatrix = input.next().trim();
                    if (!map.containsKey(chosenMatrix)) {
                        System.out.println("No such matrix");
                    } else {
                        //remove old (key, value) and add a new (key, value) with updated key name
                        System.out.print("New name: ");
                        String newName = input.next().trim();
                        //check if chosen name
                        map.put(newName, map.remove(chosenMatrix));
                        System.out.println("Success: " + chosenMatrix + " -> " + newName + "\n");
                    }
                }

                //displays available matrices
                case "d" -> {
                    while (true) {
                        if (Matrix.getTotalNbOfInputMatrices() < 1) {
                            System.out.println("No matrices created yet");
                            break;
                        }
                        System.out.println(map.keySet());
                        //exit loop, enter input, handle exeptions, display matrix
                        System.out.print("Choose the matrix you want to display (Enter 0 to return to main menu): ");
                        String chosenMatrix = input.next().trim();
                        if (chosenMatrix.equals("0")) { //returns to main menu
                            break;
                        } else if (!map.containsKey(chosenMatrix)) {
                            System.out.println("No such matrix");
                        } else {
                            System.out.print(chosenMatrix + ": " + map.get(chosenMatrix));
                        }
                    }

                }

                //stops the menu and ends the program
                case "0" -> {
                    break menu;
                }

                default ->
                    System.out.println("Option not available...");
            }
        }
        input.close();

    }
}
