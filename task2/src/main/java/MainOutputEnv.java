import org.apache.maven.project.MavenProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.getenv;

public class MainOutputEnv {
    public static void main(String args[]) throws IOException {

        ProcessBuilder   ps=new ProcessBuilder("cmd.exe","/C", "C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2018.2.4\\plugins\\maven\\lib\\maven3\\bin\\mvn", "-f", "pom.xml", "surefire:test"  );

//From the DOC:  Initially, this property is false, meaning that the
//standard output and error output of a subprocess are sent to two
//separate streams
        ps.redirectErrorStream(true);

        Process pr = ps.start();
        System.out.println( ps.environment() );

        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println("ok!");
        System.out.println( ps.environment() );

        in.close();
        System.exit(0);

    }
    }

