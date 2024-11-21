package frc.robot;



import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.AMPmechcom;
import frc.robot.commands.Intakecom;
import frc.robot.commands.SHOOT;
//import frc.robot.autos.TwoPiece;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.leftclimbcom;
import frc.robot.commands.moveshootercommand;
import frc.robot.commands.pivotintake;
import frc.robot.commands.rightclimbcom;
import frc.robot.subsystems.Ampmech;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.intakepivot;
import frc.robot.subsystems.leftclimber;
import frc.robot.subsystems.moveshooter;
import frc.robot.subsystems.rightclimber;
import frc.robot.subsystems.shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /* Controllers */
  private final Joystick driver = new Joystick(0);
  private final Joystick copilot = new Joystick(1);
  private final Joystick masepilot = new Joystick(2);
 

  /* Drive Controls */
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;

  /* Driver Buttons */
  private final JoystickButton zeroGyro =
      new JoystickButton(driver, XboxController.Button.kY.value);
  private final JoystickButton robotCentric =
     new JoystickButton(driver, XboxController.Button.kLeftBumper.value);


      private final JoystickButton lclimbButton = new JoystickButton(driver,7);
      private final JoystickButton rclimbButton = new JoystickButton(driver,8);
      private final JoystickButton ldclimbButton = new JoystickButton(driver, 2);
      private final JoystickButton rdclimbButton = new JoystickButton(driver, 1);




       private final POVButton UmoveshooterButton = new POVButton(masepilot, 180);
       private final POVButton DmoveshooterButton = new POVButton(masepilot, 0);
       private final JoystickButton OutButton = new JoystickButton(masepilot, 1);
       private final JoystickButton shooterButton = new JoystickButton(masepilot,6);
       private final JoystickButton IntakeButton = new JoystickButton(masepilot,5);
       private final JoystickButton fpivotIntakeButton = new JoystickButton(masepilot, 5);
       private final JoystickButton flapButton = new JoystickButton(masepilot, 4);
      

       


      //private final JoystickButton fpivotIntakeButton = new JoystickButton(copilot, 1);
      //private final JoystickButton IntakeButton = new JoystickButton(copilot,1);

      //private final JoystickButton flapButton = new JoystickButton(copilot, 4);

      //private final JoystickButton shooterButton = new JoystickButton(copilot,2);
      //private final JoystickButton OutButton = new JoystickButton(copilot,2);
      
      //private final JoystickButton UmoveshooterButton = new JoystickButton(copilot, 5);
      //private final JoystickButton DmoveshooterButton = new JoystickButton(copilot,3);

  /*Copilot buttons */
  
  /* Subsystems */
  private final Swerve s_Swerve = new Swerve();
  
  private final intakepivot s_IntakePivot = new intakepivot();
  private final intake s_Intake = new intake();

  private final shooter s_SHooter = new shooter();

  private final rightclimber s_rightClimber = new rightclimber();
  private final leftclimber s_leftClimber = new leftclimber();
  
  private final moveshooter s_Move = new moveshooter();

  private final Ampmech s_AMP = new Ampmech();
 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
  
    

   
    
    s_Swerve.setDefaultCommand(
        new TeleopSwerve(
            s_Swerve,
            () -> -driver.getRawAxis(translationAxis),
            () -> -driver.getRawAxis(strafeAxis),
            () -> driver.getRawAxis(rotationAxis),
            () -> robotCentric.getAsBoolean()));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /* Driver Buttons */
    zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));

    fpivotIntakeButton.whileTrue(new pivotintake(s_IntakePivot,1,false));
    fpivotIntakeButton.onFalse(new pivotintake(s_IntakePivot,1,true));
   
    IntakeButton.whileTrue(new Intakecom(.5,s_Intake));
    OutButton.whileTrue(new Intakecom(-.6,s_Intake));

    flapButton.whileTrue(new AMPmechcom(s_AMP,1,false));
    flapButton.onFalse(new AMPmechcom(s_AMP,1,true));

    shooterButton.whileTrue(new SHOOT(s_SHooter,.7));

    rdclimbButton.whileTrue(new rightclimbcom(-.5, s_rightClimber));
    rclimbButton.whileTrue(new rightclimbcom(.5, s_rightClimber));

    ldclimbButton.whileTrue(new leftclimbcom(-.5, s_leftClimber));
    lclimbButton.whileTrue(new leftclimbcom(.5, s_leftClimber));


    UmoveshooterButton.whileTrue(new moveshootercommand(1, s_Move));
    DmoveshooterButton.whileTrue(new moveshootercommand(-1, s_Move));

   
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
   // return twoPiece;
    
    
    // An ExampleCommand will run in autonomous
   // return new twoPiece();
  }
}
