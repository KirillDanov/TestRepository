package utilities;

import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {
  private static final Random random = new Random();
  private RandomUtil(){}

  public static Set<Integer> getSetOfRandomUniqueNumbers(
      int quantity, int upperExcludedBound, List<Integer> excludedNumbers) {
    Set<Integer> setOfNumbers = new HashSet<>();
    while (setOfNumbers.size() < quantity) {
      int randomNumber = getRandom().nextInt(upperExcludedBound);
      if (!setOfNumbers.contains(randomNumber) && !excludedNumbers.contains(randomNumber)) {
        setOfNumbers.add(randomNumber);
      }
    }
    return setOfNumbers;
  }

  public static Random getRandom() {
    return random;
  }

  public static String getRandomStringWithCyrillic(int length, String randomEmail) {
    String cyrillicAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    String numbers = "0123456789";
    Random random = getRandom();
    return RandomStringUtils.randomAlphanumeric(length) +
            cyrillicAlphabet.charAt(random.nextInt(cyrillicAlphabet.length())) +
            randomEmail.charAt(random.nextInt(randomEmail.length())) +
            numbers.charAt(random.nextInt(numbers.length()));
  }
}
