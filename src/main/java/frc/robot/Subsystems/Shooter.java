package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.Framework.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.PWMSparkMax;
import frc.robot.Framework.IO.In.inTemp;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.PWM.PeriodMultiplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMSpeedController;


public class Shooter implements Subsystem {
    private static final int deviceID = 6;
    
    
    CANSparkMax m_motor = new CANSparkMax(deviceID, MotorType.kBrushless);

    TalonSRX s_lr = new TalonSRX(8);
    private inTemp input = new inTemp();
    
    public void robotInit(){
        m_motor = new CANSparkMax(deviceID, MotorType.kBrushless);

    /**
     * The restoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    m_motor.restoreFactoryDefaults();

    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    
        
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
        if(input.getButton(5) == true){
            System.out.println("OKAY");
            s_lr.set(ControlMode.PercentOutput, .2); 
        }
        else if(input.getButton(6)){
            s_lr.set(ControlMode.PercentOutput, -.2);
        }
        else{
            s_lr.set(ControlMode.PercentOutput, 0);

        }
        if(input.getAxis(3)>= .1){
            System.out.println(input.getAxis(3));
            m_motor.set(-1*input.getAxis(3));

        }
        else{
            m_motor.set(0);


        }
            

        
    }
}