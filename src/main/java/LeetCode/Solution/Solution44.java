package LeetCode.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution44 {
    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.longestContinuousSubstring("mbwiqzuymyoawxabtpjzzvoomkjflsorihirvqcpiaurmpgtibdyswsghxiwwziijzrmtyhznrulfaokbuabrusrxfnltyxsidskdtxldubkerrmahzezekhpetndsvpbvzvyfuewqfvzllfcgrmiwxgwcvsywdrzupdrflbfoarikrhvxteapxpcigztuakkkyslhwgszvijqtklrcazrlmwiqkuyebjznxjigtwldchwlbaccslvjgrmoqevyxnodxpcyhgopphhnlwtymlladhoxkgscgedgiemxddtkcbldkvjryxpswuaumafzrvkoqswhupoqftthzeducfxlzgxkbrgagjciboxwetlepgozetntiznmhmoceqatwbuqigibsoxjgufkmuexzltfsrokdtprsnqtwcndmvlyrhdodnqdybbozpvrjnamewihggfsgggcnvqaprzuofewleppmngitbenykimsfsioimjlngwegsioxnxmjphouulckeexczzjlqlvlcujvodtigitdosuuwhyrulbhzacdwjjzjqqagaggfwohhshwuxuzlvocovhjityoqothrfmigjbessjrscptdpbyjpwruwfgkkstxszlanqzxgkvnlcspzkwsickdobvkcybneetrbhlngkytfiaxbgzoloxjagtxrhebdjqhusnomnzbrfniaerfwwhuqwcjnltudmljyerkxslnofycqfhgdffchwayhjzsrxsmbhewhriddqrlrvrkucnbsieusxnodxcdxqyvkagslwlywabqcjylgmflhsztigdbmuefwmajzipcwswjbzevajubjmcdsnytkodcqhbcyamhahiifjgcviqhlkbhyixufukqzcfigbhxikxzsjhmwiyehfzqpngjopbjtpavkrmfmfuinwplmgsoeumumgprrrmjkyufykgqjbysehhmxhnlasixekcwpmhxsohdzfyymczwxxqlxdforttdbnmebeoacgzjaxelvedhzwhkpzixrtpfyntxamwpfdhaixfkurkkewtqchnxjfyygkltgqjdlgllvlkrnknmyijtgvcuvpjkylvnmbsffdcnuzqpsnsocmaydxwdbdfkwwdyotsvkcvukffcvddygnhedxiedfnlgccwwzmuhaqnfdbewcwfoznzzk"));
        //System.out.println(solution44.getDifferentSubstrings("abacaba"));
        /* 这里输入您的代码 */ 
    }

    public int longestContinuousSubstring(String s) {
        int res = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1){
                cur++;
            }else{
                cur = 1;
            }
            res = Math.max(res,cur);
        }
        return res;
    }
    public Set<String> getDifferentSubstrings(String s){
        Set<String> strings = new HashSet<>();
        strings.add(s);
        for (int i = 0; i < s.length(); i++) {
            int count = s.length() - i - 1;//6 5 4 3 2 1
            for (int j = 0; j < s.length(); j++) {
                if (j + count - 1 < s.length()){
                    strings.add(s.substring(j,j + count));
                }
            }
        }
        return strings;
    }
}
