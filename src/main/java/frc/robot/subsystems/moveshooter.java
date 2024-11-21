// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class moveshooter extends SubsystemBase {
private CANSparkMax move;
  /** Creates a new moveshooter. */
  public moveshooter() {
    move = new CANSparkMax (54,MotorType.kBrushed);
  }
  public void Movement(double speed){
   move.set(speed);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
