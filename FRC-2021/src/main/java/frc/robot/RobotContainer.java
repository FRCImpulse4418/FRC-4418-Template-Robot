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
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
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

	// Tank drive axes
	public static double getLeftTankDriveAxis() {
		return X3D_LEFT.getRawAxis(Constants.LEFT_TANK_DRIVE_AXIS_ID);
	}
	public static double getRightTankDriveAxis() {
		return X3D_RIGHT.getRawAxis(Constants.RIGHT_TANK_DRIVE_AXIS_ID);
	}

	// Arcade drive axes
	public static double getForwardArcadeDriveAxis() {
		return X3D_RIGHT.getRawAxis(Constants.FORWARD_ARCADE_DRIVE_AXIS_ID);
	}

	public static double getAngleArcadeDriveAxis() {
		return X3D_RIGHT.getRawAxis(Constants.ANGLE_ARCADE_DRIVE_AXIS_ID);
	}

	// Climber axes or up/down buttons (buttons take priority over joystick)
	public static double getClimberInput() {
		
		return GAMEPAD.getRawAxis(Constants.CLIMBER_JOYSTICK_AXIS_ID);
	}

	// Create and assign default buttons
	public static JoystickButton toggleArcadeDriveButton = new JoystickButton(X3D_RIGHT, Constants.TOGGLE_ARCADE_DRIVE_BUTOON_ID);
	public static JoystickButton driveStraightButton = new JoystickButton(X3D_RIGHT, Constants.DRIVE_STRAIGHT_BUTTON_ID);
	
	// public static JoystickButton testButton = new JoystickButton(X3D_RIGHT, Constants.TEST_BUTTON_ID);
	
	public static JoystickButton intakeButton = new JoystickButton(X3D_RIGHT, Constants.INTAKE_BUTTON_ID);
	public static JoystickButton launchButton = new JoystickButton(X3D_RIGHT, Constants.LAUNCH_BUTTON_ID);
	public static JoystickButton intakeAndLaunchButton = new JoystickButton(X3D_RIGHT, Constants.INTAKE_AND_LAUNCH_BUTTON_ID);

	public static JoystickButton controlSpinButton = new JoystickButton(X3D_RIGHT, Constants.PANEL_SPIN_BUTTON_ID);
	public static JoystickButton controlSpinReverseButton = new JoystickButton(X3D_RIGHT, Constants.PANEL_SPIN_REVERSE_BUTTON_ID);

	public static JoystickButton extendClimberButton = new JoystickButton(X3D_RIGHT, Constants.EXTEND_CLIMBER_BUTTON_ID);
	public static JoystickButton lowerClimberButton = new JoystickButton(X3D_RIGHT, Constants.LOWER_CLIMBER_BUTTON_ID);

	public static JoystickButton spoolWinchButton = new JoystickButton(X3D_RIGHT, Constants.SPOOL_WINCH_BUTTON_ID);
	public static JoystickButton unspoolWinchButton = new JoystickButton(X3D_RIGHT, Constants.UNSPOOL_WINCH_BUTTON_ID);

	/**
	 * The container for the robot.  Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the button bindings
		configureButtonBindings();
	}

	/**
	 * Use this method to define your button->command mappings.  Buttons can be created by
	 * instantiating a {@link GenericHID} or one of its subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
	 * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {
		toggleArcadeDriveButton.whenPressed(new ToggleArcadeDriveCommand());
		driveStraightButton.whileHeld(new DriveStraightCommand());
		
		intakeButton.whileHeld(new IntakeCommand());
		launchButton.whileHeld(new FireCommand());
		intakeAndLaunchButton.whileHeld(new ParallelCommandGroup(new IntakeCommand(), new FireCommand()));
		
		// true is forward spin, false is backward spin
		controlSpinButton.whileHeld(new SpinPanelArmCommand(true));
		controlSpinReverseButton.whileHeld(new SpinPanelArmCommand(false));
		
		// true is extending, false is lowering
		extendClimberButton.whileHeld(new MoveClimberCommand(true));
		lowerClimberButton.whileHeld(new MoveClimberCommand(false));

		// true is spooling, false is unspooling
		spoolWinchButton.whileHeld(new SpinWinchCommand(true));
		unspoolWinchButton.whileHeld(new SpinWinchCommand(false));
	}


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
