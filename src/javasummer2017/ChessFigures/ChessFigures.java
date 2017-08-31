package javasummer2017.ChessFigures;

import java.util.Scanner;

public class ChessFigures {

    public static void main(String[] args) {
        int coordVerticalFig;
        int coordHorizontalFig;
        int coordVerticalOpponent;
        int coordHorizontalOpponent;

        while (true) {
            coordVerticalFig = getRandomCoordinate();
            coordHorizontalFig = getRandomCoordinate();
            coordVerticalOpponent = getRandomCoordinate();
            coordHorizontalOpponent = getRandomCoordinate();
            if (coordVerticalFig != coordVerticalOpponent ||
                    coordHorizontalFig != coordHorizontalOpponent) {
                break;
            }
        }

        System.out.println("The coordinates of your chess figure\n" +
                "and the coordinates of the opponent's chess figure\n" +
                "are set on  8 x 8 chessboard.\n");
        System.out.printf("Vertical and horizontal of your chess figure: %d%2d%n",
                coordVerticalFig, coordHorizontalFig);
        System.out.printf("Vertical and horizontal of opponent's chess figure: %d%2d%n",
                coordVerticalOpponent, coordHorizontalOpponent);
        System.out.println();

        System.out.println("Please, choose a chess figure:");
        System.out.println("1 - rook;");
        System.out.println("2 - bishop;");
        System.out.println("3 - king;");
        System.out.println("4 - queen;");
        System.out.println("5 - white pawn;");
        System.out.println("6 - black pawn;");
        System.out.println("7 - knight.");
        System.out.println("White pawns move from bottom to top.");
        System.out.println("Black pawns move from top to bottom.");

        System.out.print("Input your choice: ");
        int choice = getChessFigure();
        System.out.println();

        boolean check = checkForChessFigure(choice,
                coordVerticalFig, coordHorizontalFig,
                coordVerticalOpponent, coordHorizontalOpponent);

        printResultOfCheck(check, coordVerticalOpponent, coordHorizontalOpponent);
    }


    private static int getRandomCoordinate() {
        return (int) (Math.random() * 8 + 1);
    }


    private static int getChessFigure() {         //доработать
        Scanner scan = new Scanner(System.in);
        int result = scan.nextInt();
        return result;

    }

    private static boolean checkForChessFigure(int choiceOfUser,
                                               int coordVerticalFig, int coordHorizontalFig,
                                               int coordVerticalOpponent, int coordHorizontalOpponent) {
        switch (choiceOfUser) {
            case 1:
                return checkForRook(coordVerticalFig, coordHorizontalFig,
                        coordVerticalOpponent, coordHorizontalOpponent);
            case 2:
                return checkForBishop(coordVerticalFig, coordHorizontalFig,
                        coordVerticalOpponent, coordHorizontalOpponent);
            case 3:
                return checkForKing(coordVerticalFig, coordHorizontalFig,
                        coordVerticalOpponent, coordHorizontalOpponent);
            case 4:
                return checkForQueen(coordVerticalFig, coordHorizontalFig,
                        coordVerticalOpponent, coordHorizontalOpponent);
            case 5:
                return checkForWhitePawn(coordVerticalFig, coordHorizontalFig,
                        coordVerticalOpponent, coordHorizontalOpponent);
            case 6:
                return checkForBlackPown(coordVerticalFig, coordHorizontalFig,
                        coordVerticalOpponent, coordHorizontalOpponent);
            case 7:
                return checkForKnight(coordVerticalFig, coordHorizontalFig,
                        coordVerticalOpponent, coordHorizontalOpponent);

        }

        return false;
    }


    private static boolean checkForRook(int coordVerticalFig, int coordHorizontalFig,
                                        int coordVerticalOpponent, int coordHorizontalOpponent) {
        return coordVerticalFig == coordVerticalOpponent ||
                coordHorizontalFig == coordHorizontalOpponent;
    }


    private static boolean checkForBishop(int coordVerticalFig, int coordHorizontalFig,
                                          int coordVerticalOpponent, int coordHorizontalOpponent) {
        return Math.abs(coordVerticalFig - coordVerticalOpponent) ==
                Math.abs(coordHorizontalFig - coordHorizontalOpponent);
    }


    private static boolean checkForKing(int coordVerticalFig, int coordHorizontalFig,
                                        int coordVerticalOpponent, int coordHorizontalOpponent) {
        return Math.abs(coordVerticalFig - coordVerticalOpponent) == 1 ||
                Math.abs(coordHorizontalFig - coordHorizontalOpponent) == 1;

    }


    private static boolean checkForQueen(int coordVerticalFig, int coordHorizontalFig,
                                         int coordVerticalOpponent, int coordHorizontalOpponent) {
        return coordVerticalFig == coordVerticalOpponent ||
                coordHorizontalFig == coordHorizontalOpponent ||
                Math.abs(coordVerticalFig - coordVerticalOpponent) ==
                        Math.abs(coordHorizontalFig - coordHorizontalOpponent);
    }


    private static boolean checkForWhitePawn(int coordVerticalFig, int coordHorizontalFig,
                                             int coordVerticalOpponent, int coordHorizontalOpponent) {
        boolean move = false;
        if (coordVerticalFig == coordVerticalOpponent &&
                coordHorizontalOpponent - coordHorizontalFig == 1 ||
                coordVerticalFig == coordVerticalOpponent &&
                        coordHorizontalFig == 2 &&
                        coordHorizontalOpponent - coordHorizontalFig == 2) {
            System.out.println("The white pawn moves to another field.");
            move = true;
            return move;
        }
        boolean danger = false;
        if (Math.abs(coordVerticalOpponent - coordVerticalFig) == 1 &&
                coordHorizontalOpponent - coordHorizontalFig == 1) {
            System.out.println("White pawn threatens the opponent's figure.");
            danger = true;
            return danger;
        }

        return false;
    }

    private static boolean checkForBlackPown(int coordVerticalFig, int coordHorizontalFig,
                                             int coordVerticalOpponent, int coordHorizontalOpponent) {
        boolean move = false;
        if (coordVerticalFig == coordVerticalOpponent &&
                coordHorizontalOpponent - coordHorizontalFig == -1 ||
                coordVerticalFig == coordVerticalOpponent &&
                        coordHorizontalFig == 7 &&
                        coordHorizontalOpponent - coordHorizontalFig == -2) {
            System.out.println("The white pawn moves to another field.");
            move = true;
            return move;
        }
        boolean danger = false;
        if (Math.abs(coordVerticalOpponent - coordVerticalFig) == 1 &&
                coordHorizontalOpponent - coordHorizontalFig == -1) {
            System.out.println("White pawn threatens the opponent's figure.");
            danger = true;
            return danger;
        }

        return false;
    }

    private static boolean checkForKnight(int coordVerticalFig, int coordHorizontalFig,
                                          int coordVerticalOpponent, int coordHorizontalOpponent) {
        return Math.abs(coordVerticalFig - coordVerticalOpponent) *
                Math.abs(coordHorizontalFig - coordHorizontalOpponent) == 2;
    }

    private static void printResultOfCheck(boolean check,
                                           int coordVerticalOpponent, int coordHorizontalOpponent) {
        if (check) {
            System.out.printf("This figure can hit or go " +
                            "to the field with coordinates %d%2d.%n",
                    coordVerticalOpponent, coordHorizontalOpponent);
        } else {
            System.out.printf("This figure can not hit or go " +
                            "to the field with coordinates %d%2d.%n",
                    coordVerticalOpponent, coordHorizontalOpponent);
        }
    }

    // написать test()
}


