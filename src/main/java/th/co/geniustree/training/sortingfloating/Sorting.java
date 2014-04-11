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
    {// ทำการแยกตัวเลข  ออกจากจุด "." เช่น 3.1.2.4 --> {"3", "1", "2", "4"}
        // สัญลักษณ์ \\. เป็น regular expression
        String[] split1 = str1.split("\\."); 
        String[] split2 = str2.split("\\.");
 
        // เลือกหลักตัวเลขที่มีค่าสูงสุด เช่น 1.2 กับ 1.5.2.3
        // ค่าที่ได้จะเป็น 4 
        int length = (split1.length > split2.length) ? split1.length : split2.length;
 
        // วน loop เปรียบเทียบค่าทีละหลัก 
        for (int i = 0; i < length; i++) {
            int numb1;
            try {
                // แปลง string ไปเป็นตัวเลขก่อน
                numb1 = Integer.parseInt(split1[i]); 
            } catch (Exception ex) {
                // numb1 < numb2 
                // ซึ่งอาจเกิดจากสาเหตุ numb1 มีจำนวนหลักตัวเลขน้อยกว่า numb2 
                // แต่ตอน loop เรา loop ตาม จำนวนหลักของ numb2 (เกิด ArrayIndexOutOfBoundsException)
                // หรือ numb1 มีรูปแบบตัวเลขที่ไม่ถูกต้อง  (NumberFormatException)
                return -1; 
            }
 
            int numb2;
            try {
                numb2 = Integer.parseInt(split2[i]);
            } catch (Exception ex) {
                // คล้าย numb1 แต่อันนี้หมายความว่า numb1 > numb2
                return 1; 
            }
 
            if (numb1 > numb2) {
                return 1;
            }
 
            if (numb1 < numb2) {
                return -1;
            }
        }
 
        return 0; //numb1 เท่ากับ numb2
    }
}
