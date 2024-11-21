// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter;

public class SHOOT extends Command {
  double speed;
  shooter s_SHooter;
  

  public SHOOT(shooter s_SHooter, double speed) {
   addRequirements(s_SHooter);
   this.s_SHooter = s_SHooter;
   this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    s_SHooter.Shooter(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_SHooter.Shooter(0);
  }

  // Returns true when the command should end
  @Override
  public boolean isFinished() {
    return false;
  }
}
