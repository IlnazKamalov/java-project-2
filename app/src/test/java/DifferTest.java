import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {

    private final String filepath1Json = ("src/test/resources/file1.json");
    private final String filepath2Json = ("src/test/resources/file2.json");
    private final String filepath1Yaml = ("src/test/resources/file1.yml");
    private final String filepath2Yaml = ("src/test/resources/file2.yml");

    @Test
    public void generateStylishTestJson() throws Exception {
        String actual = Differ.generate(filepath1Json, filepath2Json);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_JSON"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void generateTestStylishYAML() throws Exception {
        String actual = Differ.generate(filepath1Yaml, filepath2Yaml);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_YAML"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void generateTestJsonPlain() throws Exception {
        String filepath3Json = ("src/test/resources/file3.json");
        String filepath4Json = ("src/test/resources/file4.json");
        String actual = Differ.generate(filepath3Json, filepath4Json, "plain");
        String expected = Files.readString(Paths.get("src/test/resources/plain"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void generateTestYAMLPlain() throws Exception {
        String actual = Differ.generate(filepath1Yaml, filepath2Yaml, "plain");
        String expected = Files.readString(Paths.get("src/test/resources/YAML"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void generateTestJsonToJson() throws Exception {
        String actual = Differ.generate(filepath1Json, filepath2Json, "json");
        String expected = Files.readString(Paths.get("src/test/resources/json"));
        assertThat(actual).isEqualTo(expected);
    }
}
