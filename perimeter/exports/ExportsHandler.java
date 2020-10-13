package exports;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

public class ExportsHandler {
    public static void main(String[] args) {
        FileResource fr = new FileResource();
        CSVParser csvParser = fr.getCSVParser();
        int countGold =0;
        List<Exports> allVals = new ArrayList<>();
        for (CSVRecord records : csvParser) {
            Exports exports = new Exports(records.get("Country"), records.get("Exports"),records.get("Value (dollars)"));
            if(records.get("Exports").contains("cotton") && records.get("Exports").contains("flowers") ) exports.toString();
           /* if(records.get("Exports").contains("cocoa") ) countGold++;
           */ //if(records.get("Country").contains("Nauru")) exports.toString();
            //exports.toString();
            /*double val = getValueInDouble(records.get("Value (dollars)"));
            if (val > 999999999999.0) exports.toString();*/
            allVals.add(exports);
        }

        System.out.println("Gold wale country " + countGold);
    }

    private static double getValueInDouble(String s) {
        String value = "";
        for(int i =0;i<s.length();i++) {
           if (Character.isDigit(s.charAt(i)))
               value += s.charAt(i);
        }
        return Double.parseDouble(value);
    }

    static class Exports {
        String name ;
        String exports ;
        String value;

        public Exports(String name, String exports, String value) {
            this.name = name;
            this.exports = exports;
            this.value = value;
        }

        @Override
        public String  toString() {
            String val =  "Exports{" +
                    "name='" + name + '\'' +
                    ", exports='" + exports + '\'' +
                    ", value='" + value + '\'' +
                    '}';

            System.out.println(val);
            return val;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExports() {
            return exports;
        }

        public void setExports(String exports) {
            this.exports = exports;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
