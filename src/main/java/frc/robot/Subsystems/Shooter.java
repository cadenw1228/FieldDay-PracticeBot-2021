package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.Framework.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.PWMSparkMax;

public class Shooter implements Subsystem {
    
    Joystick controlla = new Joystick(0);
    
    PWMSparkMax shoo = new PWMSparkMax(6);
    TalonSRX s_lr = new TalonSRX(8);
    
    public void robotInit(){
        
        
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
        if(controlla.getRawButton(5) == true){
            System.out.println("OKAY");
            s_lr.set(ControlMode.PercentOutput, .2); 
        }
        else if(controlla.getRawButton(6)){
            s_lr.set(ControlMode.PercentOutput, -.2);
        }
        else{
            s_lr.set(ControlMode.PercentOutput, 0);

        }
        System.out.println(controlla.getRawAxis(3));
        if(controlla.getRawAxis(4)>= .1){
            shoo.set(.2);
        }
        else{
            shoo.set(0);
        }
            

        
    }
}