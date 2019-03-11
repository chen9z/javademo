package classLoder;

public class LoaderTest {


    public static void main(String args[]) {
        new Thread(new MsgHandler()).start();
    }
}
