package leetCode3Sum;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] testArray = {-1,0,1,2,-1,-4};
		int[] testArray = {4,-9,-13,-9,0,-12,12,-14,12,1,3,5,5,8,2,-2,8,1,2,-6,-6,1,6,-15,-2,7,-11,3,-2,1,11,10,8,14,8,-15,9,5,-14,6,14,-3,-12,4,-10,5,-12,13,14,-3,-15,-7,5,-2,-15,10,-10,11,-2,-5,-2,-5,-10,13,-14,14,13,2,4,7,-6,3,11,-3,-15,-14,10,10,6,1,-8,-2,1,12,11,1,7,8,-10,13,-11,3,-15,-6,-7,8,-7,13,-5,5,-3,4,-15,-7,9,-15,-14,-4,2,0,4,9,13,-10,-2,10};
		//threeSum(testArray);
		ThreeSum notStatic = new ThreeSum();
		System.out.println(notStatic.threeSum(testArray));
	}
	
	

public List<List<Integer>> threeSum(int[] nums) {
        
        int sum2 = 0;    //2 numbers added
        int lesser = 0;  //put the lesser number first in the hashmap
        int greater = 0;
        int x = 0;       //solve for x
        String sumString = "";
        
        HashMap<String, Integer> added = new HashMap<String, Integer>();
        
        //create the hashmap for sets of 2
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i +1; j < nums.length; j++)
            {
                if (nums[i] < nums[j])  //keep the numbers in order
                {
                    lesser = nums[i];
                    greater = nums[j];
                }
                else
                {
                    lesser = nums[j];
                    greater = nums[i];
                }
                
                sum2 = lesser + greater;
                //using strings in a hashmap makes sure there are no duplicates
                sumString = lesser + "," + greater + "," + i + "," + j;
                added.put (sumString, sum2);
            }
        }
        
        
        //System.out.println(added);   //list of combinations and results
        
        //crate a hashmap for each unique combination of 3 values
        HashMap<String, List<Integer>> unique = new HashMap<String, List<Integer>>();
        //Create a list of arraylists that will be returned at the end
        List<List<Integer>> arrList = new ArrayList<>();
        
        //Check which set of 2 other numbers match with each number
        for (int i = 0; i < nums.length; i++)
        {
            x = -(nums[i]);  //the 2 numbers added need to equal the negative of the 3rd number
            for (Map.Entry findValue : added.entrySet())
            {
                //System.out.println("Key: "+findValue.getKey() + " & Value: " + findValue.getValue());
                
                int convert = Integer.parseInt((findValue.getValue()).toString());
                if (convert == x)
                {
                    //convert the string back to numbers
                    List<String> twoValues = Arrays.asList(findValue.getKey().toString().split(","));
                    int num1 = Integer.parseInt(twoValues.get(0));
                    int num2 = Integer.parseInt(twoValues.get(1));
                    int index1 = Integer.parseInt(twoValues.get(2));
                    int index2 = Integer.parseInt(twoValues.get(3));
                    
                    if (i != index1 && i != index2)  //check if that number was used before
                    {
                        //sort the numbers from smallest to largest so the number set has only one combination
                        if (nums[i] <= num1)
                        {
                            String uniqueString = nums[i] + "," + num1 + "," + num2;
                            unique.put(uniqueString, new ArrayList<Integer>(Arrays.asList(nums[i], num1, num2)));
                        }
                        else if (num1 < nums[i]  && nums[i] <= num2)
                        {
                            String uniqueString = num1 + "," + nums[i] + "," + num2;
                            unique.put(uniqueString, new ArrayList<Integer>(Arrays.asList(num1, nums[i], num2)));
                        }
                        else
                        {
                            String uniqueString = num1 + "," + num2 + "," + nums[i];
                            unique.put(uniqueString, new ArrayList<Integer>(Arrays.asList(num1, num2, nums[i])));
                        }
                    }
                }
            }
        }
        
        //create the list of lists for output
        for (Map.Entry listOfLists : unique.entrySet())
            {
                //System.out.println("Key: "+listOfLists.getKey() + " & Value: " + listOfLists.getValue());
                //arrList.add(new ArrayList<Integer>(listOfLists.getValue()));     //Something like this should work
                //Since each value of the hashmap is an arraylist, there should be some way to access it.
                List<String> createArrayList = Arrays.asList(listOfLists.getKey().toString().split(","));
                //Another way to access the numbers is to access the key in the hashmap.
                ArrayList<Integer> singleAnswer = new ArrayList<Integer>(3);
                singleAnswer.add(Integer.parseInt(createArrayList.get(0)));
                singleAnswer.add(Integer.parseInt(createArrayList.get(1)));
                singleAnswer.add(Integer.parseInt(createArrayList.get(2)));
            
                arrList.add(singleAnswer);
            }
        
        //return the final answer
        return arrList;
        
        //https://stackoverflow.com/questions/19758449/how-to-correctly-create-an-arraylist-of-arraylists
        //https://stackoverflow.com/questions/10631715/how-to-split-a-comma-separated-string
        //https://www.w3schools.com/java/java_hashmap.asp
        //https://thispointer.com/java-how-to-get-keys-by-a-value-in-hashmap-search-by-value-in-map/
        //https://beginnersbook.com/2013/12/how-to-loop-hashmap-in-java/
        //https://www.w3resource.com/java-tutorial/arraylist/arraylist_get.php
        //https://stackoverflow.com/questions/8803674/declaring-variables-inside-or-outside-of-a-loop
        //https://coderanch.com/t/503543/java/HashMap-Integer-ArrayList
        //https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/
    }
}