package gene;

public class PArt1 {
    public static void main(String[] args) {
        PArt1 pArt1 = new PArt1();
        pArt1.testSimpleGenes();
    }
    public  String findSimpleGene(String dna, String startCodon, String stopCodon) {
        boolean upperOrLower = Character.isUpperCase(dna.charAt(0));
        if (upperOrLower) {
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        } else {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        dna = dna.toUpperCase();
        int start = dna.indexOf(startCodon);
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf(stopCodon, start+3);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }


    public void testSimpleGenes() {
        String a = "cccatggggtttaaataataataggagagagagagagagttt";
        String ap = "atggggtttaaataataatag";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG";
        //String ap = "ATGCCCTAG";
        String result = findSimpleGene(a, "ATG", "TAA");
        if (ap.equals(result)) {
            System.out.println("success for " + ap + " length " + ap.length());
        }
        else {
            System.out.println("mistake for input: " + a);
            System.out.println("got: " + result);
            System.out.println("not: " + ap);
        }
    }
}
