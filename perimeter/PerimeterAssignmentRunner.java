
import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        double largestSide = Double.MIN_VALUE;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if(Double.compare(largestSide,currDist) < 0) {
                largestSide = currDist;
            }
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer

        System.out.println(largestSide);
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for(Point p : s.getPoints()) {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        int count = getNumPoints(s);
        double perimeter = getPerimeter(s);
        double avg = perimeter/count;
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double sideLength = 0;
        for(Point p : s.getPoints() ) {

        }

        return 0.0;
    }

    public double getLargestX(Shape s) {
        // Put code here
        int maxX = Integer.MIN_VALUE;
        for(Point p : s.getPoints()) {
            if(maxX < p.getX())
                maxX = p.getX();
        }
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double maxPer = 0;
        String maxPerName = "";
        DirectoryResource dr = new DirectoryResource();
        for( File f : dr.selectedFiles()) {
           FileResource fr = new FileResource(f);
           Shape s = new Shape(fr);
           double currPeri = getPerimeter(s);
           if(currPeri > maxPer) {
               maxPer = currPeri;
               maxPerName = f.getName();
           }
        }   // replace this code
        return maxPerName;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double avg = getAverageLength(s);
        System.out.println("perimeter = " + length  + " " + avg);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        for(int i =0;i<6;i++)
          pr.testPerimeter();
        //pr.getFileWithLargestPerimeter();

    }
}
