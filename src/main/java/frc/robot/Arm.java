package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

    private static Arm instance;

    public static Arm getInstance() {
        if (instance == null) {
            instance = new Arm();
        }
        return instance;
    }

    Spark arm;

    public void initHardware() {
        arm = new Spark(3);
    }

    public void armStationary() {arm.set(0);}

    public void armUp() {
        arm.set(0.2);
    }

    public void armDown() {
        arm.set(-0.2);
    }





}
