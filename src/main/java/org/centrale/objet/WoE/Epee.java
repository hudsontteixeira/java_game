package org.centrale.objet.WoE;

public class Epee extends Objet{
    private int ptdegat;

    public Epee(Point2D pos, int ptdegat) {
        super(pos);
        this.ptdegat = ptdegat;
    }

    public Epee(Epee epee) {
        super(epee);

    }

    public int getPtdegat() {
        return ptdegat;
    }

    public void setPtdegat(int ptdegat) {
        this.ptdegat = ptdegat;
    }
}
