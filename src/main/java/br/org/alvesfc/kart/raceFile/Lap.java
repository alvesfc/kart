package br.org.alvesfc.kart.raceFile;

import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * Classe que representa o arquivo com os dados da volta.
 *
 * @author alvesfc
 * @version 1.0
 */
public class Lap {

    private Integer number;
    private LocalTime time;
    private BigDecimal averageSpeed;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(BigDecimal averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Lap lap = (Lap) o;

        return number != null ? number.equals(lap.number) : lap.number == null;
    }

    @Override public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override public String toString() {
        return "Lap{" +
                "number=" + number +
                ", time=" + time +
                ", averageSpeed=" + averageSpeed +
                '}';
    }
}
