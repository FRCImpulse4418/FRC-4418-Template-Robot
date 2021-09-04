/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;


public class FireCommand extends CommandBase {
	public FireCommand() {
		// Use addRequirements() here to declare subsystem dependencies.
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		SmartDashboard.putNumber("Top Fire", Robot.manipulatorsubsystem.getOuterFireMotor());
		SmartDashboard.putNumber("Bottom Fire", Robot.manipulatorsubsystem.getInnerFireMotor());
		
		Robot.manipulatorsubsystem.setInnerIntakeMotor(-.5);
		
		Robot.manipulatorsubsystem.setInnerFireMotor(-7.);
		Robot.manipulatorsubsystem.setOuterFireMotor(-1.);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		Robot.manipulatorsubsystem.setInnerIntakeMotor(0.);

		Robot.manipulatorsubsystem.setInnerFireMotor(0.);
		Robot.manipulatorsubsystem.setOuterFireMotor(0.);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
