package activity;

public class PassFailActivity extends GradedActivity {
    
    private double minimumPassingScore;

    public PassFailActivity(double min) {
        this.minimumPassingScore = min;
    }

    @Override
    public char getGrade() {

        if (super.getScore() >= this.minimumPassingScore) {
            return 'L';
        } else {
            return 'R';
        }
        
    }
}
