package RobotMovements;

// Định nghĩa một interface cho các hành động của robot
interface Robot {
    void turnRight();

    void turnLeft();

    void advance();

    String getPosition();
}

// Implement interface cho một loại robot cụ thể
class SimpleRobot implements Robot {
    private int x;
    private int y;
    private Direction direction;

    // Direction là một enum định nghĩa hướng của robot (north, east, south, west)
    enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    // Constructor để khởi tạo robot ở một vị trí và hướng cụ thể
    public SimpleRobot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void turnRight() {
        direction = Direction.values()[(direction.ordinal() + 1) % Direction.values().length];
    }

    @Override
    public void turnLeft() {
        direction = Direction.values()[(direction.ordinal() + 3) % Direction.values().length];
    }

    @Override
    public void advance() {
        switch (direction) {
            case NORTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case SOUTH:
                y--;
                break;
            case WEST:
                x--;
                break;
        }
    }

    @Override
    public String getPosition() {
        return "{" + x + ", " + y + "} facing " + direction;
    }
}

public class Main {
    public static void main(String[] args) {
        // Tạo một robot mới ở vị trí {7, 3} và hướng north
        SimpleRobot robot = new SimpleRobot(7, 3, SimpleRobot.Direction.NORTH);

        // Thực hiện chuỗi lệnh "RAALAL"
        String instructions = "RAALAL";
        for (char instruction : instructions.toCharArray()) {
            executeInstruction(robot, instruction);
        }

        // In ra vị trí cuối cùng của robot
        System.out.println("Final position: " + robot.getPosition());
    }

    // Hàm thực hiện một lệnh cho robot
    private static void executeInstruction(Robot robot, char instruction) {
        switch (instruction) {
            case 'R':
                robot.turnRight();
                break;
            case 'L':
                robot.turnLeft();
                break;
            case 'A':
                robot.advance();
                break;
            default:
                System.out.println("Unknown instruction: " + instruction);
        }
    }
}

