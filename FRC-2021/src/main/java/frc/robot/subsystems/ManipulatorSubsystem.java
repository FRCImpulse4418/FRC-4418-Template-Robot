/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
//import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ManipulatorSubsystem extends SubsystemBase {
	private WPI_TalonSRX intakeMotor;
	
	private WPI_TalonSRX shoulderFireMotor;
	private WPI_TalonSRX elbowFireMotor;
	private WPI_TalonSRX wristFireMotor;

	/* Encoder.getRate() returns distance per second
	distance per second * distance per pulse = pulse per second
	pulse per second * decoding factor = degrees per second
	degrees per second / 360 degrees = revolutions per second
	revolutions per second * 60 seconds = revolutions per minute (RPM) */
	// private static double distPerSecToRPM = 
	//   Constants.DRIVE_ENCODER_DISTANCE_PER_PULSE
	//   * (double) Constants.DRIVE_ENCODER_DECODING_SCALE_FACTOR 
	//   / 60.0;

	private AnalogPotentiometer pivotPotentiometer;

	private boolean pivotUp = true;

	public ManipulatorSubsystem() {
		intakeMotor = new WPI_TalonSRX(Constants.Manipulator.MAN_INTAKE_BOTTOM_TALONSRX_ID);
		
		shoulderFireMotor = new WPI_TalonSRX(Constants.Manipulator.MAN_INTAKE_TOP_TALONSRX_ID);
		elbowFireMotor = new WPI_TalonSRX(Constants.Manipulator.MAN_FIRE_BOTTOM_TALONSRX_ID);
		wristFireMotor = new WPI_TalonSRX(Constants.Manipulator.MAN_FIRE_TOP_TALONSRX_ID);

	}

	// set motors
	public void setElbowFireMotor(double velocity) { elbowFireMotor.set(ControlMode.Velocity, velocity); }
	public void setWristFireMotor(double velocity) { wristFireMotor.set(ControlMode.Velocity, velocity); }
	public void setShoulderFireMotor(double velocity) { shoulderFireMotor.set(ControlMode.Velocity, velocity); }
	public void setIntakeMotor(double velocity) { intakeMotor.set(ControlMode.Velocity, velocity); }

	//read motors
	// FIXME: Get motor velocities instead of -1 to 1 speed for manipulator motors
	// public double getShoulderFireMotor() { return shoulderFireMotor.get(); }
	// public double getElbowFireMotor() { return elbowFireMotor.get(); }
	// public double getWristFireMotor() { return wristFireMotor.get(); }
	// public double getIntakeMotor() { return intakeMotor.get(); }

	// read potentiometer
	public double getPivotPotentiometer() { return pivotPotentiometer.get(); }

	// (if confused about distPerSecToRPM static constant, check comment in definition)
	// public double getLeftEncoderRPM() { return -leftDriveEncoder.getRate() * distPerSecToRPM; }

	// public double getRightEncoderRPM() { return -rightDriveEncoder.getRate() * distPerSecToRPM; }

	// get whether the pivot is up
	public boolean pivotIsUp(){
		if( getPivotPotentiometer() > 13){
			return pivotUp;
		} else {
			return !pivotUp;
		}
	}

	@Override
	public void periodic() {}
}