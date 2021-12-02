package frc.robot.Framework.IO.In;

import edu.wpi.first.wpilibj.Joystick;

public class inTemp {
    Joystick joystick = new Joystick(0);
    public boolean getButton(Integer buttonInteger) {
        return joystick.getRawButton(buttonInteger);
        // ControllerWrapper requestedController = controllers.get(controller);
        // return requestedController.getButton(function, id);
    }

    public double getAxis(Integer axisInteger){
        return joystick.getRawAxis(axisInteger);
        // ControllerWrapper requestedController = controllers.get(controller);
        // return requestedController.getAxis(function, id);
    }

}
