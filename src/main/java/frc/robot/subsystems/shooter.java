// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class shooter extends SubsystemBase {
  private CANSparkMax left;
  private CANSparkMax right;


  /** Creates a new shooter. */
  public shooter() {
    left = new CANSparkMax(50,MotorType.kBrushless);
    right = new CANSparkMax(51,MotorType.kBrushless);

  }
  public void Shooter(double speed){
    left.set(-speed);
    right.set(speed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
