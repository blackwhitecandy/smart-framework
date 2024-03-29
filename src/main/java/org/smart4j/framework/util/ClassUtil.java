package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class ClassUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * get class loader
     * @return
     */
    public static ClassLoader getClassLoad() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass (String className) {
        return ClassUtil.loadClass(className, false);
    }
    /**
     * load class
     * @param className
     * @param isInitialized
     * @return
     */
    public static Class<?> loadClass (String className, boolean isInitialized) {
        Class<?> cls;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            LOGGER.error("load class failure, class not found", e);
            throw new RuntimeException();
        }
        return cls;
    }

    /**
     * get all class belong to the package name
     * @param packageName
     * @return
     */
    public static Set<Class<?>> getClassSet (String packageName) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls = getClassLoad().getResources(packageName.replace(".","/"));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        String packagePath = url.getPath().replaceAll("20%", " ");
                        addClass(classSet, packagePath, packageName);
                    } else if (protocol.equals("jar")) {
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        if (jarURLConnection != null) {
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if (jarFile != null) {
                                Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                                while (jarEntryEnumeration.hasMoreElements()) {
                                    JarEntry jarEntry = jarEntryEnumeration.nextElement();
                                    String jarEntryName = jarEntry.getName();

                                    if (jarEntryName.endsWith(".class")) {
                                        String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
                                        doAddClass(classSet, className);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classSet;
    }

    /**
     * add all class file and loop directory
     * @param classSet
     * @param packagePath
     * @param packageName
     */
    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (pathname.isFile() && pathname.getName().endsWith(".class")) || pathname.isDirectory();
            }
        });

        for (File file : files) {
            String fileName = file.getName();
            if (file.isFile()) {
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                //concact
                if (!packageName.isEmpty()) {
                    className = packageName + "." + className;
                }
                doAddClass(classSet, className);

            } else {
                String subPackagePath = fileName;
                if (!packagePath.isEmpty()) {
                    subPackagePath = packagePath + "." + subPackagePath;
                }
                addClass(classSet, packagePath, packageName);
            }
        }

    }

    /**
     * add class by className with path
     * @param classSet
     * @param className
     */
    private static void doAddClass(Set<Class<?>> classSet, String className){
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }
}
