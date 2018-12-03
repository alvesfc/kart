package br.org.alvesfc.kart.raceResult;

import br.org.alvesfc.kart.raceFile.Pilot;

/**
 * Classe que respresenta o resultado da corrida
 *
 * @author alvesfc
 * @version 1.0
 */
public class RaceResult {

    private Pilot pilot;
    private Durartion durartion;

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Durartion getDurartion() {
        return durartion;
    }

    public void setDurartion(Durartion durartion) {
        this.durartion = durartion;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RaceResult that = (RaceResult) o;

        if (pilot != null ? !pilot.equals(that.pilot) : that.pilot != null)
            return false;
        return durartion != null ? durartion.equals(that.durartion) : that.durartion == null;
    }

    @Override public int hashCode() {
        int result = pilot != null ? pilot.hashCode() : 0;
        result = 31 * result + (durartion != null ? durartion.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "RaceResult{" +
                "pilot=" + pilot +
                ", durartion=" + durartion +
                '}';
    }

}
