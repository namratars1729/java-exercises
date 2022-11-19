import java.util.stream.Stream;

public class Scratch {
    public static void main(String[] args) {
        Stream<Long> numStreamThroughIterate = Stream.iterate(4l, n -> n + 2l)
                                                     .limit(5);
        numStreamThroughIterate.forEach(s -> System.out.println(s));
    }
}
