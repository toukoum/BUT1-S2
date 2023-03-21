package TP5.tableDOperation;

public class Soustraction extends Operation {
    public Soustraction(double terme1, double terme2) {
        super(terme1, terme2);

    }


    @Override
    public double calculResultat() {
        return super.getTerme1() - super.getTerme2();
    }

    @Override
    public String toString() {
        return super.getTerme1() + " - " + super.getTerme2() + " = ";
    }

}
