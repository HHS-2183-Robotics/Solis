// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intakepivot;

public class pivotintake extends Command {
  double speed;
  intakepivot s_IntakePivot;
  double posNum;
  boolean returning;
  double IntakePos;
  /** Creates a new pivotintake. */
  public pivotintake(intakepivot s_IntakePivot, double posNum, boolean returning) {
    addRequirements(s_IntakePivot);
    this.s_IntakePivot = s_IntakePivot;
    this.posNum = posNum;
    this.returning = returning;
    //this.speed = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(posNum == 1){
      IntakePos = -5.25;
    } else if (posNum == 2){
      IntakePos = -5.25;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(returning){
      
      s_IntakePivot.setIntakePosition(-1);
    } else{

      s_IntakePivot.setIntakePosition(IntakePos);
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
