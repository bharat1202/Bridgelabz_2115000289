public class CsvToJsonConverter import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            // Create CsvMapper and ObjectMapper
            CsvMapper csvMapper = new CsvMapper();
            ObjectMapper jsonMapper = new ObjectMapper();

            // Define CSV schema (auto-detect headers)
            CsvSchema schema = CsvSchema.emptySchema().withHeader();

            // Read CSV file into a List of Maps
            MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new File("data.csv"));

            List<Map<String, String>> csvData = it.readAll();

            // Convert CSV data to JSON
            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);

            // Print JSON output
            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
{
}
