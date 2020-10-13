package baby.us_babynames;

public class BabyName {
   String name ;
   boolean boy;
   long noOfNames;

    public BabyName(String s, String s1, String s2) {
        this.name = s;
        if (s1.equals("F")) boy = false;
        else boy = true;
        noOfNames = Long.parseLong(s2);
    }

    @Override
    public String toString() {
        String val =  "BabyName{" +
                "name='" + name + '\'' +
                ", boy=" + boy +
                ", noOfNames=" + noOfNames +
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

    public boolean isBoy() {
        return boy;
    }

    public void setBoy(boolean boy) {
        this.boy = boy;
    }

    public long getNoOfNames() {
        return noOfNames;
    }

    public void setNoOfNames(long noOfNames) {
        this.noOfNames = noOfNames;
    }
}
