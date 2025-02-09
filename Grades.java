import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
// import com.opencsv.CSVWriter;
import java.io.FileWriter;
public class Grades {
    
    private String data;
    public Grades(String data) {
        this.data = data;
    }
    public HashMap<String, ArrayList<String>> retrive() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String csvFile = "data.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (isFirstLine) {
                    isFirstLine = false;
                } else {
                    map.put(columns[0], new ArrayList<>(Arrays.asList(columns[1], columns[2])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    // public void addData(String name, String grade, String description) {
        
    // }


    public void printAll() {
        HashMap<String, ArrayList<String>> map = this.retrive();

        for (String key : map.keySet()) {
            System.out.println("<" + key + "-" + map.get(key).get(0) + ":" + map.get(key).get(1) + ">");
        }
    }
    
}