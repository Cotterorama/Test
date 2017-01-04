public class Student {
    private final String name, major;
    private double GPA, totalCredits, qualityPoints;
    
    public Student(){
        this.name = "Default";
        this.major = "General";
        this.GPA = 4.0;
    }
    
    public Student(String nm, String mjr){
        this.name = nm;
        this.major = mjr;
        this.GPA = 4.0;
    }
    
    public void courseCompleted(String grade, String credits){
        switch (grade) {
            case "A":
                totalCredits += Double.parseDouble(credits);
                qualityPoints += 4.0 * Double.parseDouble(credits);
                GPA = qualityPoints / totalCredits;
                break;
            case "B":
                totalCredits += Double.parseDouble(credits);
                qualityPoints += 3.0 * Double.parseDouble(credits);
                GPA = qualityPoints / totalCredits;
                break;
            case "C":
                totalCredits += Double.parseDouble(credits);
                qualityPoints += 2.0 * Double.parseDouble(credits);
                GPA = qualityPoints / totalCredits;
                break;
            case "D":
                totalCredits += Double.parseDouble(credits);
                qualityPoints += 1.0 * Double.parseDouble(credits);
                GPA = qualityPoints / totalCredits;
                break;
            default:
                totalCredits += Double.parseDouble(credits);
                qualityPoints += 0.0 * Double.parseDouble(credits);
                GPA = qualityPoints / totalCredits;
                break;
        }
    }
    
    @Override
    public String toString(){
        return "Name: "+ name +"  Major: " + major + " GPA " + GPA;
    }
}//END OF CLASS
