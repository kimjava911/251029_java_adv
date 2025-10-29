// Record
public class Example07 {
    public static void main(String[] args) {
        DataClass person = new DataClass("이름", 123);
        DataRecord person2 = new DataRecord("이름", 123);
        System.out.println(person.getAge());
        System.out.println(person.getName());
        System.out.println(person2.name());
        System.out.println(person2.age());
    }
}

// lombok <- 의존성.
// 은닉. (private) -> 접근자 -> boilerplate (강제되는 복잡한 틀)
class DataClass {
//    String name;
//    int age;
    // 불변객체 -> 데이터를 변경하는게 아니라 한 번 받고 끝내는 객체...
    private final String name;
    private final int age;

    public DataClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// [] record 이름(생성자형태로 필드들을 집어넣게됨) { ??? 메서드, static 메서드 }
// -> getter 자동생성. -> setter X. 필드는 다 final.
record DataRecord(String name, int age) {}