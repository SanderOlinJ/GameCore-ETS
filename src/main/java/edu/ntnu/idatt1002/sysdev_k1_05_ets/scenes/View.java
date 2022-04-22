package edu.ntnu.idatt1002.sysdev_k1_05_ets.scenes;

public enum View {
    START("start-screen.fxml"),
    MAIN("main-page.fxml"),
    ABOUT("about-page.fxml"),
    ADD_TEAM("add-team-scene.fxml"),
    CREATE_NEW_TOURNAMENT("create-new-tournament-page.fxml"),
    HELP("help-page.fxml"),
    TOURNAMENT_OVERVIEW_4("overview-scene-four.fxml"),
    TOURNAMENT_OVERVIEW_8("overview-scene-eight.fxml"),
    TOURNAMENT_OVERVIEW_16("overview-scene-sixteen.fxml"),
    TOURNAMENT_MATCHES("matches-scene.fxml"),
    TOURNAMENT_RESULTS("results-scene.fxml"),
    PREVIOUS_TOURNAMENTS("previous-overview.fxml"),
    ONGOING_TOURNAMENTS("ongoing-overview.fxml"),
    UPCOMING_OVERVIEW("upcoming-overview.fxml"),
    SET_TIME("set-time-scene.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

}
