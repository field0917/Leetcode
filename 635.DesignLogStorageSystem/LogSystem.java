// You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.

// Design a log storage system to implement the following functions:

// void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.


// int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the range from start to end. Start and end all have the same format as timestamp. However, granularity means the time level for consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.

// Example 1:
// put(1, "2017:01:01:23:59:59");
// put(2, "2017:01:01:22:59:59");
// put(3, "2016:01:01:00:00:00");
// retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
// retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
// Note:
// There will be at most 300 operations of Put or Retrieve.
// Year ranges from [2000,2017]. Hour ranges from [00,23].
// Output for Retrieve has no order required.

import java.util.*;
public class LogSystem {

    Map<Integer, String> map;

    public LogSystem() {
        map = new HashMap<>();
    }
    
    public void put(int id, String timestamp) {
        //int[] timeArr = storeInArr(timestamp);
        map.put(id, timestamp);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        int index = 0;
        switch (gra) {
            case "Year" : index = 4;
                break;
            case "Month" : index = 7;
                break;
            case "Day" : index = 10;
                break;
            case "Hour" : index = 13;
                break;
            case "Minute" : index = 16;
                break;
            case "Second" : index = 19;
                break;
        }

        List<Integer> list = new ArrayList<>();

        for (int key : map.keySet()) {
            String ss = map.get(key);
            if (ss.substring(0, index).compareTo(s.substring(0, index)) >= 0 && ss.substring(0, index).compareTo(e.substring(0, index)) <= 0)
                list.add(key);
        }
        return list;
    }

    // private int[] storeInArr (String timestamp) {
    //     String[] temp = timestamp.split(":");
    //     int[] timeArr = new int[temp.length];

    //     for (int i = 0; i < temp.length; i++) {
    //         timeArr[i] = Integer.parseInt(temp[i]);
    //     }

    //     return timeArr;
    // }

    public static void main(String[] args) {
        LogSystem l = new LogSystem();
        l.put(1, "2017:01:01:23:59:59");
        l.put(2, "2017:01:02:23:59:59");
        //l.put(3, "2016:01:01:00:00:00");
        List<Integer> param_1 = l.retrieve("2017:01:01:23:59:58","2017:01:02:23:59:58","Second"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
        //List<Integer> param_2 = l.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
        System.out.println(param_1);
        //System.out.println(param_2);
        //System.out.println(Integer.parseInt("00"));
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */