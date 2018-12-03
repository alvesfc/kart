package br.org.alvesfc.kart;

import br.org.alvesfc.kart.raceFile.KartFile;
import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.List;

public class RaceExtractInfoTest {

    @Test
    public void shouldRetrieveAllDataFromFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("raceInfo.txt");

        List<KartFile> kartFiles = RaceExtractInfo.extract(resource.getFile());

        Assert.assertNotNull(kartFiles);
        Assert.assertEquals(23, kartFiles.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenFileNotFound() {
        RaceExtractInfo.extract("fileNotFound.txt");
    }
}