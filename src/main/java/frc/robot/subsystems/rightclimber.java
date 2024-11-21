// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class rightclimber extends SubsystemBase {
  private CANSparkMax right;
  /** Creates a new climber. */
  public rightclimber() {
    right = new CANSparkMax(55,MotorType.kBrushless);
  }
  public void setclimberright(double speed){
    right.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
