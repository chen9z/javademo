package classLoder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath) {
        super(ClassLoader.getSystemClassLoader());
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] data = this.loadData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    public byte[] loadData(String name) {
        name = name.replace(".", "//");
        String path = classPath + name + ".class";

        try {
            FileInputStream is = new FileInputStream(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = is.read()) != -1) {
                baos.write(b);
            }
            is.close();
            return baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
