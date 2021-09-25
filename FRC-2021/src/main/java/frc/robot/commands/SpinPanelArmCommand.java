// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.TeleopSensitivitySubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class SpinPanelArmCommand extends CommandBase {
	private boolean spinningForwards;

	public SpinPanelArmCommand(boolean spinningForwards) {
		this.spinningForwards = spinningForwards;
		addRequirements(RobotContainer.controlSubsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		if (spinningForwards) {
			RobotContainer.controlSubsystem.setControlPanelArmMotor(0.5 * TeleopSensitivitySubsystem.spinControlPanelInputRate);
		} else {
			RobotContainer.controlSubsystem.setControlPanelArmMotor(-0.5 * TeleopSensitivitySubsystem.spinControlPanelInputRate);
		}
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		RobotContainer.controlSubsystem.setControlPanelArmMotor(0.0);
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
