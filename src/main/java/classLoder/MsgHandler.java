package classLoder;

public class MsgHandler implements Runnable {

    public void run() {
        while (true) {
            try {
                BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
                manager.log();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
