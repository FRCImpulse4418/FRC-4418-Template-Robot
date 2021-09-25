// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DumbShitAutonomousCommand extends CommandBase {
	private int testCounter;
	private final int testCounterMax = 300;

	// private Command autoCommand;

	private boolean hasRunThingy = false;

	public void runMotors() {
		RobotContainer.driveSubsystem.brakeOrCoastMotors(false, false);
		RobotContainer.driveSubsystem.setLeftMotors(0.5);
		RobotContainer.driveSubsystem.setRightMotors(-0.5);
	}

	public DumbShitAutonomousCommand() {
		// addRequirements(RobotContainer.driveSubsystem);
		// autoCommand = new DriveStraightCommand();
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		runMotors();
		// autoCommand.schedule();

		testCounter = 0;
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		SmartDashboard.putNumber("AUTO PRINT COUNTER", testCounter);
		testCounter++;

		if (!hasRunThingy) {
			runMotors();
			hasRunThingy = true;
		}
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		RobotContainer.driveSubsystem.stopDrive();
		// autoCommand.cancel();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return testCounter >= testCounterMax;
	}
}
