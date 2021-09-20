/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;


public class FireCommand extends CommandBase {
	public FireCommand() {
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
		
		RobotContainer.manipulatorsubsystem.setShoulderFireMotor(-0.5);		
		RobotContainer.manipulatorsubsystem.setElbowFireMotor(-0.7);
		RobotContainer.manipulatorsubsystem.setWristFireMotor(-1.0);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		RobotContainer.manipulatorsubsystem.setShoulderFireMotor(0.);

		RobotContainer.manipulatorsubsystem.setElbowFireMotor(0.);
		RobotContainer.manipulatorsubsystem.setWristFireMotor(0.);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
