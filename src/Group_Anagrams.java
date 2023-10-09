public class Group_Anagrams {
            public static void main(String[] args) {
                String[] words = {"tar", "rat", "banana", "art", "nanaba", "abc", "cda"};
                groupAnagrams(words);
            }

            public static void groupAnagrams(String[] words) {
                int[] grouped = new int[words.length];
                for (int i = 0; i < words.length; i++) {
                    if (grouped[i] == 0) {
                        int groupSize = 1;
                        System.out.print("Anagrams: {" + words[i]);
                        for (int j = i + 1; j < words.length; j++) {
                            if (grouped[j] == 0 && areAnagrams(words[i], words[j])){
                                System.out.print(", " + words[j]);
                                grouped[j] = groupSize;
                                groupSize++;
                            }
                        }
                        if (groupSize > 1) {
                            System.out.println("}");
                        } else {
                            System.out.println("}");
                            System.out.println("Others: {" + words[i] + "}");
                        }
                    }
                }
            }

            public static boolean areAnagrams(String word1, String word2) {
                if (word1.length() != word2.length()) {
                    return false;
                }

                int[] charCount = new int[26];

                for (int i = 0; i < word1.length(); i++) {
                    charCount[word1.charAt(i) - 'a']++;
                    charCount[word2.charAt(i) - 'a']--;
                }

                for (int count : charCount) {
                    if (count != 0) {
                        return false;
                    }
                }

                return true;
            }
        }



