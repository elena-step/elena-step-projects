package javasummer2017.FractionWithEncapsulation;

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
        if (part >= -32768 && part <= 32767) {
            this.part = (short) part;
        } else {
            part = DEFAULT_PART;
        }
    }


    public boolean isNegativeNumberFromZeroToOne() {
        return negativeNumberFromZeroToOne;
    }

    public void setNegativeNumberFromZeroToOne(boolean negativeNumberFromZeroToOne) {
        this.negativeNumberFromZeroToOne = negativeNumberFromZeroToOne;
    }


}
