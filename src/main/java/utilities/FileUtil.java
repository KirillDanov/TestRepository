package utilities;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class FileUtil {
  private FileUtil() {}

  public static String getAbsoluteFilePathFromResourcesAsString(String name) {
    URL res = FileUtil.class.getClassLoader().getResource(name);
    try {
      assert res != null;
      File file = Paths.get(res.toURI()).toFile();
      return file.getAbsolutePath();
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException("Invalid URI syntax: " + res, e);
    }
  }
}
