package javasummer2017.FractionsWithEncapsul;

public class FractionC {

    private static final short DEFAULT_PART = 0;
    private static final boolean DEFAULT_NEGATIVE_FROM_ZERO_TO_ONE = false;


    private long whole;
    private short part;
    private boolean negativeNumberFromZeroToOne;


    FractionC() {
        this.whole = 0;
        this.part = 0;
        this.negativeNumberFromZeroToOne = DEFAULT_NEGATIVE_FROM_ZERO_TO_ONE;
    }

    FractionC(long whole, int part) {
        setWhole(whole);
        setPart(part);
        this.negativeNumberFromZeroToOne = DEFAULT_NEGATIVE_FROM_ZERO_TO_ONE;
    }

    FractionC(long whole, int part, boolean negativeNumberFromZeroToOne) {
        setWhole(whole);
        setPart(part);
        setNegativeNumberFromZeroToOne(negativeNumberFromZeroToOne);
    }


    public long getWhole() {
        return whole;
    }

    public void setWhole(long whole) {
        this.whole = whole;
    }


    public short getPart() {
        return part;
    }


    public void setPart(int part) {
        if (part >= 1 && part <= 32767) {
            this.part = (short) part;
        } else if (part > 32767) {
            int temp = part;
            do {
                temp /= 10;
            } while (temp > 32767);
            this.part = (short) temp;
        } else if (part == 0) {
            this.part = DEFAULT_PART;
        } else {
            System.err.println("The value of part is not correct.");
            System.out.println(("The value of part for this case will be zero." ));
            this.part = DEFAULT_PART;
        }
    }

    public boolean isNegativeNumberFromZeroToOne() {
        return negativeNumberFromZeroToOne;
    }

    public void setNegativeNumberFromZeroToOne(boolean negativeNumberFromZeroToOne) {
        this.negativeNumberFromZeroToOne = negativeNumberFromZeroToOne;
    }

    void printFraction() {
        System.out.print(whole + "." + part);
    }
}
