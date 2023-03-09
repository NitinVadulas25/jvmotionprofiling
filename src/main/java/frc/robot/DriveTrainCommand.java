package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;


public class DriveTrainCommand extends CommandBase {
    public DriveTrainCommand(){
        super();
        setName("Drivetrain");
        addRequirements(DriveTrain.getInstance());

    }
//    boolean clicked;

    double leftMotorVal;
    double rightMotorVal;



    @Override
    public void initialize() {
        leftMotorVal = OI.getInstance().getController().getLeftY();
        rightMotorVal = OI.getInstance().getController().getRightY();
    }

    @Override
    public void execute() {

        // -0.1 and 0.1 accounts for deadzone

        if (leftMotorVal > -0.1 && leftMotorVal < 0.1 && rightMotorVal > -0.1 && rightMotorVal < 0.1) {
            //if deadzone values are true, set both x and y to 0
            DriveTrain.getInstance().setMotors(0,0);
        }

        else if (rightMotorVal < -0.1 || rightMotorVal > 0.1) {
            //if the right motor values are not in the deadzone and...
            if (leftMotorVal > -0.1 && leftMotorVal < 0.1) {
                //left motor values are in the deadzone...
                DriveTrain.getInstance().setMotors(rightMotorVal, 0);
                //set the left motor to 0 and the right motor to the value received from the controller3
            }
        }

        else if (leftMotorVal < -0.1 || leftMotorVal > 0.1) {
            //if the left motor value is not withing the deadzone and...
            if (rightMotorVal > -0.1 && rightMotorVal < 0.1) {
                //right motor value is in the deadzone...
                DriveTrain.getInstance().setMotors(0, leftMotorVal);
                //set the right value to 0 and the left value to the value from the controller
            }
        }

        else {
            DriveTrain.getInstance().setMotors(rightMotorVal, leftMotorVal);
            /*otherwise, if both right and left values are not in the deadzone, set the motors to the values from the
            controller
             */
        }
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



