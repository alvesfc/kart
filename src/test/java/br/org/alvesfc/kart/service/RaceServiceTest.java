package br.org.alvesfc.kart.service;

import br.org.alvesfc.kart.raceFile.Pilot;
import br.org.alvesfc.kart.raceResult.RaceResult;
import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class RaceServiceTest {

    @Test
    public void shouldReturnSortedListByFasterPilot() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("raceResults.txt");

        RaceService raceService = new RaceService(resource.getFile());

        Pilot expected = new Pilot();
        expected.setName("F.MASSA");
        expected.setId(38);

        List<RaceResult> results = raceService.getRaceResult();

        Assert.assertNotNull(results);
        Assert.assertEquals(true, results.size() > 0);
        Assert.assertEquals(expected, results.get(0).getPilot());

    }

    @Test
    public void shouldReturnResultAsString() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("raceResults.txt");

        RaceService raceService = new RaceService(resource.getFile());

        String expected =
                "Posição Chegada          Código Piloto            Nome Piloto              Qtde Voltas Completadas  Tempo Total de Prova     \n"
                        + "1                        38                       F.MASSA                  4                        00:04:11.578             \n"
                        + "2                        2                        K.RAIKKONEN              4                        00:04:15.153             \n"
                        + "3                        23                       M.WEBBER                 4                        00:04:17.722             \n"
                        + "4                        15                       F.ALONSO                 4                        00:04:54.221             \n"
                        + "5                        33                       R.BARRICHELLO            3                        00:03:12.070             \n"
                        + "6                        11                       S.VETTEL                 3                        00:06:27.276             \n";

        Assert.assertEquals(expected, raceService.getResultAsString());
    }
}