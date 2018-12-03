package br.org.alvesfc.kart.service;

import br.org.alvesfc.kart.RaceExtractInfo;
import br.org.alvesfc.kart.raceFile.KartFile;
import br.org.alvesfc.kart.raceFile.Pilot;
import br.org.alvesfc.kart.raceResult.Durartion;
import br.org.alvesfc.kart.raceResult.RaceResult;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Classe responsável por ordenar a lista e realizar os cálculos dod dados da corrida.
 *
 * @author alvesfc
 * @version 1.0
 */
public class RaceService {

    private static final int SPACES = 25;

    private final String file;

    public RaceService(String file) {
        this.file = file;
    }

    public List<RaceResult> getRaceResult() {
        List<RaceResult> raceResultList = new ArrayList<>();

        List<KartFile> kartFiles = RaceExtractInfo.extract(file);

        List<List<RaceResult>> collect = kartFiles
                .stream()
                //Agrupa os dados por Piloto
                .collect(Collectors.groupingBy(KartFile::getPilot, Collectors.toSet()))
                .entrySet()
                .stream()
                .map(this::buildRaceResult)
                //Ordena a lista pelo Duração da corrida
                .sorted(Comparator.comparing(RaceResult::getDurartion))
                .collect(Collectors.groupingBy(o -> o.getDurartion().getLaps()))
                .entrySet()
                .stream()
                //Ordena o Map pela quantidade de voltas
                .sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        collect.stream().forEach(raceResults -> raceResultList.addAll(raceResults));

        return raceResultList;
    }

    public String getResultAsString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Posição Chegada          ");
        sb.append("Código Piloto            ");
        sb.append("Nome Piloto              ");
        sb.append("Qtde Voltas Completadas  ");
        sb.append("Tempo Total de Prova     ");
        sb.append("\n");

        List<RaceResult> raceResult = getRaceResult();

        int index = 1;
        for (RaceResult result : raceResult) {
            sb.append(padRight(String.valueOf(index++), SPACES));
            sb.append(padRight(String.valueOf(result.getPilot().getId()), SPACES));
            sb.append(padRight(result.getPilot().getName(), SPACES));
            sb.append(padRight(String.valueOf(result.getDurartion().getLaps()), SPACES));
            sb.append(padRight(String.valueOf(result.getDurartion().getTotalTime()), SPACES));
            sb.append("\n");

        }

        return sb.toString();

    }

    /**
     * Método responsável por criar o objeto {@link RaceResult} com os dados da Corrida
     *
     * @param pilotSetEntry - Objeto contendo os dados da corrida.
     * @return - Objeto com o resultado da corrida.
     */
    private RaceResult buildRaceResult(Map.Entry<Pilot, Set<KartFile>> pilotSetEntry) {
        RaceResult raceResult = new RaceResult();
        Durartion durartion = new Durartion();
        durartion.setLaps(pilotSetEntry.getValue().size());
        durartion.setTotalTime(getTotalTime(pilotSetEntry.getValue()));
        raceResult.setPilot(pilotSetEntry.getKey());
        raceResult.setDurartion(durartion);
        return raceResult;
    }

    /**
     * Método que realiza o cálculo do tempo total da corrida.
     *
     * @param kartFiles - Objeto com os dados da corrida.
     * @return - Tempo total da corrida.
     */
    public LocalTime getTotalTime(final Set<KartFile> kartFiles) {
        return kartFiles.stream().map(k -> k.getLap().getTime())
                .reduce((x, y) -> x.plusHours(y.getHour()).plusMinutes(y.getMinute()).plusSeconds(y.getSecond())
                        .plusNanos(y.getNano())).orElse(LocalTime.of(0, 0, 0, 0));

    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

}
