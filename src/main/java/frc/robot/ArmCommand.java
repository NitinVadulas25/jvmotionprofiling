package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmCommand extends CommandBase {

    public ArmCommand() {
        setName("Arm Command");
        addRequirements(Arm.getInstance());
    }

    boolean AButton;
    // AButton is arm up
    boolean BButton;
    // BButton is arm down

    @Override
    public void initialize() {
        AButton = OI.getInstance().getController().getAButtonPressed();
        BButton = OI.getInstance().getController().getBButtonPressed();
    }

    @Override
    public void execute() {

        if (AButton && BButton) {
            Arm.getInstance().armStationary();
            // If the a button and b button control were pressed at once, do not move arm
        }

        if (AButton) {
            Arm.getInstance().armUp();
            // If the a button control is pressed, make the arm go up
        }

        if (BButton) {
            Arm.getInstance().armDown();
            // If the b button control is pressed, make the arm go down
        }

        else {
            Arm.getInstance().armStationary();
            // If neither a nor b buttons are pressed, do not move the arm
        }

    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
