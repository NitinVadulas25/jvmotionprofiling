package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;

public class IntakeShooter extends SubsystemBase {
    private static frc.robot.IntakeShooter instance;
    public static frc.robot.IntakeShooter getInstance() {
        if (instance == null) {
            instance = new frc.robot.IntakeShooter();
        }
        return instance;
    }

    Spark sparkIntake;
    XboxController controller;


    private IntakeShooter() {

    }

    public void initHardware() {
        sparkIntake = new Spark(4);
    }

    public void Intake() {
        sparkIntake.set(0.2);
    }

    public void Shooter() {
        sparkIntake.set(-0.2);
    }

    public void IntakeShooterControl() {
        if (controller.getLeftBumperPressed()) {
            sparkIntake.set(-0.2);
        }
        if (controller.getLeftBumperReleased()) {
            sparkIntake.set(0.2);
        }
    }

}
