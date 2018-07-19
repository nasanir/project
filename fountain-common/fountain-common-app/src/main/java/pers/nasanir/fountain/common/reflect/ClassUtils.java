package pers.nasanir.fountain.common.reflect;



import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
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
                JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
                findClassbyJar(jar,packageName);
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
                    String className="";
                    if (classNameArr.length > 1) {
                        className=classNameArr[1].replace(".class","");
                        if(loadClass(className)!=null)
                            classMap.put(className, loadClass(className));
                    }
                }
            }
        }
    }

    public static void findClassbyJar(JarFile jar,String packageName){
        Enumeration<JarEntry> entry=jar.entries();
        JarEntry jarEntry;
        String name,className;
        while (entry.hasMoreElements()){
            jarEntry=entry.nextElement();

            name=jarEntry.getName();
            if(jarEntry.isDirectory()||!name.startsWith(packageName)||!name.endsWith(".class")){
                continue;
            }
            className=name.replace(".class","");
            if(loadClass(className)!=null)
                classMap.put(className,loadClass(className));
        }
    }

    public static Class<?> loadClass(String className) {
        try {
            getClassLoader();
            return cl.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<String, Class<?>> getClassMap() {
        return classMap;
    }

    public static void setClassMap(HashMap<String, Class<?>> classMap) {
        ClassUtils.classMap = classMap;
    }

}
