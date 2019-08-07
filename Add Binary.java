class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) 
            return addBinary(b,a);
        
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0; i--, j--) {
            int A = a.charAt(i) - '0';
            int B = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = A+B+rem;
            sb.append(sum % 2);
            rem = sum / 2;
        }
        if (rem != 0) {
            sb.append(rem);
        }
        return sb.reverse().toString();
    }
}