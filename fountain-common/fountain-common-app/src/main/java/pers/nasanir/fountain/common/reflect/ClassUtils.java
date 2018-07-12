package pers.nasanir.fountain.common.reflect;

import com.fasterxml.jackson.databind.util.ClassUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarFile;

public class ClassUtils {
    private static ClassLoader cl = null;
    private static HashMap<String, Class<?>> classMap = new HashMap<String, Class<?>>();

    public static ClassLoader getClassLoader() {
        if (cl == null) {
            try {
                cl = Thread.currentThread().getContextClassLoader();
                if (cl == null) {
                    cl = ClassUtils.class.getClassLoader();
                    if (cl == null)
                        cl = ClassLoader.getSystemClassLoader();
                }
            } catch (Exception e) {

            }
        }
        return cl;
    }

    public static Set getClassSet() throws IOException {
        String packageName = "pers/nasanir/fountain";
        getClassLoader();
        Enumeration resourceUrlEnum = cl.getResources(packageName);
        while (resourceUrlEnum.hasMoreElements()) {
            URL url = (URL) resourceUrlEnum.nextElement();
            String protocol = url.getProtocol();
            if (protocol.equals("file")) {
                String fileName = URLDecoder.decode(url.getFile(), "UTF-8");
                findClassbyFile(fileName, packageName);
            } else {

            }
        }
        Set<URL> set = new HashSet<>();
        return set;
    }

    public static void findClassbyFile(String path, String packageName) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] fileArr = file.listFiles();
                for (File childFile : fileArr) {
                    findClassbyFile(childFile.getPath(), packageName);
                }
            } else {
                if (file.getName().endsWith(".class")) {
                    String[] classNameArr = file.getPath().replace("\\", ".").split("classes.");
                    if (classNameArr.length > 1) {
                        classMap.put(classNameArr[1], LoadClass(classNameArr[1]));
                    }
                }
            }
        }
    }

    public static Class<?> LoadClass(String className) {
        try {
            getClassLoader();
            return cl.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
