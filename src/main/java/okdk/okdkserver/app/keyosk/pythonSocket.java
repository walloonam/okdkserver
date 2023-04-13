package okdk.okdkserver.app.keyosk;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class pythonSocket {
    private String resolvePythonScriptPath(String path){
        File file = new File(path);
        return file.getAbsolutePath();
    }
    private List<String> readProcessOutput(InputStream inputStream) throws IOException {
        try (BufferedReader output = new BufferedReader(new InputStreamReader(inputStream))) {
            return output.lines()
                    .collect(Collectors.toList());
        }
    }
    public List<String> givenPythonScript_whenPythonProcessInvoked_thenSuccess() throws IOException, InterruptedException{

        ProcessBuilder processBuilder = new ProcessBuilder("python", "C:\\Users\\user\\Desktop\\devlant\\hello.py", "test");
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        List<String> results = readProcessOutput(process.getInputStream());

        return results;

    }

public class pythonSocket {
    ProcessBuilder processBuilder = new ProcessBuilder("python", "C:\\Users\\user\\Desktop\\devlant\\hello.py", "test");
        processBuilder.redirectErrorStream(true);

    Process process = processBuilder.start();
    List<String> results = readProcessOutput(process.getInputStream());

        process.waitFor();

        System.out.println("results = " + results);
}
