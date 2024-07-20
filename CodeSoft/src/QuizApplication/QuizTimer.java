package QuizApplication;

public class QuizTimer extends Thread {
    private boolean timeUp;
    private int seconds;

    public QuizTimer(int seconds) {
        this.seconds = seconds;
        this.timeUp = false;
    }

    public boolean isTimeUp() {
        return timeUp;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(seconds * 1000);
            timeUp = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
