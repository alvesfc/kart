package br.org.alvesfc.kart;

import br.org.alvesfc.kart.raceFile.KartFile;
import br.org.alvesfc.kart.raceFile.Lap;
import br.org.alvesfc.kart.raceFile.Pilot;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por extrair os dados do arquivo
 *
 * @author alvesfc
 * @version 1.0
 */
public class RaceExtractInfo {

    private static final String SPACE = "\\s+";

    public static List<KartFile> extract(final String fileName) {

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {

            return bufferedReader.lines()
                    .skip(1)
                    .map(line -> line.split(SPACE))
                    .map(RaceExtractInfo::buildKartFile)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("An error occurred while trying to read the file (%s)", fileName), e);
        }
    }

    private static KartFile buildKartFile(String[] values) {
        KartFile info = new KartFile();
        info.setHour(LocalTime.parse(values[0]));

        Pilot pilot = new Pilot();
        pilot.setId(Integer.valueOf(values[1]));
        pilot.setName(values[3]);
        info.setPilot(pilot);
        Lap lap = new Lap();
        lap.setNumber(Integer.valueOf(values[4]));
        lap.setTime(LocalTime.parse("00:0" + values[5]));
        lap.setAverageSpeed(new BigDecimal(values[6].replace(",", ".")));
        info.setLap(lap);
        return info;
    }
}
