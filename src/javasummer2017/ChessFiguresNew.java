package javasummer2017;

import java.util.Scanner;

public class ChessFiguresNew {
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

        //test();
    }


    private static int getRandomCoordinate() {
        return (int) (Math.random() * 8 + 1);
    }


    private static int getChessFigure() {
        Scanner scan = new Scanner(System.in);
        int result = scan.nextInt();
        scan.close();
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
                return checkForBlackPawn(coordVerticalFig, coordHorizontalFig,
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
        return Math.abs(coordVerticalFig - coordVerticalOpponent) == 1 &&
                Math.abs(coordHorizontalFig - coordHorizontalOpponent) != 2 ||
                Math.abs(coordHorizontalFig - coordHorizontalOpponent) == 1 &&
                        Math.abs(coordVerticalFig - coordVerticalOpponent) != 2;

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
            System.out.println("The white pawn threatens to the opponent's figure.");
            danger = true;
            return danger;
        }

        return false;
    }

    private static boolean checkForBlackPawn(int coordVerticalFig, int coordHorizontalFig,
                                             int coordVerticalOpponent, int coordHorizontalOpponent) {
        boolean move = false;
        if (coordVerticalFig == coordVerticalOpponent &&
                coordHorizontalOpponent - coordHorizontalFig == -1 ||
                coordVerticalFig == coordVerticalOpponent &&
                        coordHorizontalFig == 7 &&
                        coordHorizontalOpponent - coordHorizontalFig == -2) {
            System.out.println("The black pawn moves to another field.");
            move = true;
            return move;
        }
        boolean danger = false;
        if (Math.abs(coordVerticalOpponent - coordVerticalFig) == 1 &&
                coordHorizontalOpponent - coordHorizontalFig == -1) {
            System.out.println("The black pawn threatens to the opponent's figure.");
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


    private static void test() {
        boolean passed = true;

        int coordV = 2;
        int coordH = 7;
        int coordVO = 2;
        int coordHO = 2;

        boolean expectedResultForRook = true;
        boolean expectedResultForBishop = false;
        boolean expectedResultForKing = false;
        boolean expectedResultForQueen = true;
        boolean expectedResultForWhitePawn = false;
        boolean expectedResultForBlackPawn = false;
        boolean expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        coordV = 2;
        coordH = 7;
        coordVO = 3;
        coordHO = 7;

        expectedResultForRook = true;
        expectedResultForBishop = false;
        expectedResultForKing = true;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = false;
        expectedResultForBlackPawn = false;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        coordV = 2;
        coordH = 7;
        coordVO = 7;
        coordHO = 2;

        expectedResultForRook = false;
        expectedResultForBishop = true;
        expectedResultForKing = false;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = false;
        expectedResultForBlackPawn = false;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        coordV = 2;
        coordH = 7;
        coordVO = 1;
        coordHO = 6;

        expectedResultForRook = false;
        expectedResultForBishop = true;
        expectedResultForKing = true;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = false;
        expectedResultForBlackPawn = true;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        coordV = 2;
        coordH = 7;
        coordVO = 1;
        coordHO = 7;

        expectedResultForRook = true;
        expectedResultForBishop = false;
        expectedResultForKing = true;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = false;
        expectedResultForBlackPawn = false;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        coordV = 2;
        coordH = 7;
        coordVO = 2;
        coordHO = 6;

        expectedResultForRook = true;
        expectedResultForBishop = false;
        expectedResultForKing = true;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = false;
        expectedResultForBlackPawn = true;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);

        coordV = 2;
        coordH = 7;
        coordVO = 2;
        coordHO = 5;

        expectedResultForRook = true;
        expectedResultForBishop = false;
        expectedResultForKing = false;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = false;
        expectedResultForBlackPawn = true;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        coordV = 2;
        coordH = 2;
        coordVO = 3;
        coordHO = 3;

        expectedResultForRook = false;
        expectedResultForBishop = true;
        expectedResultForKing = true;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = true;
        expectedResultForBlackPawn = false;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);

        coordV = 2;
        coordH = 2;
        coordVO = 2;
        coordHO = 3;

        expectedResultForRook = true;
        expectedResultForBishop = false;
        expectedResultForKing = true;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = true;
        expectedResultForBlackPawn = false;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        coordV = 2;
        coordH = 2;
        coordVO = 2;
        coordHO = 4;

        expectedResultForRook = true;
        expectedResultForBishop = false;
        expectedResultForKing = false;
        expectedResultForQueen = true;
        expectedResultForWhitePawn = true;
        expectedResultForBlackPawn = false;
        expectedResultForKnight = false;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        coordV = 2;
        coordH = 2;
        coordVO = 3;
        coordHO = 4;

        expectedResultForRook = false;
        expectedResultForBishop = false;
        expectedResultForKing = false;
        expectedResultForQueen = false;
        expectedResultForWhitePawn = false;
        expectedResultForBlackPawn = false;
        expectedResultForKnight = true;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);

        coordV = 2;
        coordH = 2;
        coordVO = 4;
        coordHO = 3;

        expectedResultForRook = false;
        expectedResultForBishop = false;
        expectedResultForKing = false;
        expectedResultForQueen = false;
        expectedResultForWhitePawn = false;
        expectedResultForBlackPawn = false;
        expectedResultForKnight = true;

        passed = isPassed(passed,
                coordV, coordH, coordVO, coordHO,
                expectedResultForRook, expectedResultForBishop,
                expectedResultForKing, expectedResultForQueen,
                expectedResultForWhitePawn, expectedResultForBlackPawn,
                expectedResultForKnight);


        if (passed) {
            System.out.println("Test passed.");
        }


    }

    private static boolean isPassed(boolean passed,
                                    int coordV, int coordH, int coordVO, int coordHO,
                                    boolean expectedResultForRook, boolean expectedResultForBishop,
                                    boolean expectedResultForKing, boolean expectedResultForQueen,
                                    boolean expectedResultForWhitePawn, boolean expectedResultForBlackPawn,
                                    boolean expectedResultForKnight) {

        boolean resultForRook = checkForRook(coordV, coordH, coordVO, coordHO);
        boolean resultForBishop = checkForBishop(coordV, coordH, coordVO, coordHO);
        boolean resultForKing = checkForKing(coordV, coordH, coordVO, coordHO);
        boolean resultForQueen = checkForQueen(coordV, coordH, coordVO, coordHO);
        boolean resultForWhitePawn = checkForWhitePawn(coordV, coordH, coordVO, coordHO);
        boolean resultForBlackPawn = checkForBlackPawn(coordV, coordH, coordVO, coordHO);
        boolean resultForKnight = checkForKnight(coordV, coordH, coordVO, coordHO);

        if (resultForRook != expectedResultForRook) {
            System.out.println("Test error for Rook.");
            passed = false;
        }
        if (resultForBishop != expectedResultForBishop) {
            System.out.println("Test error for Bishop.");
            passed = false;
        }
        if (resultForKing != expectedResultForKing) {
            System.out.println("Test error for King.");
            passed = false;
        }
        if (resultForQueen != expectedResultForQueen) {
            System.out.println("Test error for Queen.");
            passed = false;
        }
        if (resultForWhitePawn != expectedResultForWhitePawn) {
            System.out.println("Test error for White pawn.");
            passed = false;
        }
        if (resultForBlackPawn != expectedResultForBlackPawn) {
            System.out.println("Test error for Black pawn.");
            passed = false;
        }
        if (resultForKnight != expectedResultForKnight) {
            System.out.println("Test error for Knight.");
            passed = false;
        }
        return passed;
    }
}
