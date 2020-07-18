package leetCodeZigzagConversion;

public class ZigzagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("conversation", 3));
		
	}
	
	public static String convert(String s, int numRows) {
        //create 2d array
        //take each part of the string as a character data type
        //put the characters of the string in the array
        //characters go Down, then diagonal up
        
        //read out the charaters to a string line by line
        
        if (numRows < 2)
        {
            return s;
        }
        
        int columnPosition = 0;
        int rowPosition = 0;
        boolean goingDown = true;
        
        char[][] arr = new char [numRows][s.length() / 2 +1];
        String returnString = "";
        
        //fill in the array
        for (int i = 0; i < s.length(); i++)
        {
            System.out.println("x" + columnPosition);
            System.out.println("y" + rowPosition);
        	arr[columnPosition][rowPosition] = s.charAt(i); //add the letter to the array
            
            //move the position
            if (goingDown)
            {
                if (columnPosition != (numRows - 1))
                {
                    columnPosition ++;
                }
                else //reached the bottom
                {
                    goingDown = false;
                    columnPosition --;
                    rowPosition ++;
                }
            }
            else if (goingDown == false)
            {
                if (columnPosition != 0)
                {
                    columnPosition --;
                    rowPosition ++;
                }
                else //reached the top
                {
                    goingDown = true;
                    columnPosition ++;
                }
            }
        }
        
        //write output to a string
        for (int x = 0; x < numRows ; x++)
        {
        	for (int y = 0; y < s.length() / 2 +1; y++)
        	{
        		if (arr[x][y] != 0)
        		{
        			returnString = returnString + arr[x][y];
        		}
        	}
        }
        
        
        return returnString;
    }
}