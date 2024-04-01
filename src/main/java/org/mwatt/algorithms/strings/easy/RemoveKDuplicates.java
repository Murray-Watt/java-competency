package org.mwatt.algorithms.strings.easy;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDuplicates {
    static class Freq {
        public char letter;
        public int count;

        public Freq(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public String toString() {
            String str = String.valueOf(letter);
            return str.repeat(count);
        }
    }

    public String removeDuplicates(String s, int k) {

        Deque<Freq> letters = new LinkedList<>();

        for (int i=0; i < s.length(); i++) {
            char nextLetter = s.charAt(i);

            if (!letters.isEmpty() && letters.getLast().letter == nextLetter) {
                Freq last = letters.removeLast();
                int count = last.count + 1;

                if (count < k) {
                    letters.add(new Freq(last.letter,count));
                } /* else {
                    System.out.println(last.letter + " " + count);
                } */
            } else {
                letters.add(new Freq(s.charAt(i),1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!letters.isEmpty()) {
            sb.append(letters.pop().toString());
        }

        return sb.toString();
    }
}
