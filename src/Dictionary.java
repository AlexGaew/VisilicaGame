import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {


    public ArrayList<String> createDictionary() {
        ArrayList<String> list = new ArrayList<>();
//        String inputFileName = "E:\\Java\\Project\\Visilica\\src\\file.txt";
        File file = new File("src/file.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() == 6) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public String getRandomWord(ArrayList<String> list) {
        String randomWord;
        Random rand = new Random();
        randomWord = list.get(rand.nextInt(list.size()));
        return randomWord;
    }
}
