// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Elevator extends SubsystemBase {
  public static TalonSRX CIM_motor = new TalonSRX(RobotMap.ELEVATOR_CIM);
  private final double MAX = 14800;
  private final double MIN = 0;

  public Elevator()  {
    CIM_motor.configFactoryDefault();
    CIM_motor.setNeutralMode(NeutralMode.Brake);
    CIM_motor.setSensorPhase(true);
    CIM_motor.setInverted(true);
    CIM_motor.configSelectedFeedbackSensor(TalonSRXFeedbackDevice.CTRE_MagEncoder_Absolute.toFeedbackDevice());
    CIM_motor.configForwardSoftLimitThreshold(MAX);
    CIM_motor.configReverseSoftLimitThreshold(MIN);
    CIM_motor.configReverseSoftLimitEnable(true);
    CIM_motor.configForwardSoftLimitEnable(true);
    CIM_motor.setSelectedSensorPosition(0.0);
    CIM_motor.config_kP(0,0.05);
  }

  public double Get_Encoder_Position(){
    return CIM_motor.getSelectedSensorPosition();
  }
  public void Set_Zero(){
    CIM_motor.setSelectedSensorPosition(MIN);
  }
  public void Motor_Turn(double output) {

    double pos = Get_Encoder_Position();
    //if ((MAX < pos && output > 0) || (pos < MIN && output < 0)) output = 0;
    CIM_motor.set(ControlMode.PercentOutput, output);
  }

  public void goToPosition(double position) {
    CIM_motor.set(ControlMode.MotionMagic,position);
  }

}
