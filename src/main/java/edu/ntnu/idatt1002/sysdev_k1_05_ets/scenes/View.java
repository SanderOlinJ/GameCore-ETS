package edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes;

public enum View {
    START("start-screen.fxml"),
    MAIN("main-page.fxml"),
    ABOUT("about-page.fxml"),
    ADD_TEAM("add-team-scene.fxml"),
    CREATE_NEW_TOURNAMENT("create-new-tournament-page.fxml"),
    HELP("help-page.fxml"),
    BRACKET_4("overview-scene-four.fxml"),
    BRACKET_8("overview-scene-eight.fxml"),
    BRACKET_16("overview-scene-sixteen.fxml"),
    SET_TIME("set-time-scene.fxml"),
    MATCHES("matches-scene.fxml"),
    RESULTS("results-scene.fxml"),
    PREVIOUS_OVERVIEW("previous-overview.fxml"),
    ONGOING_OVERVIEW("ongoing-overview.fxml"),
    UPCOMING_OVERVIEW("upcoming-overview.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
