package activity;

import activity.*;

public class Main {
    public static void main(String[] args) {
        
        FinalExam final_exam = new FinalExam(10, 2);

        System.out.println("FINAL EXAM");
        System.out.println("Missed : " + final_exam.getNumberMissed());
        System.out.println("Score : " + final_exam.getScore());
        System.out.println("Grade : " + final_exam.getGrade());


        PassFailExam pass_fail_exam = new PassFailExam(5, 0, 40);

        System.out.println("PASS FAIL EXAM");
        System.out.println("Missed : " + pass_fail_exam.getNumMissed());
        System.out.println("Score : " + pass_fail_exam.getScore());
        System.out.println("Grade : " + pass_fail_exam.getGrade());

    }
}
