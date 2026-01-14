# 🎯 LeetCode Solutions

This directory contains organized solutions to LeetCode problems, structured by difficulty level.

---

## 📁 Directory Structure

```
LeetCode/
├── Easy/           # Easy difficulty problems
├── Medium/         # Medium difficulty problems
├── Hard/           # Hard difficulty problems
└── README.md       # This file
```

---

## 📊 Problem Organization

Each problem is stored in its own directory following this naming convention:
```
{number}-{problem-slug}/
├── solution.{ext}   # Solution implementation
└── README.md        # Problem description, approach, and analysis
```

**Example:**
```
Easy/
└── 1-two-sum/
    ├── solution.py
    └── README.md
```

---

## 🚀 Quick Start

### Adding a New Solution

Use the provided script to quickly add a new LeetCode solution:

```bash
# Basic usage
./scripts/add-leetcode-solution.sh -n <number> -t "<title>" -d <difficulty> -l <language>

# Example: Add Two Sum in Python
./scripts/add-leetcode-solution.sh -n 1 -t "Two Sum" -d Easy -l python -g "Array,Hash Table"

# With auto-commit
./scripts/add-leetcode-solution.sh -n 1 -t "Two Sum" -d Easy -l python -c

# With auto-commit and push
./scripts/add-leetcode-solution.sh -n 1 -t "Two Sum" -d Easy -l python -p
```

**Available options:**
- `-n, --number`: Problem number (required)
- `-t, --title`: Problem title (required)
- `-d, --difficulty`: Easy, Medium, or Hard (required)
- `-l, --language`: python, java, cpp, or js (default: python)
- `-s, --slug`: URL slug (optional, auto-generated)
- `-g, --tags`: Comma-separated tags (optional)
- `-c, --commit`: Auto-commit changes
- `-p, --push`: Auto-commit and push to GitHub

---

## 📝 Solution Template

Each solution file includes:

1. **Header Comments:**
   - Problem number and title
   - Difficulty level
   - LeetCode link
   - Related tags/topics
   - Time and space complexity

2. **Approach Documentation:**
   - Clear explanation of the solution strategy
   - Step-by-step algorithm

3. **Implementation:**
   - Clean, well-commented code
   - Follows language best practices

4. **Test Cases:**
   - Sample inputs and outputs
   - Edge cases

---

## 📚 README Template

Each problem's README.md includes:

- **Problem Description:** Full problem statement from LeetCode
- **Approach:** Detailed explanation of the solution strategy
- **Algorithm:** Step-by-step breakdown
- **Complexity Analysis:** Time and space complexity with explanations
- **Solutions:** Multiple approaches if applicable
- **Test Cases:** Examples with expected outputs
- **Notes:** Important observations and tips
- **Related Problems:** Links to similar problems

---

## 💡 Best Practices

1. **Before Adding a Solution:**
   - Solve the problem on LeetCode first
   - Test your solution with multiple test cases
   - Understand time and space complexity

2. **When Writing Code:**
   - Use meaningful variable names
   - Add comments for complex logic
   - Follow language-specific conventions
   - Include type hints (Python) or type declarations

3. **Documentation:**
   - Explain your thought process clearly
   - Document alternative approaches
   - Include complexity analysis
   - Add edge cases and constraints

4. **Testing:**
   - Include at least 3 test cases
   - Cover edge cases
   - Verify expected outputs

---

## 📈 Progress Tracking

Track your progress by difficulty level:

- ✅ **Easy:** Foundation building, basic algorithms
- 🟡 **Medium:** Common interview problems, intermediate concepts
- 🔴 **Hard:** Advanced algorithms, complex data structures

---

## 🏷️ Common Tags/Topics

- **Data Structures:** Array, String, Linked List, Stack, Queue, Hash Table, Tree, Graph, Heap
- **Algorithms:** Two Pointers, Sliding Window, Binary Search, Sorting, BFS/DFS, Dynamic Programming, Greedy, Backtracking
- **Concepts:** Recursion, Bit Manipulation, Math, Design

---

## 🔗 Useful Resources

- [LeetCode](https://leetcode.com/) - Practice platform
- [NeetCode](https://neetcode.io/) - Curated problem lists
- [LeetCode Patterns](https://seanprashad.com/leetcode-patterns/) - Problem patterns

---

## 🤝 Contributing

When adding solutions:
1. Use the provided script for consistency
2. Follow the template structure
3. Document your approach thoroughly
4. Test your solution before committing

---

## 📜 License

This is a personal learning repository. Solutions are for educational purposes.

---

**Happy Coding! 🚀**