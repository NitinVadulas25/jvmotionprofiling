package frc.robot;



import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain2 extends SubsystemBase{
    public static DriveTrain2 instance = null;
    public static DriveTrain2 getInstance(){
        if (instance == null){
            instance = new DriveTrain2();
        }
        return instance;
    }

    Spark sparkLeft;
    public void initHardware() {
        sparkLeft = new Spark(0);

        //initializing sparks
    }


}
