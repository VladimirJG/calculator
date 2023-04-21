package calculator_programm;

public enum RomanNumerals {
    I(1), II(2), III(3), IV(4),
    V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
private int intNumber;
    RomanNumerals(int intNumber){
        this.intNumber = intNumber;
    }

    public int getIntNumber() {
        return intNumber;
    }
}
