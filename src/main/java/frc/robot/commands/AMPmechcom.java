// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Ampmech;

public class AMPmechcom extends Command {
  double speed;
  Ampmech s_AMP;
  double posNum;
  boolean returning;
  double ampPos;
  /** Creates a new AMPmechcom. */
  public AMPmechcom(Ampmech s_AMP, double posNum, boolean returning) {
     addRequirements(s_AMP);
    this.s_AMP = s_AMP;
    this.posNum = posNum;
    this.returning = returning;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {if(posNum == 1){
      ampPos = 3.8;
    } else if (posNum == 2){
      ampPos = -5.25;
    }
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     if(returning){
      
      s_AMP.setflapPosition(1);
    } else{

      s_AMP.setflapPosition(ampPos);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
