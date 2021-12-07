package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Framework.Subsystem;
import frc.robot.Framework.IO.In.inTemp;


public class Chassis implements Subsystem {
    private inTemp Input = new inTemp();
    WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(11);
    WPI_TalonSRX m_rearLeft = new WPI_TalonSRX(12);
    SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
 
    WPI_TalonSRX m_frontRight = new WPI_TalonSRX(2);
    WPI_TalonSRX m_rearRight = new WPI_TalonSRX(3);
    SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
 
    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
    

    public void robotInit(){
        System.out.println("Chassis init");

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
        m_drive.tankDrive(Input.getAxis(1) * -1, Input.getAxis(5) * -1);

        
    }
}