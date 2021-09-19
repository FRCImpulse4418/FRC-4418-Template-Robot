/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.*;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	//private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
	//private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();

	//private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

	// Create joysticks
	private static final Joystick
		X3D_LEFT = new Joystick(Constants.X3D_LEFT_JOYSTICK_ID),
		X3D_RIGHT = new Joystick(Constants.X3D_RIGHT_JOYSTICK_ID),
		GAMEPAD = new Joystick(Constants.GAMEPAD_JOYSTICK_ID);

	// Climber axes or up/down buttons (buttons take priority over joystick)
	// public static double getClimberAxis() {
	// 	return GAMEPAD.getRawAxis(Constants.DriverControlIDs.CLIMBER_JOYSTICK_AXIS_ID);
	// }

	public static class DriverControls {
		public static JoystickButton
			toggleArcadeDriveButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.TOGGLE_ARCADE_DRIVE_BUTTON_ID),
			driveStraightButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.DRIVE_STRAIGHT_BUTTON_ID),
		
			intakeButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.INTAKE_BUTTON_ID),
			launchButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.LAUNCH_BUTTON_ID),
			intakeAndLaunchButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.INTAKE_AND_LAUNCH_BUTTON_ID),

			panelSpinButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.PANEL_SPIN_BUTTON_ID),
			reversePanelSpinButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.PANEL_SPIN_REVERSE_BUTTON_ID),

			extendClimberButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.EXTEND_CLIMBER_BUTTON_ID),
			lowerClimberButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.LOWER_CLIMBER_BUTTON_ID),

			spoolWinchButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.SPOOL_WINCH_BUTTON_ID),
			unspoolWinchButton = new JoystickButton(X3D_RIGHT, Constants.DriverControlIDs.UNSPOOL_WINCH_BUTTON_ID);

		private static void configureButtonBindings() {
			toggleArcadeDriveButton.whenPressed(new ToggleDriverArcadeDriveCommand());
			driveStraightButton.whileHeld(new DriveStraightCommand());
			
			intakeButton.whileHeld(new IntakeCommand());
			launchButton.whileHeld(new FireCommand());
			
			// true is forward spin, false is backward spin
			panelSpinButton.whileHeld(new SpinPanelArmCommand(true));
			reversePanelSpinButton.whileHeld(new SpinPanelArmCommand(false));
			
			// true is extending, false is lowering
			extendClimberButton.whileHeld(new MoveClimberCommand(true));
			lowerClimberButton.whileHeld(new MoveClimberCommand(false));
	
			// true is spooling, false is unspooling
			spoolWinchButton.whileHeld(new SpinWinchCommand(true));
			unspoolWinchButton.whileHeld(new SpinWinchCommand(false));
		}
		
		// Tank drive axes
		public static double getLeftTankDriveAxis() {
			return X3D_LEFT.getRawAxis(Constants.DriverControlIDs.LEFT_TANK_DRIVE_AXIS_ID);
		}
		public static double getRightTankDriveAxis() {
			return X3D_RIGHT.getRawAxis(Constants.DriverControlIDs.RIGHT_TANK_DRIVE_AXIS_ID);
		}

		// Arcade drive axes
		public static double getForwardArcadeDriveAxis() {
			return X3D_RIGHT.getRawAxis(Constants.DriverControlIDs.FORWARD_ARCADE_DRIVE_AXIS_ID);
		}

		public static double getAngleArcadeDriveAxis() {
			return X3D_RIGHT.getRawAxis(Constants.DriverControlIDs.ANGLE_ARCADE_DRIVE_AXIS_ID);
		}
	}
	
	public static class SpotterControls {
		public static POVButton
			driveStraightButton = new POVButton(GAMEPAD, Constants.SpotterControlIDs.DRIVE_STRAIGHT_POV_ANGLE);

		public static JoystickButton
			toggleArcadeDriveButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.TOGGLE_ARCADE_DRIVE_BUTTON_ID),
			toggleSensitivityButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.TOGGLE_SENSITIVITY_BUTTON_ID),

			intakeButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.INTAKE_BUTTON_ID),
			launchButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.LAUNCH_BUTTON_ID),

			panelSpinButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.PANEL_SPIN_BUTTON_ID),
			reversePanelSpinButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.PANEL_SPIN_REVERSE_BUTTON_ID),

			extendClimberButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.EXTEND_CLIMBER_BUTTON_ID),
			lowerClimberButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.LOWER_CLIMBER_BUTTON_ID),

			spoolWinchButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.SPOOL_WINCH_BUTTON_ID),
			unspoolWinchButton = new JoystickButton(GAMEPAD, Constants.SpotterControlIDs.UNSPOOL_WINCH_BUTTON_ID);

		private static void configureButtonBindings() {
			toggleArcadeDriveButton.whenPressed(new ToggleSpotterArcadeDriveCommand());
			driveStraightButton.whileHeld(new DriveStraightCommand());
			
			intakeButton.whileHeld(new IntakeCommand());
			launchButton.whileHeld(new FireCommand());
			
			// true is forward spin, false is backward spin
			panelSpinButton.whileHeld(new SpinPanelArmCommand(true));
			reversePanelSpinButton.whileHeld(new SpinPanelArmCommand(false));
			
			// true is extending, false is lowering
			extendClimberButton.whileHeld(new MoveClimberCommand(true));
			lowerClimberButton.whileHeld(new MoveClimberCommand(false));
	
			// true is spooling, false is unspooling
			spoolWinchButton.whileHeld(new SpinWinchCommand(true));
			unspoolWinchButton.whileHeld(new SpinWinchCommand(false));
		}

		// Tank drive axes
		public static double getLeftTankDriveAxis() {
			return X3D_LEFT.getRawAxis(Constants.DriverControlIDs.LEFT_TANK_DRIVE_AXIS_ID);
		}
		public static double getRightTankDriveAxis() {
			return X3D_RIGHT.getRawAxis(Constants.DriverControlIDs.RIGHT_TANK_DRIVE_AXIS_ID);
		}

		// Arcade drive axes
		public static double getForwardArcadeDriveAxis() {
			return X3D_RIGHT.getRawAxis(Constants.DriverControlIDs.FORWARD_ARCADE_DRIVE_AXIS_ID);
		}

		public static double getAngleArcadeDriveAxis() {
			return X3D_RIGHT.getRawAxis(Constants.DriverControlIDs.ANGLE_ARCADE_DRIVE_AXIS_ID);
		}
	}
		

	/**
	 * The container for the robot.  Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the button bindings
		DriverControls.configureButtonBindings();
	}

	/**
	 * Use this method to define your button->command mappings.  Buttons can be created by
	 * instantiating a {@link GenericHID} or one of its subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
	 * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */


	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		return null;
		// An ExampleCommand will run in autonomous
		//return m_autoCommand;
	}
}
