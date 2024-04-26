package activity;

public class GradedActivity {
    
    private double score;
    private String name;

    public GradedActivity() {}

    public GradedActivity(String n) {
        this.name = n;
    }

    public void setScore(double s) {
        this.score = s;
    }

    public double getScore() {
        return(this.score);
    }

    public char getGrade() {
        char grade;

        if (this.score >= 85) {
            grade = 'A';
        } else if (this.score >=75) {
            grade = 'B';
        } else {
            grade = 'C';
        }

        return grade;
    }

}
