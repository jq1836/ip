package duke.chatbot;

import javafx.application.Application;

/**
 * A launcher class to workaround classpath issues.
 * @author Jordan Quah Shao Xuan
 */
public class Launcher {
    public static void main(String[] args) {
        Application.launch(Test.class, args);
    }
}
