public class PalindromeFinder {
    public static void main(String[] args) {
        CharacterComparator offByOne = new OffByOne();
        CharacterComparator offByN = new OffByN(5);
        int minLength = 4;
        In in = new In("library-fa20-master/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, offByN)) {
                System.out.println(word);
            }
        }
    }
}
