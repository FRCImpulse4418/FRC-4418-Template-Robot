/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.Robot;


public class TeleopDriveCommand extends CommandBase {
	public TeleopDriveCommand() {
		addRequirements(Robot.driveSubsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {

	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		if (Robot.driveSubsystem.driverIsInArcadeDrive()) {
			Robot.driveSubsystem.teleopArcadeDriveWrapper(
				RobotContainer.DriverControls.getForwardArcadeDriveAxis(), // forward
				RobotContainer.DriverControls.getAngleArcadeDriveAxis()  // angle
			);
		} else {
			Robot.driveSubsystem.teleopTankDriveWrapper(
				RobotContainer.DriverControls.getLeftTankDriveAxis(),  // left
				RobotContainer.DriverControls.getRightTankDriveAxis()  // right
			);
		}
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		Robot.driveSubsystem.stopDrive();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
