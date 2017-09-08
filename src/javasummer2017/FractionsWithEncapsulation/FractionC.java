package javasummer2017.FractionsWithEncapsulation;

public class FractionC {

    private static final short DEFAULT_PART = 0;
    private static final boolean DEFAULT_NEGATIVE_NUMBER = false;

    private boolean negativeNumber;
    private long whole;
    private short part;
    private int counterOfZero;

    FractionC() {
        this.negativeNumber = DEFAULT_NEGATIVE_NUMBER;
        this.whole = 0;
        this.part = DEFAULT_PART;
        this.counterOfZero = 0;
    }

    FractionC(long whole, int part) {
        this.negativeNumber = DEFAULT_NEGATIVE_NUMBER;
        setWhole(whole);
        setPart(part);
        this.counterOfZero = 0;
    }

    FractionC(long whole, int part, int counter) {
        this.negativeNumber = DEFAULT_NEGATIVE_NUMBER;
        setWhole(whole);
        setPart(part);
        setCounterOfZero(counter);
    }

    FractionC(boolean negativeNumber, long whole, int part, int counter) {
        setNegativeNumber(negativeNumber);
        setWhole(whole);
        setPart(part);
        setCounterOfZero(counter);
    }


    public long getWhole() {
        return whole;
    }

    public void setWhole(long whole) {
        if (whole < 0) {
            this.setNegativeNumber(true);
            this.whole = -whole;
        } else {
            this.whole = whole;
        }
    }


    public short getPart() {
        return part;
    }

    public void setPart(int part) {
        if (part >= 1 && part < 10000) {
            this.part = (short) part;
        } else if (part >= 10000) {
            int temp = part;
            do {
                temp /= 10;
            } while (temp >=10000);
            this.part = (short) temp;
        } else if (part == 0) {
            this.part = DEFAULT_PART;
        } else {
            System.err.println("The value of part is not correct.");
            System.out.println(("The value of part for this case will be zero."));
            this.part = DEFAULT_PART;
        }
    }

    public int getCounterOfZero() {
        return counterOfZero;
    }

    public void setCounterOfZero(int counterOfZero) {
        this.counterOfZero = counterOfZero;
    }


    public boolean isNegativeNumber() {
        return negativeNumber;
    }

    public void setNegativeNumber(boolean negativeNumber) {
        this.negativeNumber = negativeNumber;
    }

    void printFraction() {
        if (isNegativeNumber()) {
            switch (counterOfZero) {
                case 0:
                    System.out.print("-" + whole + "." + part);
                    break;
                case 1:
                    System.out.print("-" + whole + ".0" + part);
                    break;
                case 2:
                    System.out.print("-" + whole + ".00" + part);
                    break;
                case 3:
                    System.out.print("-" + whole + ".000" + part);
                    break;
                case 4:
                    System.out.print("-" + whole + ".0000" + part);
                    break;
            }

        } else {
            switch (counterOfZero) {
                case 0:
                    System.out.print(whole + "." + part);
                    break;
                case 1:
                    System.out.print(whole + ".0" + part);
                    break;
                case 2:
                    System.out.print(whole + ".00" + part);
                    break;
                case 3:
                    System.out.print(whole + ".000" + part);
                    break;
                case 4:
                    System.out.print(whole + ".0000" + part);
                    break;
            }
        }
    }
}

