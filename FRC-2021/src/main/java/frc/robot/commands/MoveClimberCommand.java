/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;


public class MoveClimberCommand extends CommandBase {
	private boolean extendingClimber;

	public MoveClimberCommand(boolean extendingClimber) {
		this.extendingClimber = extendingClimber;
		addRequirements(Robot.climbSubsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		if (extendingClimber) {
			Robot.climbSubsystem.setClimbMotor(-0.8);
		} else {
			Robot.climbSubsystem.setClimbMotor(0.8);
		}
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		Robot.climbSubsystem.setClimbMotor(0.0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}