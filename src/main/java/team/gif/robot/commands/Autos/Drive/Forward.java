package team.gif.robot.commands.Autos.Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

public class Forward extends CommandBase {

    double initalTime;

    double Time;
    public Forward(double time) {
        super();
        addRequirements(Robot.drivetrain); // uncomment
        Time = time;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        initalTime = Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        //Robot.drivetrain.Tank(0.2,0.2);
        Robot.drivetrain.Motor_R.set(ControlMode.PercentOutput,0.2);
        Robot.drivetrain.Motor_L.set(ControlMode.PercentOutput,-0.2);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {

        return (Timer.getFPGATimestamp() > initalTime + Time);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
