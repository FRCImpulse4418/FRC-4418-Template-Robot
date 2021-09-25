/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.lang.Math;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotContainer;


public class ShooterCommand extends CommandBase {
	public static final int
		speedTolerance = 20,
		wristTargetSpeed = 4000, 		//in RPM, changed to units/100ms in motor commands 	// TODO: Config wrist fire motor speed
		elbowTargetSpeed = 4000,		// TODO: Config elbow fire motor speed
		countsPerRev = 1024,
		unitsPerRev = countsPerRev * 4;	//the talon counts every rising and falling edge

	public static ShuffleboardTab smartDashboardTab;

	public static NetworkTableEntry toleranceSlider;
	public static NetworkTableEntry elbowRPMSlider;
	public static NetworkTableEntry wristRPMSlider;

	public ShooterCommand() {
		addRequirements(RobotContainer.manipulatorsubsystem);		
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {

	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		

		// SmartDashboard.putNumber("Wrist Fire", RobotContainer.manipulatorsubsystem.getWristFireMotor());
		// SmartDashboard.putNumber("Elbow Fire", RobotContainer.manipulatorsubsystem.getElbowFireMotor());
		// SmartDashboard.putNumber("Shoulder Fire", RobotContainer.manipulatorsubsystem.getShoulderFireMotor());
		
		RobotContainer.manipulatorsubsystem.setElbowFireMotor(
			-(wristRPMSlider.getDouble(0.0)*(unitsPerRev/600)));	
		RobotContainer.manipulatorsubsystem.setWristFireMotor(
			-(elbowRPMSlider.getDouble(0.0)*(unitsPerRev/600)));	
		
		SmartDashboard.putNumber("Wrist Motor Velocity", Math.abs(RobotContainer.manipulatorsubsystem.wristFireMotor.getSelectedSensorVelocity(0)));

		SmartDashboard.putNumber("Elbow Motor Velocity", Math.abs(RobotContainer.manipulatorsubsystem.elbowFireMotor.getSelectedSensorVelocity(0)));
		//need to wait until motors are up to speed
		// double currentSpeed = Math.abs(RobotContainer.manipulatorsubsystem.wristFireMotor.getSelectedSensorVelocity(0)) * (600/unitsPerRev);
		// if ((wristTargetSpeed - currentSpeed) <= toleranceSlider.getDouble(0))  {
		// 	RobotContainer.manipulatorsubsystem.setShoulderFireMotor(-0.5);	
		// }
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		RobotContainer.manipulatorsubsystem.setElbowFireMotor(0.0);
		RobotContainer.manipulatorsubsystem.setWristFireMotor(0.0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
