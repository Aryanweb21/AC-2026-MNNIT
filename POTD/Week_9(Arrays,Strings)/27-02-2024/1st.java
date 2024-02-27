/**
 * Link - https://leetcode.com/problems/determine-if-two-events-have-conflict/
 * 2446. Determine if Two Events Have Conflict
Solved
Easy
Topics
Companies
Hint
You are given two arrays of strings that represent two inclusive events that happened on the same day, event1 and event2, where:

event1 = [startTime1, endTime1] and
event2 = [startTime2, endTime2].
Event times are valid 24 hours format in the form of HH:MM.

A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).

Return true if there is a conflict between two events. Otherwise, return false.

 

Example 1:

Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
Output: true
Explanation: The two events intersect at time 2:00.
Example 2:

Input: event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
Output: true
Explanation: The two events intersect starting from 01:20 to 02:00.
Example 3:

Input: event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
Output: false
Explanation: The two events do not intersect.
 

Constraints:

evnet1.length == event2.length == 2.
event1[i].length == event2[i].length == 5
startTime1 <= endTime1
startTime2 <= endTime2
All the event times follow the HH:MM format.
 */

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int start[] = new int[2];
        int end[] = new int[2];
        start[0] = toMinutes(event1[0]);
        start[1] = toMinutes(event2[0]);
        end[0] = toMinutes(event1[1]);
        end[1] = toMinutes(event2[1]);
        
        return start[1]<=end[0] && start[0]<=end[1];
    }

    int toMinutes(String s){
        String[] parts = s.split(":");
        int totalMinutes=0;
        if (parts.length == 2) {
            try {
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                totalMinutes = hours * 60 + minutes;
            } catch (NumberFormatException e) {
                System.out.println("Invalid time format.");
            }
        }
        return totalMinutes;
    }
}