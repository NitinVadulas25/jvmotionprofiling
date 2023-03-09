package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{
    public static DriveTrain instance = null;
    public static DriveTrain getInstance(){
        if (instance == null){
            instance = new DriveTrain();
        }
        return instance;
    }

    Talon TalonLeftForward, TalonLeftBack, TalonRightForward, TalonRightBack;

    public void initHardware() {
        TalonLeftForward = new Talon(0);
        TalonLeftBack = new Talon(1);
        TalonRightForward = new Talon(2);
        TalonRightBack = new Talon(3);
        //initializing sparks
    }

    public void setMotors(double rightVal, double leftVal){
        TalonRightForward.set(rightVal);
        TalonRightBack.set(rightVal);
        TalonLeftBack.set(leftVal);
        TalonLeftForward.set(leftVal);
    }
}