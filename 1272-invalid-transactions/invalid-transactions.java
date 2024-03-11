import java.util.*;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String transaction : transactions) {
            Transaction tran = new Transaction(transaction);

            if (map.containsKey(tran.tName)) {
                map.get(tran.tName).add(tran);
            } else {
                List<Transaction> list = new ArrayList<>();
                list.add(tran);
                map.put(tran.tName, list);
            }
        }

        for (String st : transactions) {
            Transaction t = new Transaction(st);
            if (isInvalidTransaction(map.get(t.tName), t)) {
                res.add(st);
            }
        }

        return res;
    }

    public boolean isInvalidTransaction(List<Transaction> list, Transaction tran) {
        if (list.size() == 1 && tran.amount > 1000) {
            return true;
        }
        for (Transaction t : list) {
            if (tran.isInvalid(t.city, t.time)) {
                return true;
            }
        }

        return false;
    }
}

class Transaction {
    String tName;
    int time;
    int amount;
    String city;

    public Transaction(String tran) {
        String[] t = tran.split(",");
        tName = t[0];
        time = Integer.parseInt(t[1]);
        amount = Integer.parseInt(t[2]);
        city = t[3];
    }

    public boolean isInvalid(String city, int time) {
        return isAmountExceeded() || (isDifferentCity(city) && isWithIn60Min(time));
    }

    public boolean isAmountExceeded() {
        return this.amount > 1000;
    }

    public boolean isDifferentCity(String city) {
        return !this.city.equals(city);
    }

    public boolean isWithIn60Min(int time) {
        return Math.abs(this.time - time) <= 60;
    }
}
