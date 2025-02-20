package ac.za.tut.textspectaclessb.lb;

import ac.za.tut.exception.EmptyValueException;
import ac.za.tut.exception.MessageContainsDigitsException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;

@Stateless
public class TextSpectaclesEJB implements TextSpectaclesEJBLocal {

    @Override
    public Map<String, Integer> frequencyWordsOccurrence(String message) throws EmptyValueException, MessageContainsDigitsException {

        
         isValidMessage(message);

         List<String> words = wordsList(message);

         return countWordsOccurence(words);

    }

    private void isValidMessage(String text) throws EmptyValueException, MessageContainsDigitsException {

        char[] textCharacters = text.toCharArray();

        if (text.isEmpty()) {

            throw new EmptyValueException("Empty Message please enter a value");
        } else {

            for (char charAtindex : textCharacters) {

                if (Character.isDigit(charAtindex)) {
                    throw new MessageContainsDigitsException("Message cannot contain digits");
                }
            }

        }

    }

    private Map<String, Integer> countWordsOccurence(List<String> wordsList) {

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : wordsList) {

            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }

        }
        return wordsMap;
    }

    private List<String> wordsList(String message) {

        return Arrays.asList(message.split("\\s+"));

    }
}
