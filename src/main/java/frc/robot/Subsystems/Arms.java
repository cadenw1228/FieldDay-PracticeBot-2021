package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Framework.Subsystem;
import frc.robot.Framework.IO.In.inTemp;
import frc.robot.Robot;

public class Arms implements Subsystem{
    TalonSRX leftArm = new TalonSRX(9);
    TalonSRX rightArm = new TalonSRX(1);
    private inTemp Input = new inTemp();

    public void robotInit(){
        System.out.println("Arms init");
    }

    public void robotPeriodic(){

    }

    public void autonomousInit(){

    }
    public void autonomousPeriodic(){
        
    }

    public void teleopInit(){

    }

    public void teleopPeriodic(){
        if(Input.getButton(7) == true && Input.getButton(8) == true){
            leftArm.set(ControlMode.PercentOutput, 1);
            rightArm.set(ControlMode.PercentOutput, 1);
        }else if(Input.getButton(9) == true && Input.getButton(10) == true){
            leftArm.set(ControlMode.PercentOutput, -1); 
            rightArm.set(ControlMode.PercentOutput, -1);
        }else if(Input.getButton(7) == true){
            leftArm.set(ControlMode.PercentOutput, 1);
        }else if(Input.getButton(8) == true){
            rightArm.set(ControlMode.PercentOutput, 1);
        }else if(Input.getButton(10) == true){
            leftArm.set(ControlMode.PercentOutput, -1);
        }else if(Input.getButton(9) == true){
            rightArm.set(ControlMode.PercentOutput, -1);
        }else{
            leftArm.set(ControlMode.PercentOutput, 0);
            rightArm.set(ControlMode.PercentOutput, 0);
        }
    }
}