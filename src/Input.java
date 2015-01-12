import java.util.Scanner;

/**
 * Gets user input
 */
public class Input {

    /**
     * Returns the text entered by the user
     * @return the text entered
     */
    public static String getNewString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Asks a question to the user and returns text answer
     * @param message the question
     * @return the answer
     */
    public static String question(String message) {
        System.out.println(message);
        return getNewString();
    }

    /**
     * Asks a true false question that can be answered with "yes" and "no"
     * @param message the question
     * @return the true / false answer
     */
    public static String multipleChoiceQuestion(String message, String[] possibleAnswers) {
        // a list of possible answers to give the user, compiled into a readable form
        String listAnswers = "";
        for (String possibleAnswer : possibleAnswers) {
            listAnswers += possibleAnswer + "/";
        }

        // adds the possible answers in a readable form to the message, prints, and obtains the answer
        message += " (" + listAnswers + ")";
        String str = question(message);

        // if the answer equals a possible answer, it returns the answer
        for (String possibleAnswer : possibleAnswers) {
            if (str.equals(possibleAnswer)) {
                return possibleAnswer;
            }
        }

        // if the answer does not equal a possible answer, it asks the user to print of the possible answers
        System.out.println("Please enter " + listAnswers);
        System.out.println();

        //recursively calls itself, which it will do until it gets one of the possible answers
        return multipleChoiceQuestion(message, possibleAnswers);
    }

    /**
     * Asks a true false question
     * @param message the message to be asked
     * @return the true false answer
     */
    public static boolean trueFalse(String message) {
        // calls the multiple choice question with possible answers being yes and no
        String answer = multipleChoiceQuestion(message, new String[] {"yes", "no"});

        // returns true if the answer is yes
        return answer.equals("yes");
    }
}
