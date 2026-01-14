# 🤝 Contributing to DSA Repository

Thank you for your interest in contributing to this Data Structures & Algorithms repository! This guide will help you understand how to contribute effectively.

---

## 📋 Table of Contents

1. [Getting Started](#getting-started)
2. [Adding LeetCode Solutions](#adding-leetcode-solutions)
3. [Code Quality Guidelines](#code-quality-guidelines)
4. [Documentation Standards](#documentation-standards)
5. [Commit Message Guidelines](#commit-message-guidelines)
6. [Pull Request Process](#pull-request-process)

---

## 🚀 Getting Started

### Fork and Clone

1. Fork this repository to your GitHub account
2. Clone your fork locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/DSA.git
   cd DSA
   ```

3. Add the upstream repository:
   ```bash
   git remote add upstream https://github.com/vikashkumar016/DSA.git
   ```

### Keep Your Fork Updated

```bash
git fetch upstream
git checkout main
git merge upstream/main
```

---

## 💻 Adding LeetCode Solutions

### Using the Automation Script

Always use the provided script to maintain consistency:

```bash
./scripts/add-leetcode-solution.sh \
  -n <problem_number> \
  -t "<Problem Title>" \
  -d <Easy|Medium|Hard> \
  -l <python|java|cpp|js> \
  -g "Tag1,Tag2,Tag3"
```

### Manual Steps (If Not Using Script)

If you prefer to add solutions manually:

1. Create a folder: `LeetCode/{Difficulty}/{number}-{slug}/`
2. Add `solution.{ext}` with your implementation
3. Add `README.md` with problem details
4. Follow the template structure in `scripts/templates/`

---

## 📝 Code Quality Guidelines

### General Principles

- ✅ Write clean, readable code
- ✅ Use meaningful variable and function names
- ✅ Add comments for complex logic
- ✅ Follow language-specific best practices
- ✅ Test your solution thoroughly

### Language-Specific Standards

#### Python
- Follow PEP 8 style guide
- Use type hints where appropriate
- Write docstrings for functions
- Example:
  ```python
  def two_sum(nums: list[int], target: int) -> list[int]:
      """
      Find two numbers that add up to target.
      
      Args:
          nums: List of integers
          target: Target sum
          
      Returns:
          List containing indices of the two numbers
      """
      # Implementation here
  ```

#### Java
- Follow Java naming conventions
- Use JavaDoc comments
- Properly handle exceptions
- Example:
  ```java
  /**
   * Finds two numbers that add up to target.
   * 
   * @param nums Array of integers
   * @param target Target sum
   * @return Array containing indices of the two numbers
   */
  public int[] twoSum(int[] nums, int target) {
      // Implementation here
  }
  ```

#### C++
- Follow C++11 or later standards
- Use modern C++ features
- Include proper headers
- Example:
  ```cpp
  /**
   * Finds two numbers that add up to target.
   * 
   * @param nums Vector of integers
   * @param target Target sum
   * @return Vector containing indices of the two numbers
   */
  vector<int> twoSum(vector<int>& nums, int target) {
      // Implementation here
  }
  ```

#### JavaScript
- Use ES6+ features
- Follow Airbnb style guide
- Use JSDoc comments
- Example:
  ```javascript
  /**
   * Finds two numbers that add up to target.
   * 
   * @param {number[]} nums - Array of integers
   * @param {number} target - Target sum
   * @return {number[]} Array containing indices
   */
  var twoSum = function(nums, target) {
      // Implementation here
  };
  ```

---

## 📚 Documentation Standards

### Solution Files

Every solution file must include:

1. **Header Comments**
   - Problem number and title
   - Difficulty level
   - LeetCode link
   - Tags/topics
   - Time complexity
   - Space complexity

2. **Approach Description**
   - Clear explanation of the strategy
   - Step-by-step algorithm

3. **Test Cases**
   - At least 3 test cases
   - Include edge cases

### README Files

Every problem README must include:

1. **Problem Description**
   - Complete problem statement from LeetCode
   - Include constraints

2. **Approach**
   - Strategy explanation
   - Algorithm steps

3. **Complexity Analysis**
   - Time complexity with explanation
   - Space complexity with explanation

4. **Solutions**
   - Document all approaches
   - Explain trade-offs

5. **Test Cases**
   - Input, output, and explanation

6. **Notes**
   - Important observations
   - Common pitfalls
   - Tips and tricks

7. **Related Problems**
   - Links to similar problems

---

## 💬 Commit Message Guidelines

### Format

```
<type>: <subject>

<body>
```

### Types

- `feat`: New solution or feature
- `fix`: Bug fix in existing solution
- `docs`: Documentation changes
- `style`: Code style changes (formatting)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

### Examples

```bash
# Good commit messages
git commit -m "feat: Add LeetCode #1 Two Sum (Easy) - Hash Map solution"
git commit -m "docs: Update README with usage instructions"
git commit -m "fix: Correct time complexity analysis in Two Sum"

# Avoid
git commit -m "update"
git commit -m "fixed bug"
git commit -m "changes"
```

### LeetCode Solution Commits

Use this format for LeetCode solutions:

```
Add LeetCode #<number>: <Title> (<Difficulty>)
```

Example:
```
Add LeetCode #1: Two Sum (Easy)
```

---

## 🔄 Pull Request Process

### Before Submitting

1. ✅ Ensure your code follows the style guidelines
2. ✅ Test your solution with multiple test cases
3. ✅ Update documentation
4. ✅ Verify complexity analysis is correct
5. ✅ Check that all files are properly formatted

### PR Title Format

```
Add LeetCode #<number>: <Title> (<Difficulty>)
```

Or for other changes:
```
<type>: <brief description>
```

### PR Description Template

```markdown
## Description
Brief description of the changes

## Problem Details
- **Problem Number:** #123
- **Title:** Problem Title
- **Difficulty:** Easy/Medium/Hard
- **Tags:** Tag1, Tag2, Tag3

## Approach
Brief explanation of your solution approach

## Complexity
- Time: O(?)
- Space: O(?)

## Checklist
- [ ] Solution tested on LeetCode
- [ ] Code follows style guidelines
- [ ] Documentation is complete
- [ ] Test cases included
- [ ] Complexity analysis provided
```

### Review Process

1. Submit your PR
2. Wait for review (automated checks will run)
3. Address any feedback
4. Once approved, your PR will be merged

---

## ✨ Best Practices

### DO ✅

- Use the automation script for consistency
- Write clean, well-documented code
- Test thoroughly before submitting
- Follow the template structure
- Provide detailed complexity analysis
- Include multiple approaches when applicable
- Add meaningful commit messages

### DON'T ❌

- Submit untested solutions
- Copy solutions without understanding
- Skip documentation
- Use unclear variable names
- Ignore complexity analysis
- Submit incomplete READMEs
- Make unrelated changes in the same PR

---

## 🐛 Reporting Issues

If you find a bug or have a suggestion:

1. Check if an issue already exists
2. Open a new issue with:
   - Clear title
   - Detailed description
   - Steps to reproduce (for bugs)
   - Expected vs actual behavior
   - Screenshots (if applicable)

---

## 📞 Questions?

If you have questions:

1. Check the [README](README.md)
2. Review the [Usage Guide](scripts/USAGE_GUIDE.md)
3. Search existing issues
4. Open a new discussion or issue

---

## 🙏 Thank You

Thank you for contributing to this learning repository! Your contributions help make this a valuable resource for everyone preparing for technical interviews and improving their DSA skills.

**Happy Coding! 🚀**
