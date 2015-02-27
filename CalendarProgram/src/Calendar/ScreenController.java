package Calendar;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by GuoJunjun <junjunguo.com> on 27/02/15.
 */

public class ScreenController {
    private static Stage theStage;
    private static Main theParent;

    /**
     * set stage
     *
     * @param stage
     */
    public static void setTheStage(Stage stage) {
        theStage = stage;
        theStage.setTitle("Calendar");
    }

    /**
     * set Main as parent
     *
     * @param parent
     */
    public static void setTheParent(Main parent) {
        theParent = parent;
    }

    /**
     * show stage
     */
    public static void showStage() {
        theStage.show();
    }

    /**
     * load the View Window
     */
    public static void loadView() {
        replaceSceneContent("view/view.fxml");
    }

    /**
     * load the Edit window
     */
    public static void loadEdit() {
        replaceSceneContent("view/edit.fxml");
    }

    public static void loadLogin() {
        replaceSceneContent("view/login.fxml");
    }

    public static void loadRegister() {
        replaceSceneContent("view/register.fxml");

    }

    /**
     * load or replace a window
     *
     * @param fxml
     *
     * @return Window
     */
    private static Parent replaceSceneContent(String fxml) {
        try {
            Parent page = FXMLLoader.load(theParent.getClass().getResource(fxml));
            Scene scene = theStage.getScene();
            // first time running
            if (scene == null) {
                scene = new Scene(page);
                theStage.setScene(scene);
            } else {
                theStage.getScene().setRoot(page);
            }
            theStage.sizeToScene();
            return page;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
