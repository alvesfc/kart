package br.org.alvesfc.kart.raceResult;

import java.time.LocalTime;

/**
 * Classe que representa a duração da corrida.
 *
 * @author alvesfc
 * @version 1.0
 */
public class Durartion implements Comparable<Durartion> {

    private Integer laps;
    private LocalTime totalTime;

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public LocalTime getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(LocalTime totalTime) {
        this.totalTime = totalTime;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Durartion durartion = (Durartion) o;

        if (laps != null ? !laps.equals(durartion.laps) : durartion.laps != null)
            return false;
        return totalTime != null ? totalTime.equals(durartion.totalTime) : durartion.totalTime == null;
    }

    @Override public int hashCode() {
        int result = laps != null ? laps.hashCode() : 0;
        result = 31 * result + (totalTime != null ? totalTime.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "Durartion{" +
                "laps=" + laps +
                ", totalTime=" + totalTime +
                '}';
    }

    @Override public int compareTo(Durartion o) {
        return this.getTotalTime().compareTo(o.getTotalTime());
    }
}
