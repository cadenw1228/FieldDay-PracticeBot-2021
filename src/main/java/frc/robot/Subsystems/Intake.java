package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Framework.Subsystem;
import frc.robot.Framework.IO.In.inTemp;



public class Intake implements Subsystem {
    
    TalonSRX top = new TalonSRX(0);
    TalonSRX bottom = new TalonSRX(4);
    private inTemp Input = new inTemp();
    



    public void robotInit(){
        System.out.println("Intake init");
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
        if(Input.getButton(2) == true){
            top.set(ControlMode.PercentOutput, 1);
            bottom.set(ControlMode.PercentOutput, -1);
        }else if(Input.getButton(3) == true){
            top.set(ControlMode.PercentOutput, -1); 
            bottom.set(ControlMode.PercentOutput, 1);
        }else{
            top.set(ControlMode.PercentOutput, 0);
            bottom.set(ControlMode.PercentOutput, 0);
        }
    }
}