package activity;

public class PassFailExam extends PassFailActivity{
    
    private int numberOfQuestions;
    private int numberMissed;
    private double pointsPerQuestion = 10;

    public PassFailExam(int questions, int missed, double minPassing) {
        super(minPassing);
        this.numberOfQuestions = questions;
        this.numberMissed = missed;

        super.setScore((questions-numberMissed)*pointsPerQuestion);
    }

    public double getPointsEach() {
        return this.pointsPerQuestion;
    }

    public int getNumMissed() {
        return this.numberMissed;
    }
}
