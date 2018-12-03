package br.org.alvesfc.kart.raceFile;

import java.time.LocalTime;

/**
 * Classe que representa o arquivo com os dados da corrida.
 *
 * @author alvesfc
 * @version 1.0
 */
public class KartFile  {

    private LocalTime hour;
    private Pilot pilot;
    private Lap lap;

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Lap getLap() {
        return lap;
    }

    public void setLap(Lap lap) {
        this.lap = lap;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        KartFile kartFile = (KartFile) o;

        if (hour != null ? !hour.equals(kartFile.hour) : kartFile.hour != null)
            return false;
        if (pilot != null ? !pilot.equals(kartFile.pilot) : kartFile.pilot != null)
            return false;
        return lap != null ? lap.equals(kartFile.lap) : kartFile.lap == null;
    }

    @Override public int hashCode() {
        int result = hour != null ? hour.hashCode() : 0;
        result = 31 * result + (pilot != null ? pilot.hashCode() : 0);
        result = 31 * result + (lap != null ? lap.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "KartFile{" +
                "hour=" + hour +
                ", pilot=" + pilot +
                ", lap=" + lap +
                '}';
    }
}
