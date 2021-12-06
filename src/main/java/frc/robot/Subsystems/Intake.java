package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Framework.Subsystem;



public class Intake implements Subsystem {
    
    TalonSRX m = new TalonSRX(10);
    Joystick controller = new Joystick(0);



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
        if(controller.getRawButton(2) == true){
            m.set(ControlMode.PercentOutput, 1);
        }else if(controller.getRawButton(3) == true){
            m.set(ControlMode.PercentOutput, -1); 
        }else{
            m.set(ControlMode.PercentOutput, 0);
        }
    }
}