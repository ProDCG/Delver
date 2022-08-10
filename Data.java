// Import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {
    MainChar[] saveSlots = new MainChar[3];
    int index;

    public Data() throws FileNotFoundException {
        Scanner fileParser = new Scanner(new File("data.txt"));
        while (fileParser.hasNextLine()) {
            String curLine = fileParser.nextLine();

            if (curLine.contains("slot")) {
                index = curLine.charAt(4);
            }

            // Ignore for now, not done yet
            int str = Integer.parseInt(fileParser.nextLine());
            int con = Integer.parseInt(fileParser.nextLine());
            int dex = Integer.parseInt(fileParser.nextLine());
            int wis = Integer.parseInt(fileParser.nextLine());
            int armorRank = Integer.parseInt(fileParser.nextLine());
            int weapRank = Integer.parseInt(fileParser.nextLine());
            int xp = Integer.parseInt(fileParser.nextLine());
            String inventoryLine = fileParser.nextLine();
            int amtOfItems = (int) inventoryLine.chars().filter(ch -> ch == ' ').count();
        }
    }
}
