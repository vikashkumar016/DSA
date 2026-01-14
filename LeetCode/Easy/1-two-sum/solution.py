"""
LeetCode Problem #1: Two Sum
Difficulty: Easy
Link: https://leetcode.com/problems/two-sum/
Tags: Array,Hash Table

Time Complexity: O(n)
Space Complexity: O(n)

Approach:
---------
Use a hash map to store numbers we've seen and their indices.
For each number, check if its complement (target - num) exists in the hash map.

1. Create a hash map to store number -> index mapping
2. Iterate through the array
3. For each number, calculate complement = target - num
4. If complement exists in hash map, return [hash_map[complement], current_index]
5. Otherwise, add current number and index to hash map

"""

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        """
        Find two numbers that add up to target and return their indices.
        
        Args:
            nums: List of integers
            target: Target sum
            
        Returns:
            List containing indices of the two numbers
        """
        # Hash map to store number -> index
        num_map = {}
        
        # Iterate through the array
        for i, num in enumerate(nums):
            complement = target - num
            
            # Check if complement exists in hash map
            if complement in num_map:
                return [num_map[complement], i]
            
            # Add current number and index to hash map
            num_map[num] = i
        
        # No solution found (shouldn't happen based on problem constraints)
        return []


# Test cases
if __name__ == "__main__":
    solution = Solution()
    
    # Test case 1
    nums1 = [2, 7, 11, 15]
    target1 = 9
    result1 = solution.twoSum(nums1, target1)
    print(f"Test 1: nums={nums1}, target={target1}")
    print(f"Output: {result1}")
    print(f"Expected: [0, 1]")
    print()
    
    # Test case 2
    nums2 = [3, 2, 4]
    target2 = 6
    result2 = solution.twoSum(nums2, target2)
    print(f"Test 2: nums={nums2}, target={target2}")
    print(f"Output: {result2}")
    print(f"Expected: [1, 2]")
    print()
    
    # Test case 3
    nums3 = [3, 3]
    target3 = 6
    result3 = solution.twoSum(nums3, target3)
    print(f"Test 3: nums={nums3}, target={target3}")
    print(f"Output: {result3}")
    print(f"Expected: [0, 1]")
    print()
