// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intake extends SubsystemBase {
  private CANSparkMax Intake;
  /** Creates a new intake. */
  public intake() {
    Intake = new CANSparkMax(52,MotorType.kBrushless);
  }
  public void runintake(double speed){
    Intake.set(speed);
  }
   

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
