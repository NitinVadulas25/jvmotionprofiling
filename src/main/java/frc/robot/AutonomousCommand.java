package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutonomousCommand extends CommandBase {

    public AutonomousCommand() {
        super();
        setName("Autonomous");
        addRequirements(Autonomous.getInstance());
    }

    double currentTime;

    double timeToGoal;

    double timeShooter;

    int timeLimit;

    @Override
    public void initialize() {
        currentTime = 0;
        //measures amount of time

        timeShooter = 0;
        //to be tuned

        timeToGoal = 0;
        //to be tuned

        timeLimit = 16;
        //total auton time
    }

    @Override
    public void execute() {
        if (currentTime < timeToGoal) {
            //if the current time is less than the time to get to goal, move forward
            Autonomous.getInstance().moveForward();
        }

        if (currentTime <= timeToGoal) {
            IntakeShooter.getInstance().Intake();
            //if the current time is less than the time to goal, keep the intake running
        }

        //val of time to be measured when testing
        if (currentTime < timeLimit) {
            //if the amount of time it takes to bring the arm up has not been reached...
            Arm.getInstance().armUp();
            //keep raising the arm
        }

        if (currentTime > timeToGoal) {
            IntakeShooter.getInstance().Shooter();
        }

        currentTime += 0.2;
        //increases the time counter by 0.2 (it cycles through execute() every 0.2 seconds

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
