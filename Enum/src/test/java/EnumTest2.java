import com.zhang.Enum1;

/**
 * 测试枚举的一些常见用法
 */
public class EnumTest2 {
    enum Signal {RED,GREEN,YELLOW}

    public static String getTrafficeInstruct(Signal signal){
        String instruct = "信号灯";
        switch (signal){
            case RED:
                instruct = "红灯停";
                break;
            case GREEN:
                instruct = "绿灯行";
                break;
            case YELLOW:
                instruct = "黄灯请注意";
                break;
            default:
                break;
        }
        return instruct;
    }

    public static void main(String[] args) {
        Signal red = Signal.RED;
        String single = getTrafficeInstruct(Signal.RED);
        System.out.println(single);
    }

}
