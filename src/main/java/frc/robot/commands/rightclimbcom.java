// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.rightclimber;

public class rightclimbcom extends Command {
  double speed;
  rightclimber s_rightClimber;
  
  public rightclimbcom(double speed, rightclimber s_rightClimber) {
    addRequirements (s_rightClimber);
    this.s_rightClimber = s_rightClimber;
    this.speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_rightClimber.setclimberright(speed);
  }

  
  



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_rightClimber.setclimberright(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}