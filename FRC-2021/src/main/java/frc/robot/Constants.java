/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


public final class Constants {
	public static final int
		// Gamepad axes
		GAMEPAD_AXIS_LEFT_X = 0,
		GAMEPAD_AXIS_LEFT_Y = 1,
		GAMEPAD_AXIS_RIGHT_X = 4,
		GAMEPAD_AXIS_RIGHT_Y = 5;

	public static final double
		// Drive axis dominance thresholds
		ARCADE_AXIS_DOMINANCE_THRESHOLD = 0.35,
		TANK_AXIS_DOMINANCE_THRESHOLD = 0.21;

	private static final int
		// GAMEPAD_AXIS_LEFT_TRIGGER = 2,
		// GAMEPAD_AXIS_RIGHT_TRIGGER = 3,

		// Gamepad buttons
		GAMEPAD_BUTTON_A = 1,
		GAMEPAD_BUTTON_B = 2,
		GAMEPAD_BUTTON_X = 3,
		GAMEPAD_BUTTON_Y = 4,
		GAMEPAD_BUTTON_LEFT_BUMPER = 5,
		GAMEPAD_BUTTON_RIGHT_BUMPER = 6,
		GAMEPAD_BUTTON_BACK = 7,
		GAMEPAD_BUTTON_START = 8,
		// GAMEPAD_BUTTON_LOGITECH = 9,
		GAMEPAD_BUTTON_LEFT_JS = 10,
		GAMEPAD_BUTTON_RIGHT_JS = 11,

		// Gamepad POV buttons
		GAMEPAD_POV_ANGLE_UP = 0,

		// X3D Axes
		X3D_AXIS_ROLL = 0,
		X3D_AXIS_PITCH = 1,
		/*X3D_AXIS_YAW = 2,
		X3D_AXIS_OTHER = 3,*/

		// X3D buttons
		// X3D_BUTTON_TRIGGER = 1,
		X3D_BUTTON_GRIP = 2,
		X3D_BUTTON_3 = 3,
		X3D_BUTTON_4 = 4,
		X3D_BUTTON_5 = 5,
		X3D_BUTTON_6 = 6,
		X3D_BUTTON_7 = 7,
		X3D_BUTTON_8 = 8,
		X3D_BUTTON_9 = 9,
		X3D_BUTTON_10 = 10,
		X3D_BUTTON_11 = 11,
		X3D_BUTTON_12 = 12;

	public static final int
		// Joysticks IDs
		X3D_LEFT_JOYSTICK_ID = 0,
		X3D_RIGHT_JOYSTICK_ID = 1,
		GAMEPAD_JOYSTICK_ID = 2;

	public static class DriverControlIDs {
		public static final int
			// Tank drive axis
			LEFT_TANK_DRIVE_AXIS_ID = X3D_AXIS_PITCH,
			RIGHT_TANK_DRIVE_AXIS_ID = X3D_AXIS_PITCH,

			// Arcade drive axis
			ARCADE_DRIVE_FORWARD_AXIS_ID = X3D_AXIS_PITCH,
			ARCADE_DRIVE_ANGLE_AXIS_ID = X3D_AXIS_ROLL,
			TOGGLE_ARCADE_DRIVE_BUTTON_ID = X3D_BUTTON_5,	// does not toggle drive mode for spotter
			DRIVE_STRAIGHT_BUTTON_ID = X3D_BUTTON_GRIP,

			// Manipulator buttons
			BACKWARD_INTAKE_BUTTON_ID = X3D_BUTTON_6,
			FORWARD_INTAKE_BUTTON_ID = X3D_BUTTON_4,
			LAUNCH_BUTTON_ID = X3D_BUTTON_3,

			// Control panel arm buttons
			PANEL_SPIN_BUTTON_ID = X3D_BUTTON_12,
			PANEL_SPIN_REVERSE_BUTTON_ID = X3D_BUTTON_11,
			
			// Climber buttons
			EXTEND_CLIMBER_BUTTON_ID = X3D_BUTTON_10,
			LOWER_CLIMBER_BUTTON_ID = X3D_BUTTON_9,

			// Winch buttons
			SPOOL_WINCH_BUTTON_ID = X3D_BUTTON_8,
			UNSPOOL_WINCH_BUTTON_ID = X3D_BUTTON_7;
	}

	public static class SpotterControlIDs {
		public static final int
			// Tank drive axis
			LEFT_TANK_DRIVE_AXIS_ID = GAMEPAD_AXIS_LEFT_Y,
			RIGHT_TANK_DRIVE_AXIS_ID = GAMEPAD_AXIS_RIGHT_Y,

			// Arcade drive axis
			ARCADE_DRIVE_FORWARD_AXIS_ID = GAMEPAD_AXIS_LEFT_Y,
			ARCADE_DRIVE_ANGLE_AXIS_ID = GAMEPAD_AXIS_LEFT_X,
			
