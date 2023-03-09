package frc.robot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class IntakeShooterCommand extends CommandBase {
    public IntakeShooterCommand() {
        setName("Intake Command");
        addRequirements(IntakeShooter.getInstance());
    }



    @Override
    public void initialize() {
        super.initialize();

    }

    @Override
    public void execute() {
        if (OI.getInstance().getController().getLeftBumperPressed())  {
            IntakeShooter.getInstance().IntakeShooterControl();
        }





    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
