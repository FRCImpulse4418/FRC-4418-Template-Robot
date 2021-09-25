/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class WinchSubsystem extends SubsystemBase {
	private WPI_TalonFX winchMotor;

	// private double winchMaxDist;
	// private double winchMinDist;

	public WinchSubsystem() {
		winchMotor = new WPI_TalonFX(Constants.Winch.TALONFX_ID);
	}

	public void setWinchMotor(double motorValue) {
		winchMotor.set(ControlMode.PercentOutput, motorValue);
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}