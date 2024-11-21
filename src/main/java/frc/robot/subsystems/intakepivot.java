// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.ControlType;


public class intakepivot extends SubsystemBase {
  private CANSparkMax pivotintake;
  private RelativeEncoder pivotintakeencoder;
  private SparkPIDController pivotintakePID;
  private boolean check;


  /** Creates a new intakepivot. */
  public intakepivot() {
    pivotintake = new CANSparkMax(53,MotorType.kBrushless);

    pivotintakeencoder = pivotintake.getEncoder();

    pivotintakePID = pivotintake.getPIDController();

    pivotintakePID.setOutputRange(-30, 30);
    pivotintakePID.setSmartMotionMaxVelocity(4,0);
    pivotintakePID.setSmartMotionMaxAccel(3,0);

    pivotintakePID.setSmartMotionAllowedClosedLoopError(1,0);

    pivotintakePID.setFF(.06);
  }

  public void runPivotIntake(double speed){
    pivotintake.set(speed);
  }
  public boolean setIntakePosition (double pos){
    pivotintakePID.setReference(pos, ControlType.kSmartMotion);

    if(Math.abs(Math.abs(pos) - Math.abs(pivotintakeencoder.getPosition())) < 2){
      check = true;
      return true;
    }else{
      check = false;
      return false;
    }

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
