public class Driver {
    private boolean isAlphaNumeric(char tmp){
        return (
                ((tmp >= 48) && (tmp <= 57)) || // is number?
                ((tmp >= 65) && (tmp <= 90)) || // is uppercase?
                ((tmp >= 97) && (tmp <= 122)) // is lowercase?
        );
    }

    /**
     * Removes all non-alphanumeric chars
     * and makes to lowercase
     * @param s unsanitized string
     * @return String cleansed
     */
    private String cleanString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(isAlphaNumeric(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome(String st) {
        // cleaning string first makes comparing chars much easier and cleaner
        String cleanedString = cleanString(st);
        if(cleanedString.length() <= 1) return true; // easy check here

        // 2 pointers moving towards center, comparing each character
        int left = 0;
        int right = cleanedString.length()-1;
        while(left <= right){
            if(cleanedString.charAt(left) != cleanedString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        {
            Driver d = new Driver();
            String pal = "racecar";
            boolean result = d.isPalindrome(pal);
            System.out.println(result);
        }
        {
            Driver d = new Driver();
            String pal = "A man, a plan, a canal: Panama";
            boolean result = d.isPalindrome(pal);
            System.out.println(result);
        }
        {
            Driver d = new Driver();
            String pal = "race a car";
            boolean result = d.isPalindrome(pal);
            System.out.println(result);
        }
        {
            Driver d = new Driver();
            String pal = "a.";
            boolean result = d.isPalindrome(pal);
            System.out.println(result);
        }
        {
            Driver d = new Driver();
            String pal = ".";
            boolean result = d.isPalindrome(pal);
            System.out.println(result);
        }
        {
            Driver d = new Driver();
            String pal = "";
            boolean result = d.isPalindrome(pal);
            System.out.println(result);
        }
    }
}
