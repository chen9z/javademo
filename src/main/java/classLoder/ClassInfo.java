package classLoder;

public class ClassInfo {

    private long loadTime;

    private BaseManager myManager;

    private MyClassLoader myClassLoader;


    public ClassInfo(MyClassLoader myClassLoader,  long loadTime) {
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getMyManager() {
        return myManager;
    }

    public void setMyManager(BaseManager myManager) {
        this.myManager = myManager;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }
}
