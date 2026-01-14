# 1. Two Sum

**Difficulty:** Easy  
**Link:** [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)  
**Tags:** Array, Hash Table

---

## Problem Description

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

**Example 1:**
```
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

**Example 2:**
```
Input: nums = [3,2,4], target = 6
Output: [1,2]
```

**Example 3:**
```
Input: nums = [3,3], target = 6
Output: [0,1]
```

**Constraints:**
- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- Only one valid answer exists.

---

## Approach

### Strategy
Use a hash map (dictionary) to solve this problem in a single pass. The key insight is that for each number, we can calculate its complement (target - current number) and check if we've seen it before.

### Algorithm
1. Create an empty hash map to store numbers and their indices
2. Iterate through the array with index and value
3. For each number, calculate its complement: `complement = target - current_number`
4. Check if the complement exists in the hash map
   - If yes: return `[hash_map[complement], current_index]`
   - If no: add the current number and its index to the hash map
5. Continue until a solution is found

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - We traverse the list containing n elements only once. Each lookup in the hash table costs O(1) time.

- **Space Complexity:** `O(n)`
  - The extra space required depends on the number of items stored in the hash table, which stores at most n elements.

---

## Solutions

### Solution 1: Hash Map (One-pass)

**Language:** Python

**Code:** See `solution.py` file

**Explanation:**
This solution uses a hash map to store numbers we've seen along with their indices. As we iterate through the array, for each number we:
1. Calculate what number we need to find (the complement)
2. Check if we've already seen that number
3. If yes, we found our answer
4. If no, we store the current number for future reference

This approach is optimal because:
- We only need to traverse the array once
- Hash map lookups are O(1) on average
- We find the solution as soon as we encounter the second number of the pair

**Alternative Approaches:**
- **Brute Force (O(n²))**: Check every pair of numbers - simple but inefficient
- **Two-pass Hash Map (O(n))**: First pass builds the map, second pass finds complements - works but requires two passes

---

## Test Cases

```python
Test Case 1:
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9

Test Case 2:
Input: nums = [3, 2, 4], target = 6
Output: [1, 2]
Explanation: nums[1] + nums[2] = 2 + 4 = 6

Test Case 3:
Input: nums = [3, 3], target = 6
Output: [0, 1]
Explanation: nums[0] + nums[1] = 3 + 3 = 6
```

---

## Notes

- This is one of the most frequently asked interview questions
- The hash map approach is preferred over brute force for its efficiency
- Make sure to handle the constraint that you cannot use the same element twice
- The problem guarantees exactly one solution, so we don't need to handle edge cases for no solution or multiple solutions

---

## Related Problems

- [3Sum](https://leetcode.com/problems/3sum/)
- [4Sum](https://leetcode.com/problems/4sum/)
- [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
- [Two Sum III - Data structure design](https://leetcode.com/problems/two-sum-iii-data-structure-design/)
