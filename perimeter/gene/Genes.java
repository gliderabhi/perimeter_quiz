package gene;

public class Genes implements Comparable<Genes> {
    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
        this.length = gene.length();
        calculateGcRatio();
    }

    private void calculateGcRatio() {
        double c =0;
        double g= 0;
        for (char a : gene.toCharArray()) {
            if (a == 'C') c++;
            if (a == 'G') g++;
        }
        this.gcRation = (c+g)*1.0/length *100;
    }
    public int getLength() {
        return length;
    }


    public double getGcRation() {
        return gcRation;
    }


    String gene;
    int length;
    double gcRation;

    public int compareLength(Genes genes) {
        return  - this.length + genes.length;
    }

    public int compareGCRatio(Genes genes) {
        return Double.compare(genes.gcRation, this.gcRation);
    }

    @Override
    public int compareTo(Genes o) {
        return compareLength(o);
    }
}
