package baby.us_babynames;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BabyNames {
    public static void main(String[] args) {
        questions();

    }

    public static void questions() {
        long totalRankSusan=0;
        long totalRankRobert=0;
        long count =0;
        long minRankGeneYear =Integer.MAX_VALUE;
        long minRankMichYear =Integer.MAX_VALUE;
        int minRankGene = Integer.MAX_VALUE;
        int minRankMich = Integer.MAX_VALUE;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            count++;
            String fileName = f.getName();
            System.out.println("Computations for year "+ fileName);
            List<List<BabyName>> listsValues = generateList(fr);
            List<BabyName> boys =  listsValues.get(0);
            List<BabyName> girls =  listsValues.get(1);
            //index of emily in 1960
            if(fileName.contains("1960")){
                System.out.println("Rank of emily in 1960 is " + getRank(girls,"Emily"));
            }

            //index of frank in 1971
            if(fileName.contains("1971")){
                System.out.println("Rank of Frank in 1971 is " + getRank(boys,"Frank"));
            }

            //name at girls rank 350 in 1980
            if(fileName.contains("1980")){
                System.out.println("Girls name at 350 in 1980 "+girls.get(349));
            }
            //name at girls rank 450 in 1982
            if(fileName.contains("1982")){
                System.out.println("Boys name at 450 in 1980 "+boys.get(449));
            }

            //name of susan on 1972 and use it for 2014
            int susanLoc=0;
            if(fileName.contains("1972")) {
                susanLoc = getRank(girls,"Susan");
                System.out.println("Susans rank in 1972 is " + susanLoc);
            }

            if(fileName.contains("2014")) {
                System.out.println("Girls name at "+ susanLoc+" in 2014 "+ girls.get(22));
            }

            //name of owen on 1974 and use it for 2014
            int owenLoc=0;
            if(fileName.contains("1974")) {
                owenLoc = getRank(boys,"Owen");
                System.out.println("Owen's rank in 1974 is " + owenLoc);
            }

            if(fileName.contains("2014")) {
                System.out.println("Boys name at "+ owenLoc+" in 2014 "+ boys.get(429));
            }

            //average rank of susan over all files
            int rankSusan = getRank(girls,"Susan");
            totalRankSusan += rankSusan;

            int rankRobert = getRank(boys, "Robert");
            totalRankRobert+=rankRobert;


            int year = Integer.parseInt(f.getName().substring(3,7));
            int rankGene = getRank(girls,"Genevieve");
            minRankGene = Math.min(rankGene,minRankGene);
            if(minRankGene == rankGene ) {
                if(minRankGeneYear>year)
                  minRankGeneYear = year;
            }
            System.out.println("curr rank " + rankGene + " and min rank genevieve " + minRankGene);

            int rankMich = getRank(boys,"Mich");
            minRankMich = Math.min(rankMich,minRankMich);
            if(minRankMich == rankMich){
                if(minRankMichYear>year)
                    minRankMichYear = year;
            }
            System.out.println("curr rank mich " +rankMich +" min rank mich "+ minRankMich);

            //total no of girls above emily n 1990
            if(fileName.contains("1990")) {
                long totalNoOfGirls=0;
                for(BabyName bs : girls) {
                    if(bs.getName().equals("Emily")) break;
                    totalNoOfGirls+=bs.getNoOfNames();
                }
                System.out.println("Total no of girls before emily in 1990 "+ totalNoOfGirls);
            }

            //total no of girls above Drew n 1990
            if(fileName.contains("1990")) {
                long totalNoOfGirls=0;
                for(BabyName bs : boys) {
                    if(bs.getName().equals("Drew")) break;
                    totalNoOfGirls+=bs.getNoOfNames();
                }
                System.out.println("Total no of boys before Drew in 1990 "+ totalNoOfGirls);
            }

            System.out.println();
            System.out.println();
            System.out.println();

        }

        System.out.println("Average of Susan is " + 1.0*totalRankSusan/count);
        System.out.println("Average of Robert is " + 1.0*totalRankRobert/count);

        System.out.println("Min rank year of Mitch is " + minRankMichYear);
        System.out.println("Min rank year of Genevieve is " + minRankGeneYear);

    }


    private static int getRank(List<BabyName> sampleData, String name) {
        for(BabyName bs : sampleData) {
            if(bs.getName().equals(name)) return sampleData.indexOf(bs);
        }
        return Integer.MAX_VALUE;
    }

    public static List<List<BabyName>> generateList(FileResource fr) {
        List<BabyName> boyName = new ArrayList<>();
        List<BabyName> girlsName = new ArrayList<>();
        long boysCount =0;
        long girlsCount=0;
            CSVParser csvRecords = fr.getCSVParser();
            for(CSVRecord record : csvRecords) {
                BabyName babyName = new BabyName(record.get(0), record.get(1), record.get(2));
                //babyName.toString();
                if (babyName.isBoy()) {
                    boysCount += babyName.getNoOfNames();
                    boyName.add(babyName);
                } else {
                    girlsCount += babyName.getNoOfNames();
                    girlsName.add(babyName);
                }
            }

            System.out.println("Boys " + boysCount + " girls "+ girlsCount);

        List<List<BabyName>> total = new ArrayList<>();
        total.add(boyName);
        total.add(girlsName);
        return total;
    }
}
