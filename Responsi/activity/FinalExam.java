package activity;

public class FinalExam extends GradedActivity{
    private int numberOfQuestions;
    private int numberMissed;
    private double pointsPerQuestion = 10;

    public FinalExam(int questions, int missed) {
        
        this.numberOfQuestions = questions;
        this.numberMissed = missed;

        super.setScore((this.numberOfQuestions-this.numberMissed)*this.pointsPerQuestion);
    }

    public double getPointsPerQuestion() {
        return this.pointsPerQuestion;
    }

    public int getNumberMissed() {
        return this.numberMissed;
    }
}
