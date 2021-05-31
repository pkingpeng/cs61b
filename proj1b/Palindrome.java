/**
 * @file: Palindrome.java
 * @time: 2021/5/30 4:22 PM
 * @Author by Pking
 */
public class Palindrome {
    /**
     * make word to word character deque
     **/
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            charDeque.addLast(word.charAt(i));
        }
        return charDeque;
    }

    /**
     * use recursive method to judge
     **/
    public boolean isPalindrome(String word) {
        Deque<Character> characterDeque = wordToDeque(word);
        int low = 0;
        int high = characterDeque.size() - 1;
        int length = characterDeque.size();
        return isPalindromeHelper(low, high, length, characterDeque);

    }

    private boolean isPalindromeHelper(int low, int high, int length, Deque characterDeque) {
        if (length == 0 || length == 1) {
            return true;
        }

        if (characterDeque.get(low) != characterDeque.get(high)) {
            return false;
        }

        return isPalindromeHelper(low + 1, high - 1, length - 2, characterDeque);
    }
    /** off by one */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> characterDeque = wordToDeque(word);
        while (characterDeque.size() > 1) {
            if (!cc.equalChars(characterDeque.get(0), characterDeque.get(characterDeque.size() - 1))) {
                return false;
            }
            characterDeque.removeFirst();
            characterDeque.removeLast();
        }
        return true;
    }
}
