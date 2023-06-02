package utilities;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtil {
  public static Set<Integer> getSetOfRandomUniqueNumbers(int quantity, int upperExcludedBound) {
    Set<Integer> setOfNumbers = new HashSet<>();
    int count = 0;
    Random random = new Random();
    while (count < quantity) {
      int randomNumber = random.nextInt(upperExcludedBound);
      if (!setOfNumbers.contains(randomNumber)) {
        setOfNumbers.add(randomNumber);
        count++;
      }
    }
    return setOfNumbers;
  }

  public static String getRandomStringWithCyrillic(int length, String randomEmail) {
    String cyrillicAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    String numbers = "0123456789";
    Random random = new Random();
    int randomIndexForCyrillic = random.nextInt(cyrillicAlphabet.length());
    int randomIndexForNumbers = random.nextInt(numbers.length());
    int randomIndexForEmail = random.nextInt(randomEmail.length());
    String generatedPassword = RandomStringUtils.randomAlphanumeric(length);
    generatedPassword += cyrillicAlphabet.charAt(randomIndexForCyrillic);
    generatedPassword += randomEmail.charAt(randomIndexForEmail);
    generatedPassword += numbers.charAt(randomIndexForNumbers);
    return generatedPassword;
  }
}
