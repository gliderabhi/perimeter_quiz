package tests;

import edu.duke.StorageResource;
import gene.multipleCodons;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenesTest {

    multipleCodons mc = new multipleCodons();

    @Test
    public void testStopCodon() {
        assertEquals(14, mc.findStopCodon("TTAGAATGGGGTTTTAAA", 5, "TAA") );
    }

    @Test
    public void testTGASTop() {
        assertEquals(16, mc.findStopCodon("GGGGTTTAAAATGGGGTGAATFGT", 10, "TGA") );
    }

    @Test
    public void testTAGSTop() {
        assertEquals(12, mc.findStopCodon("ATGGGGTGAATFTAGT", 0, "TAG") );
    }

    @Test                                                                         /*0123456789012345678901234*/
    public void testNoSTopCodon() {
        assertEquals(25, mc.findStopCodon("GGGGTTTAAAATGGGGTAAAATFGT", 10, "TGA") );
    }

    @Test
    public void testNoValidGene() {
        assertEquals(24, mc.findStopCodon("GGGGTTTAAAATGGGGAAAATFGT", 10, "TGA") );
    }

    @Test
    public void findGeneSimple1() {
        assertEquals("ATGGGGTAA" , mc.findGene("ATGGGGTAATFGT",0));
    }
    @Test
    public void findGeneSimple2() {
        assertEquals("ATGGGGTTATAG" , mc.findGene("ATGGGGTTATAGT",0));
    }

    @Test
    public void findGeneSimple3() {
        assertEquals("ATGTAG" , mc.findGene("ATGTAGTTATAGT",0));
    }

    @Test
    public void findGeneOne() {
        assertEquals("ATGATCGTATCGTAA", mc.findGene("TAAGATGATCGTATCGTAATAGGAT",0));
    }
    @Test
    public void findAllGenesSample1 () {
        List<String> genes = new ArrayList<>();
        genes.add("ATGGTAGGGTTTAAACCCATGTAA");
        genes.add("ATGGTAGGGTTTAAACCCATGTAG");
        genes.add("ATGGTAGGGTTTAAACCCATGTGA");
        String dna = "ACTGTAGCTA"+"ATGGTAGGGTTTAAACCCATGTAA"+"ACGTCTCA"+"ATGGTAGGGTTTAAACCCATGTAG"+"TTTAAAACCCCGGGG"+"ATGGTAGGGTTTAAACCCATGTGA";
        StorageResource storageResource = mc.findAllGenes(dna);
        int count =0;
        for(String a : storageResource.data()) {
            if(genes.contains(a)) count++;
        }
        assertEquals(3, count);
    }

}
