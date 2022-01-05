import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class S2122RecoverOriginalArray {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int dk=nums[i]-nums[0];
            if(dk>0&&dk%2==0){
                li.add(dk);
            }
        }

        for(int diff:li){
            List<Integer> fl=f(nums,diff);
            if(fl.size()==nums.length/2){
                return fl.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return new int[]{};
    }

    public List<Integer> f(int[] nums,int diff){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        List<Integer> a=new ArrayList<>();
        for(int val:nums){
            if(hm.getOrDefault(val,0)>0&&hm.getOrDefault(val+diff,0)>0){
                a.add(val+(diff/2));
                hm.put(val,hm.get(val)-1);
                hm.put(val+diff,hm.get(val+diff)-1);
            }
        }
        return a;
    }
}
