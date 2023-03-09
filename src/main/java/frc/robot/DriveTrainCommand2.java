package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class DriveTrainCommand2 extends CommandBase {
    public DriveTrainCommand2(){
        super();
        setName("Drivetrain");
        addRequirements(DriveTrain.getInstance());

    }






    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        DriveTrain2.getInstance().sparkLeft.set(0.2);


        }


    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }
}




