package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


import java.util.concurrent.Callable;

@Command(name = "getDiff", mixinStandardHelpOptions = true, version = "getDiff 1.1",
        description = "Compares two configuration files and shows a difference.")

public class  App implements Callable<String> {

    @Parameters(index = "0", description = "path to first file")
    private static String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private static String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format: \"stylish\" or \"plain\" or \"json\" "
            + "[default: stylish]")
    private String format = "stylish";

    @Override
    public final String call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return "call's work!";
    }

    public static void main(String[] args) {
        var cmd = new CommandLine(new App());
        cmd.execute(args);
    }
}
