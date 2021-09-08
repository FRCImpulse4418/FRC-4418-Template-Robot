// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ControlCommand extends CommandBase {
  private Boolean controlbutton;
  
  public ControlCommand() {
    addRequirements(Robot.controlSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.controlSubsystem.SpinControl(1);
    SmartDashboard.putBoolean("Is it spin", true);
    controlbutton = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*
    Robot.controlSubsystem.SpinControl(0.2);
    System.out.print("control spin");
    controlbutton = true;
    SmartDashboard.putString("CONTROL THINGIE", "control spin ACTIVE");
    controlbutton = true;
    */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("Is it spin", false);
    Robot.controlSubsystem.SpinControl(0);
    controlbutton = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    SmartDashboard.updateValues();
    return false;
  }
}
