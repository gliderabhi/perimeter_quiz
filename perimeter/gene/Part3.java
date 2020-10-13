package gene;

public class Part3 {

    public static void main(String[] args) {
        Part3 p = new Part3();
        p.testing();
    }
    public boolean twoOccurences(String dna , String check) {
        int count = 0;
        int start = dna.indexOf(check);
        if (start == -1) return false;
        count ++;
        dna = dna.substring(start+1);
        start = dna.indexOf(check);
        if (start == -1) return false;
        return true;
    }

    public String lastPart(String a , String b) {
        int index = a.indexOf(b);
        if(index == -1) return a;
        return a.substring(index+b.length());
    }
    public void testing () {
        String v = "A story by Abbs Long";
        System.out.println(twoOccurences(v, "by"));
        String vs = "Banana";
        System.out.println(twoOccurences(vs, "a"));

        System.out.println(lastPart("bananana", "an"));
    }
}
