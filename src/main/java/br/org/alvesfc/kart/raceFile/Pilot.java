package br.org.alvesfc.kart.raceFile;


/**
 * Classe que representa o arquivo com os dados do piloto.
 *
 * @author alvesfc
 * @version 1.0
 */
public class Pilot {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Pilot pilot = (Pilot) o;

        return id != null ? id.equals(pilot.id) : pilot.id == null;
    }

    @Override public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override public String toString() {
        return "Pilot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
