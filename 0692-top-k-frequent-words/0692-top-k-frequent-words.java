class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }  
        List<String> res = new ArrayList<>(count.keySet());
        Collections.sort(res, (a, b) -> {
            int freqA = count.get(a), freqB = count.get(b);
            if (freqA != freqB) {
                return freqB - freqA;
            }
            return a.compareTo(b);
        });
        return res.subList(0, k);
    }
}