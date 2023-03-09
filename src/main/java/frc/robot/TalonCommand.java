package frc.robot;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class TalonCommand extends CommandBase {
    public TalonCommand(){
        super();

        addRequirements(Talons.getInstance());

    }



    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        Talons.getInstance().test.set(0.2);



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




