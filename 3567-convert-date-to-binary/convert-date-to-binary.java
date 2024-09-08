class Solution {
    public String convertDateToBinary(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        String yyyy = Integer.toString(year, 2);
        String mm = Integer.toString(month, 2);
        String dd = Integer.toString(day, 2);

        return yyyy + "-" + mm + "-" + dd;
    }
}