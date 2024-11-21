// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class leftclimber extends SubsystemBase {
  private CANSparkMax left;
  
  /** Creates a new climber. */
  public leftclimber() {
    left = new CANSparkMax(56,MotorType.kBrushless);
  }
  public void setclimberleft(double speed){
    left.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
