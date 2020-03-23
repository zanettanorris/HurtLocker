import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
public static class Food {
    private String productName;
    private Double price;
    private String itemType;
    private String expirationDate;

    public Food(String productName, String price, String itemType, String expirationDate) {
    }
}

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
    }

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }


    public String[] parseItemList(String valueToParse) {
        return itemList(valueToParse);
    }

    public static String[] itemSplitter(String dataString) {
        return dataString.split("##");
    }


    public static Food itemSeparator(String input) {
        String pattern = "";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        String productName = "";
        String price = "";
        String itemType = "";
        String expirationDate = "";
        // (name block) (\\w+)([:;@%*^!])(\\w+)(not sure here)
        // (price block) (\\w+)([:;@%*^!])(\\d+\\.) (again not sure)
        // (type) (\\w+)([:;@%*^!])(\\w+)(not sure here)
        // (expiration) (\\w+) ([:;@%*^!]) (\\d{1,2}\\d{1,2}\\d{4}
        return new Food(productName, price, itemType, expirationDate);
    }



    public static String[] itemList(String input) {
        List<Food> itemList = new ArrayList<>();
        String[] output = itemSplitter(input);
        for (String s : output);
        return output;
    }
}