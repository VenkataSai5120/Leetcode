import java.util.*;

class FoodRatings {
    
    Map<String, TreeMap<Integer, TreeSet<String>>> crf = new HashMap<>();
    Map<String, Integer> fr = new HashMap<>();
    Map<String, String> fc = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = ratings.length;
        
        for (int i = 0; i < n; i++){
            if (!crf.containsKey(cuisines[i])){
                crf.put(cuisines[i], new TreeMap<>());
            }
            TreeMap<Integer, TreeSet<String>> tm = new TreeMap<>();
            tm = crf.get(cuisines[i]);
            
            if (!tm.containsKey(ratings[i]))
                tm.put(ratings[i], new TreeSet<>());
            TreeSet<String> ts = tm.get(ratings[i]);
            ts.add(foods[i]);
            fr.put(foods[i], ratings[i]);
            fc.put(foods[i], cuisines[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int oldRating = fr.get(food);
        
        if (oldRating == newRating)
            return;
        
        String cuisine = fc.get(food);
        TreeMap<Integer, TreeSet<String>> tm = crf.get(cuisine);
        TreeSet<String> ts = tm.get(oldRating);
        ts.remove(food);
        
        if (ts.isEmpty())
            tm.remove(oldRating);
        
        ts = tm.getOrDefault(newRating, new TreeSet<>());
        ts.add(food);
        tm.put(newRating, ts);
        fr.put(food, newRating);
        crf.put(cuisine, tm);
    }
    
    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> tm = crf.get(cuisine);
        TreeSet<String> ts = tm.get(tm.lastEntry().getKey());
        return ts.first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */