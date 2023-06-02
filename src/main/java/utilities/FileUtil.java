package utilities;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class FileUtil {
  public static String getAbsoluteFilePathFromResoursesAsString(String name)
      throws URISyntaxException {
    URL res = FileUtil.class.getClassLoader().getResource(name);
    assert res != null;
    File file = Paths.get(res.toURI()).toFile();
    return file.getAbsolutePath();
  }
}
