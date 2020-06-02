import com.zhang.Enum1;

/**
 * 测试枚举的一些常见用法
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println("=========== Print all Person ===========");
        //返回 enum 实例的数组，而且该数组中的元素严格保持在 enum 中声明时的顺序。
        for (Enum1 value : Enum1.PERSON1.values()) {
            System.out.println(value + "===>"+value.ordinal());
        }
        System.out.println("返回实例名（枚举常量的名字）"+ Enum1.PERSON1.name());
        System.out.println("返回实例所属的 enum 类型。"+ Enum1.PERSON1.getDeclaringClass());
        System.out.println("把枚举常量转换成字符串:"+Enum1.PERSON1.toString());
        Enum1 person1 = Enum1.PERSON1;
        System.out.println(person1);
        System.out.println("判断是否为同一个对象。" + person1.equals("PERSON1"));

    }
}
