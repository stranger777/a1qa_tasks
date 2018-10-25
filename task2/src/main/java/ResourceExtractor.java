import java.io.IOException;
import java.io.InputStream;
import javax.json.*;

public class ResourceExtractor {

    public ResourceExtractor() {}

    public static String getJsonStringFromFileByStringName(String JsonFilename, String jsonStringName) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try(InputStream is = classloader.getResourceAsStream(JsonFilename)){
            JsonReader jsr = Json.createReader(is);
            JsonObject jsonObject = jsr.readObject();
            //
            String quotedString = jsonObject.getJsonString(jsonStringName).toString();
            String unquotedString = quotedString.substring(1, quotedString.length() - 2);
            return unquotedString;
        }
    }
}
