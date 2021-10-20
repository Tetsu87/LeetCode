import java.util.*;

class Solution_937 {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> listOfLetters = new ArrayList<>();
        ArrayList<String> listOfDigits = new ArrayList<>();
        for (int i =0; i < logs.length; i++){
            int index = logs[i].indexOf(" ") + 1;
            if (!Character.isDigit(logs[i].charAt(index))){
                listOfLetters.add(logs[i]);
            } else {
                listOfDigits.add(logs[i]);
            }
        }
        
        String[] result = new String[logs.length];
        Collections.sort(listOfLetters, new MyComparator());
        for (int i =0; i < listOfLetters.size(); i++){
            result[i] = listOfLetters.get(i);
        }
        
        for (int i = listOfLetters.size(); i < result.length; i++){
            result[i] = listOfDigits.get(i - listOfLetters.size());
        }
        return result;
    }
}

class MyComparator implements Comparator<String>{
    @Override
    public int compare(String str1, String str2){
        int index1 = str1.indexOf(" ")+1;
        int index2 = str2.indexOf(" ")+1;
        String core1 = str1.substring(index1);
        String core2 = str2.substring(index2);
        
        if (core1.compareTo(core2) < 0){
            return core1.compareTo(core2);
        } else if (core1.compareTo(core2) >0){
            return core1.compareTo(core2);
        } else {
            return (str1.substring(0,index1)).compareTo(str2.substring(0,index2));
        }
    }
}