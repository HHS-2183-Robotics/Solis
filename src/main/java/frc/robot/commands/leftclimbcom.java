// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.leftclimber;

public class leftclimbcom extends Command {
  double speed;
  leftclimber s_leftClimber;
  
  public leftclimbcom(double speed, leftclimber s_leftClimber) {
    addRequirements (s_leftClimber);
    this.s_leftClimber = s_leftClimber;
    this.speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_leftClimber.setclimberleft(speed);

  }

  
  



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_leftClimber.setclimberleft(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
