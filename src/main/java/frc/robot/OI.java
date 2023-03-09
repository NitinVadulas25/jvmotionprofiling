package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class OI {
    private static OI instance;
    public static OI getInstance(){
        if (instance == null){
            instance = new OI();

        }
        return instance;
    }

    private XboxController controller;

    public void setupControls() {
        controller = new XboxController(0);
    }

    public XboxController getController() {
        return controller;
    }

}