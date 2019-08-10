package javasummer2017.FractionsWithEncapsulation;

public class FractionC {

    private static final short DEFAULT_PART = 0;
    private static final boolean DEFAULT_NEGATIVE_NUMBER = false;

    private boolean negativeNumber;
    private long whole;
    private short part;
    private int counterOfZero;

    FractionC() {
        this(DEFAULT_NEGATIVE_NUMBER, 0, 0, 0);
    }

    FractionC(long whole, int part) {
        this(DEFAULT_NEGATIVE_NUMBER, whole, part, 0);
    }

    FractionC(long whole, int part, int counter) {
        this(DEFAULT_NEGATIVE_NUMBER, whole, part, counter);
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
            } while (temp >= 10000);
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
        StringBuilder sb = new StringBuilder();
        if (isNegativeNumber()) {
            sb.append("-");
        }
        sb.append(whole);
        sb.append(".");
        if (counterOfZero > 0 && part != 0) {
            for (int i = 0; i < counterOfZero; i++) {
                sb.append("0");
            }
        }
        sb.append(part);
        System.out.print(sb.toString());

    }

}

