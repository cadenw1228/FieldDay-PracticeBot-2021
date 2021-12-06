package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Framework.Subsystem;
import frc.robot.Robot;
public class Hopper implements Subsystem {
    TalonSRX m = new TalonSRX(0);
    //Joystick controller = new Joystick(0);



    public void robotInit(){
        System.out.println("Intake init");
        //controller = new Joystick(0);
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
        // if(controller.getRawButton(6) == true){
        //     m.set(ControlMode.PercentOutput, 1);
        // }else if(controller.getRawButton(5) == true){
        //     m.set(ControlMode.PercentOutput, -1); 
        // }else{
        //     m.set(ControlMode.PercentOutput, 0);
        // }
    }
}