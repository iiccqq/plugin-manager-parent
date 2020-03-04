package com.test.plugin;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {

  public void version1() throws Exception {

    URL[] urls = new URL[2];
    urls[0] = new File("/Users/fengchuang/ideawork/v2.4/plugin-manager-parent/plugin1/target/plugin1-1.0-SNAPSHOT.jar").toURL();
    urls[1] = new File("/Users/fengchuang/ideawork/v2.4/plugin-manager-parent/plugin-common/target/plugin-common-1.0-SNAPSHOT.jar").toURL();
    URLClassLoader cl1 = new URLClassLoader(urls, null);
   // cl1.loadClass("com.test.plugin.Plugin1").newInstance();
    Object obj1 = cl1.loadClass("com.test.plugin.Plugin1").newInstance();
    Method m1 = obj1.getClass().getMethod("getName", new Class[]{});
    Object name = m1.invoke(obj1, new Object[]{});

    System.out.println(name);
  }

  public void version2() throws Exception {
    URL[] urls = new URL[2];
    urls[0] = new File("/Users/fengchuang/ideawork/v2.4/plugin-manager-parent/plugin2/target/plugin2-1.0-SNAPSHOT" +
        ".jar").toURL();
    urls[1] = new File("/Users/fengchuang/ideawork/v2.4/plugin-manager-parent/plugin-common/target/plugin-common-1.0-SNAPSHOT.jar").toURL();

    URLClassLoader cl1 = new URLClassLoader(urls, null);
  //  cl1.loadClass("com.test.plugin.Plugin2").newInstance();
    Object obj1 = cl1.loadClass("com.test.plugin.Plugin1").newInstance();


    Method m1 = obj1.getClass().getMethod("getName", new Class[]{});
    Object name = m1.invoke(obj1, new Object[]{});

    System.out.println(name);


    Plugin plugin = (Plugin)obj1;
    System.out.println(plugin.getName());

  }

  public static void main(String[] args) {
    try {
      PluginManager pluginManager = new PluginManager();
      pluginManager.version1();
      pluginManager.version2();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
