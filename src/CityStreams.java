import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityStreams {

    public static void main(String[] args) throws IOException {

        // Read file into array list, as shown in demonstration video by Dr. Baarsch

        String contents = Files.readString(Path.of("src\\world-cities.csv"), StandardCharsets.UTF_8);
        Scanner sc = new Scanner(contents);
        ArrayList<String> data = new ArrayList<>();
        sc.nextLine();

        while (sc.hasNextLine())
            data.add(sc.nextLine().split(",")[0]);
        sc.close();

        // Stream to filter by B, map to uppercase, and sort
        List<String> filter_B = data.stream()
                .filter(city->city.startsWith("B"))
                .sorted()
                .map(String::toUpperCase)
                .toList();

        // Print
        System.out.println("Sorted Cities starting with 'B':");

        for (String f : filter_B)
            System.out.println(f);

    }

}