			// Drive mode function buttons
			DRIVE_STRAIGHT_POV_ANGLE = GAMEPAD_POV_ANGLE_UP,
			TOGGLE_ARCADE_DRIVE_BUTTON_ID = GAMEPAD_BUTTON_LEFT_JS,	// does not toggle drive mode for driver
			TOGGLE_SENSITIVITY_BUTTON_ID = GAMEPAD_BUTTON_RIGHT_JS,	// does not toggle motor sensitivities for driver

			// Manipulator buttons
			INTAKE_BUTTON_ID = GAMEPAD_BUTTON_X,
			LAUNCH_BUTTON_ID = GAMEPAD_BUTTON_B,

			// Control panel arm trigger axes
			PANEL_SPIN_BUTTON_ID = GAMEPAD_BUTTON_LEFT_BUMPER,
			PANEL_SPIN_REVERSE_BUTTON_ID = GAMEPAD_BUTTON_RIGHT_BUMPER,
			
			// Climber buttons
			EXTEND_CLIMBER_BUTTON_ID = GAMEPAD_BUTTON_Y,
			LOWER_CLIMBER_BUTTON_ID = GAMEPAD_BUTTON_A,

			// Winch buttons
			SPOOL_WINCH_BUTTON_ID = GAMEPAD_BUTTON_BACK,
			UNSPOOL_WINCH_BUTTON_ID = GAMEPAD_BUTTON_START;
	}

	public static class Drive {
		public static final int
			DRIVE_LEFT_A_TALON_SRX_ID = 10,
			DRIVE_LEFT_B_TALON_SRX_ID = 2,
			DRIVE_RIGHT_A_TALON_SRX_ID = 6,
			DRIVE_RIGHT_B_TALON_SRX_ID = 5;
			// DRIVE_LEFT_ENCODER_CHANNELA_ID = 6,
			// DRIVE_LEFT_ENCODER_CHANNELB_ID = 7,
			// DRIVE_RIGHT_ENCODER_CHANNELA_ID = 8,
			// DRIVE_RIGHT_ENCODER_CHANNELB_ID = 9,
			// DRIVE_GYRO_ID = 0,
			// DRIVE_FRONT_DISTANCE_PING_ID = 10,
			// DRIVE_FRONT_DISTANCE_ECHO_ID = 11,
			// DRIVE_BACK_DISTANCE_PING_ID = 12,
			// DRIVE_BACK_DISTANCE_ECHO_ID = 13;

		public static final double
			ENCODER_DISTANCE_PER_PULSE  = (15.24 * Math.PI) / 256; // diameter * pi = circumference. circumference / 256 = distance per pulse

		public static final int
			DRIVE_ENCODER_DECODING_SCALE_FACTOR = 2;
	}

	public static class Manipulator {
		public static final int
			MAN_FIRE_TOP_TALONSRX_ID = 3,
			MAN_FIRE_BOTTOM_TALONSRX_ID = 1,

			MAN_INTAKE_TOP_TALONSRX_ID = 11,
			MAN_INTAKE_BOTTOM_TALONSRX_ID = 8;
	}

	public static class Climber {
		public static final int
			// CLIMBER_ENCODER_CHANNELA_ID = 2,
			// CLIMBER_FRONT_ENCODER_CHANNELB_ID = 3,
			WINCH_TALONFX_ID = 12,
			CLIMBER_TALONSRX_ID = 9;
		
		// FIXME: Figure out climber encoder distance per pulse
		// public static final double CLIMBER_ENCODER_DISTANCE_PER_PULSE = SOME VALUE;
	}

	public static class ControlPanel {
		public static final int
			CONTROLSPIN_TALONSRX_ID = 7;
	}

// RIO Post Info
// public static int[] expectedTalonIDs = {
// 	DRIVE_LEFT_A_TALON_SRX_ID,
// 	DRIVE_LEFT_B_TALON_SRX_ID,
// 	DRIVE_RIGHT_A_TALON_SRX_ID,
// 	DRIVE_RIGHT_B_TALON_SRX_ID
// };

// public static int[] expectedDIOEncoders = {
// 	DRIVE_LEFT_ENCODER_CHANNELA_ID,
// 	DRIVE_LEFT_ENCODER_CHANNELB_ID,
// 	DRIVE_RIGHT_A_TALON_SRX_ID,
// 	DRIVE_RIGHT_B_TALON_SRX_ID
// };

// public static int expectedGyro = DRIVE_GYRO_ID;

// public static int[] expectedDIOUltrasonic = {
// 	DRIVE_FRONT_DISTANCE_PING_ID,
// 	DRIVE_FRONT_DISTANCE_ECHO_ID,
// 	DRIVE_BACK_DISTANCE_PING_ID,
// 	DRIVE_BACK_DISTANCE_ECHO_ID
// };
}
