package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.PWMSparkMax;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Framework.Subsystem;
import frc.robot.Framework.IO.In.inTemp;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Shooter implements Subsystem {
    private static final int deviceID = 6;
    private inTemp Input = new inTemp();

    TalonSRX rotate = new TalonSRX(8);
    CANSparkMax m_motor = new CANSparkMax(deviceID, MotorType.kBrushless);



    public void robotInit(){
        System.out.println("Shooter init");
        m_motor = new CANSparkMax(deviceID, MotorType.kBrushless);

        m_motor.restoreFactoryDefaults();

    }

    public void robotPeriodic(){

    }

    public void autonomousInit(){


    }
    public void autonomousPeriodic(){
	@@ -25,6 +51,45 @@ public void teleopInit(){
    }

    public void teleopPeriodic(){

        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        //read values periodically
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);

        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);

        if(Input.getButton(5) == true){
            rotate.set(ControlMode.PercentOutput, -0.2);

        }else if(Input.getButton(6) == true){
            rotate.set(ControlMode.PercentOutput, 0.2); 

        }else{
            rotate.set(ControlMode.PercentOutput, 0);
        }

        m_motor.set(Input.getAxis(3) * -1);

        if(Input.getAxis(2) > 0){
            if(x > 0){
                rotate.set(ControlMode.PercentOutput, 0.15);
                SmartDashboard.putNumber("Direcetion", 1);
            }else if(x < 0){
                rotate.set(ControlMode.PercentOutput, -0.15);
                SmartDashboard.getNumber("Direcetion", -1);
            }else{
                rotate.set(ControlMode.PercentOutput, 0);
                SmartDashboard.getNumber("Direcetion", 0);
            }
        }
    }
}

