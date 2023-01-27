package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot<counter> extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  PIDController controller;

  TrapezoidProfile.State start;
  TrapezoidProfile.State end;
  TrapezoidProfile.Constraints constraints;
  TrapezoidProfile profile;
  TrapezoidProfile.State profileOutput;
  Spark sparkRight;
  Spark sparkLeft;
  Encoder encoder;
  double kp, ki, kd;






  @Override
  public void robotInit() {
    sparkRight = new Spark(0);
    sparkLeft = new Spark(1);
    //initializing sparks

    encoder = new Encoder(Constants.ENCODER_IDS[0], Constants.ENCODER_IDS[1]);
    //encoder initialization

    start = new TrapezoidProfile.State(0,0);
    end = new TrapezoidProfile.State(1.0,0);
    constraints = new TrapezoidProfile.Constraints(0.2, 0.2);
    profile = new TrapezoidProfile(constraints, end, start);
    profileOutput = profile.calculate(0.2);
    //initialization of TrapezoidProfile states

    kp = 0;
    ki = 0;
    kd = 0;
    //ki kp kd vals

    controller = new PIDController(kp, ki, kd);



  }


    //PID controller initialization

    int counter = 0;



  @Override
  public void robotPeriodic() {}


  @Override
  public void autonomousInit() {


    //first add arm raising before all following code OR have it preset up

    if (encoder.getDistance() <= 22.50 * Constants.TICKS_PER_INCH) {
      TrapezoidProfile.State profileOutput = profile.calculate(0.02 * counter);
      controller.setSetpoint(22.50 * Constants.TICKS_PER_INCH);
      double output = controller.calculate(encoder.getDistance());
      sparkRight.set(output);
      sparkLeft.set(output);
      counter++;
    }


  }


  @Override
  public void autonomousPeriodic() {

  }


  @Override
  public void teleopInit() {

  }



  @Override
  public void teleopPeriodic() {

  }



  @Override
  public void disabledInit() {}


  @Override
  public void disabledPeriodic() {}


  @Override
  public void testInit() {}


  @Override
  public void testPeriodic() {}
}
