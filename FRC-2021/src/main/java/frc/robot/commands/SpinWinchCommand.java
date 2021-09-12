/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;


public class SpinWinchCommand extends CommandBase {
	private boolean spooling;
	
	public SpinWinchCommand(boolean spooling) {
		this.spooling = spooling;
		addRequirements(Robot.winchSubsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		if (spooling) {
			Robot.winchSubsystem.setWinchMotor(-0.6);
		} else {
			Robot.winchSubsystem.setWinchMotor(0.6);
		}
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		Robot.winchSubsystem.setWinchMotor(0.0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
