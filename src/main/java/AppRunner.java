import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: yli1
 * Date: 5/16/2020
 * Time: 10:19 PM
 */
public class AppRunner {



    public static void main(String[] args) throws IOException {

        String receipt;
        File file = new File(args[0]);
        try (InputStream is = new FileInputStream(file)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    line = line.indexOf("\\n") > 0 ? line.substring(0, line.indexOf("\\n")) : line;
                    builder.append(new TaxiItinerary(line).charge()).append("\\n");
                }

                receipt = builder.toString();
            }
        }

    }
}
