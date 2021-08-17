package Problem;

public class Pro006_ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(new Pro006_ZigZagConversion().convert("PAYPALISHIRING", 2));
    }

    public String convert(String s, int numRows) {
        if (s == null || "".equals(s) || numRows <= 1)
            return s;

        char[] result = new char[s.length()];
        int[] lengthOfRow = new int[numRows];
        int lengthOfAll = 0;

        int groupSize = numRows + Math.max(0, numRows - 2);
        int groupNumber = s.length() / groupSize;
        int groupLast = s.length() % groupSize;
        for (int i = 0; i < numRows; i++) {
            int lastInThisRow;
            if (groupLast > numRows) {
                lastInThisRow = 1 + ((i < numRows - 1 && i >= numRows - groupLast % numRows - 1) ? 1 : 0);
            } else {
                lastInThisRow = groupLast > i ? 1 : 0;
            }

            int charPerRow = (i == 0 || i == numRows - 1) ? 1 : 2;
            lengthOfAll += charPerRow * groupNumber + lastInThisRow;
            lengthOfRow[i] = lengthOfAll;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int groupIndex = i / groupSize;
            int indexInGroup = i % groupSize;
            int charPerRow = (indexInGroup == 0 || indexInGroup == numRows - 1) ? 1 : 2;

            int row = indexInGroup < numRows ? indexInGroup : numRows - indexInGroup % numRows - 2;
            int coulm = groupIndex * charPerRow + (indexInGroup < numRows ? 1 : charPerRow);
            int charIndex;
            if (row - 1 >= 0) {
                charIndex = lengthOfRow[row - 1] + coulm - 1;
            } else {
                charIndex = coulm - 1;
            }
            result[charIndex] = c;
        }
        return new String(result);
    }
}
