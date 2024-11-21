// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Ampmech extends SubsystemBase {
  private CANSparkMax flap;
  private RelativeEncoder flapencoder;
  private SparkPIDController flapPID;
  private boolean check;
  
  /** Creates a new Ampmech. */
  public Ampmech() {
    flap = new CANSparkMax(57,MotorType.kBrushless);

    flapencoder = flap.getEncoder();

    flapPID = flap.getPIDController();

    flapPID.setOutputRange(-30, 30);
    flapPID.setSmartMotionMaxVelocity(2,0);
    flapPID.setSmartMotionMaxAccel(2,0);

    flapPID.setSmartMotionAllowedClosedLoopError(1,0);

   flapPID.setFF(.06);
  }

  public void runPivotIntake(double speed){
    flap.set(speed);
  }
  public boolean setflapPosition (double pos){
    flapPID.setReference(pos, ControlType.kSmartMotion);

    if(Math.abs(Math.abs(pos) - Math.abs(flapencoder.getPosition())) < 2){
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
