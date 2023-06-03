package utilities;

import java.net.URL;

public class FileUtil {
  private FileUtil(){}
  public static String getAbsoluteFilePathFromResourcesAsString(String name) {
    URL res = FileUtil.class.getClassLoader().getResource(name);
    assert res != null;
    return res.getPath();
  }
}
