/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.geniustree.training.sortingfloating;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Rain
 */
public class Sorting 
{
    public static List<String> sort(List<String> numbers) 
    {
        Collections.sort(numbers, new Comparator<String>() 
        {

            @Override
            public int compare(String o1, String o2) 
            {
               return multiplePointCompare(o1, o2);
            }
        });

        return numbers;
    }
    
    private static int multiplePointCompare(String str1 , String str2)
    {
        try
        {
            String[] split1 = str1.split("\\.");
            String[] split2 = str2.split("\\.");
            
            /*if (split1.length != split2.length) 
            {
                return -1;
            }*/
 
            for (int i = 0; i < split1.length; i++) 
            {
                int numb1 = Integer.parseInt(split1[i]);
                int numb2 = Integer.parseInt(split2[i]);
 
                
                if (numb1 > numb2)
                {
                    return 1;
                }
 
                if (numb1 < numb2)
                {
                    return -1;
                }
                if (split1.length < split2.length) 
                {
                    return -1;
                }
            
                if (split1.length > split2.length) 
                {
                    return 1;
                }
            }
            
            
            return 0;
        }
        catch (Exception ex) 
        {
            return -1;
        }
        
    }
}
