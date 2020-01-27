
/*
Class Name:
- Applies to Subsystems, Commands, Constructors
- It should start with the uppercase letter.
- It should be a noun such as Color, Button, System, Thread, etc.
- Use appropriate words, instead of acronyms.

Method Name:
- Applies to 
- It should start with lowercase letter.
- It should be a verb such as main(), print(), println().
- If the name contains multiple words, start it with a lowercase letter followed by an uppercase letter such as actionPerformed().

Field (Member or Variable) Name:
- Applies to
- It should start with a lowercase letter such as id, name.
- It should not start with the special characters like & (ampersand), $ (dollar), _ (underscore).
- If the name contains multiple words, start it with the lowercase letter followed by an uppercase letter such as firstName, lastName.
- Avoid using one-character variables such as x, y, z.

Constant:
- It should be in uppercase letters such as RED, YELLOW.
- If the name contains multiple words, it should be separated by an underscore(_) such as MAX_PRIORITY.
- It may contain digits but not as the first letter.

*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
Describe the class here.
 */
public class DriveForwardCommand extends Command {          //--> Class Name "DriveForwardCommand"
    static final int MAX_COUNT = 18;                        //--> Constant
    private int count = 0;                                  //--> private member or variable

    public DriveForwardCommand() {                          //--> Constructor
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {                           //--> Method
        Robot.driveTrain.mmArbFeedForwardInit();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {                              //--> Method
        Robot.driveTrain.mmArbFeedForward();
        count += 1;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {                        //--> Method
        return isCanceled();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {                                  //--> Method
        Robot.driveTrain.StopAllMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {                          //--> Method
        end();
    }
}
