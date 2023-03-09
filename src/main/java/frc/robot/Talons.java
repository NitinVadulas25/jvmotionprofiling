package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Talons extends SubsystemBase{
    public static Talons instance = null;
    public static Talons getInstance(){
        if (instance == null){
            instance = new Talons();
        }
        return instance;
    }

    Talon test;
    public void initHardware() {
        test = new Talon(0);

    }


}

