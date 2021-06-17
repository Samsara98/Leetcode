import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leeetcode5_7 {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2};
//        int[] nums2 = new int[]{3,4};
//        int first =0;
//        int second =0;
//        int cur = 0;
//        int f = 0;
//        int s = 0;
//        int lon = nums1.length+nums2.length;
//        int[] nums = new int[(lon)/2+1];
//        while(cur <= (lon)/2){
//            System.out.println(f+"-"+s);
//            System.out.println(first+"/"+second);
//            if(nums1.length >= first+1){
//                f = nums1[first];
//            }else {
//                f = Integer.MAX_VALUE;
//            }
//            if(nums2.length >= second+1){
//                s = nums2[second];
//            }else {
//                s = Integer.MAX_VALUE;
//            }
//            if(f <= s){
//                nums[cur] = f;
//                first++;
//            }else{
//                nums[cur] = s;
//                second++;
//            }
//            cur ++;
//        }
//        System.out.println(Arrays.toString(nums));
//        if(lon%2==0){
//            System.out.println((double)(nums[nums.length-1] + nums[nums.length-2])/2);
//        }else{
//            System.out.println((double)nums[nums.length-1]);
//        }
        String[] names = new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
        Map<String,Integer> maps = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            maps.put(names[i],maps.getOrDefault(names[i],0)+1);
            if(maps.getOrDefault(names[i],0)>=2){
                int num = (maps.get(names[i])-1);
                String name = names[i]+"("+num+")";
                while (maps.getOrDefault(name,0)>=1){
                    System.out.println(name);
                    name = names[i]+"("+(num++)+")";
                }
                maps.put(name,maps.getOrDefault(name,0));
                names[i] = name;
            }
        }
        System.out.println(Arrays.toString(names));
    }
}
