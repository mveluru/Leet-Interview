package leetcode75.easy;
//Problem:383

import leetcode75.medium.LinkedListSortedRemoveDups;

import java.util.Arrays;

public class RamsonNote {

    public void ramsonNote(String ramson,String magazine) {
        char[] ramsonNoteChars = ramson.toLowerCase().toCharArray();
        char[] magazineChars = magazine.toLowerCase().toCharArray();
        Arrays.sort(ramsonNoteChars);
        Arrays.sort(magazineChars);
       int ramsonNoteIndex = 0;
       int magazineIndex = 0;
        while (ramsonNoteIndex < ramsonNoteChars.length && magazineIndex < magazineChars.length) {
            if (ramsonNoteChars[ramsonNoteIndex] == magazineChars[magazineIndex]) {
            ramsonNoteIndex++;
            magazineIndex++;
            }else if(magazineChars[magazineIndex] < ramsonNoteChars[ramsonNoteIndex]){
                magazineIndex++;
            }else{
                break;
            }
        }
        System.out.println(ramsonNoteIndex == ramsonNoteChars.length);
    }
    public static void main(String[] args) {
        RamsonNote ramsonNote = new RamsonNote();
        ramsonNote.ramsonNote("aa","ab");
        ramsonNote.ramsonNote("aa","aab");
        ramsonNote.ramsonNote("aaa","aaaab");

    }
}
