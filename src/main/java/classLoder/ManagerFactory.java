package classLoder;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ManagerFactory {
    private static final Map<String, ClassInfo> classInfoMap = new HashMap<String, ClassInfo>();

    public static final String CLASS_PATH = "D:\\repo\\ideaProject\\javademo\\target\\class";

    public static final String MY_MANAGER = "classLoder.MyManager";

    public static BaseManager getManager(String className) throws Exception {
        File fileLoad = new File(CLASS_PATH + className.replaceAll("\\.","/")+ ".class");
        long lastModified = fileLoad.lastModified();
        System.out.println("时间：" + lastModified);
        if (classInfoMap.get(className) == null) {
            load(className, lastModified);
        } else if (classInfoMap.get(className).getLoadTime() != lastModified) {
            load(className, lastModified);
        }
        return classInfoMap.get(className).getMyManager();
    }

    private static void load(String className, long lastModified) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoader.loadClass(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseManager baseManager = newInstance(loadClass);
        ClassInfo classInfo = new ClassInfo(myClassLoader, lastModified);
        classInfo.setMyManager(baseManager);
        classInfoMap.put(className, classInfo);

    }

    private static BaseManager newInstance(Class<?> loadClass) throws Exception {
        return ((BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{}));
    }
}
