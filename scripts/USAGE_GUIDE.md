# 📖 LeetCode Automation Scripts - Usage Guide

This guide provides detailed instructions on using the automation scripts to manage LeetCode solutions in this repository.

---

## 🚀 Quick Start

### Basic Usage

```bash
./scripts/add-leetcode-solution.sh -n <number> -t "<title>" -d <difficulty>
```

### Full Example

```bash
./scripts/add-leetcode-solution.sh \
  -n 1 \
  -t "Two Sum" \
  -d Easy \
  -l python \
  -g "Array,Hash Table" \
  -c
```

---

## 📋 Command Line Options

| Option | Long Form | Description | Required | Default |
|--------|-----------|-------------|----------|---------|
| `-n` | `--number` | LeetCode problem number | ✅ Yes | - |
| `-t` | `--title` | Problem title (use quotes) | ✅ Yes | - |
| `-d` | `--difficulty` | Easy, Medium, or Hard | ✅ Yes | - |
| `-l` | `--language` | python, java, cpp, js | ❌ No | python |
| `-s` | `--slug` | URL slug (auto-generated if omitted) | ❌ No | Auto |
| `-g` | `--tags` | Comma-separated tags | ❌ No | TODO |
| `-c` | `--commit` | Auto-commit the changes | ❌ No | false |
| `-p` | `--push` | Auto-commit and push to GitHub | ❌ No | false |
| `-h` | `--help` | Display help message | ❌ No | - |

---

## 💡 Examples

### Example 1: Simple Python Solution

```bash
./scripts/add-leetcode-solution.sh -n 1 -t "Two Sum" -d Easy
```

Creates:
- `LeetCode/Easy/1-two-sum/solution.py`
- `LeetCode/Easy/1-two-sum/README.md`

### Example 2: Java Solution with Tags

```bash
./scripts/add-leetcode-solution.sh \
  -n 15 \
  -t "3Sum" \
  -d Medium \
  -l java \
  -g "Array,Two Pointers,Sorting"
```

Creates:
- `LeetCode/Medium/15-3sum/solution.java`
- `LeetCode/Medium/15-3sum/README.md`

### Example 3: With Auto-Commit

```bash
./scripts/add-leetcode-solution.sh \
  -n 4 \
  -t "Median of Two Sorted Arrays" \
  -d Hard \
  -l cpp \
  -g "Array,Binary Search,Divide and Conquer" \
  -c
```

Creates files AND commits them automatically.

### Example 4: With Auto-Commit and Push

```bash
./scripts/add-leetcode-solution.sh \
  -n 206 \
  -t "Reverse Linked List" \
  -d Easy \
  -l python \
  -g "Linked List,Recursion" \
  -p
```

Creates files, commits, AND pushes to GitHub automatically.

### Example 5: JavaScript Solution

```bash
./scripts/add-leetcode-solution.sh \
  -n 217 \
  -t "Contains Duplicate" \
  -d Easy \
  -l js \
  -g "Array,Hash Table,Sorting"
```

Creates:
- `LeetCode/Easy/217-contains-duplicate/solution.js`
- `LeetCode/Easy/217-contains-duplicate/README.md`

---

## 🔄 Typical Workflow

### Step 1: Solve the Problem on LeetCode

1. Go to [LeetCode](https://leetcode.com/)
2. Find and solve the problem
3. Test with all provided test cases
4. Make note of:
   - Problem number
   - Problem title
   - Difficulty
   - Tags/topics
   - Time and space complexity

### Step 2: Create Structure Using Script

```bash
./scripts/add-leetcode-solution.sh \
  -n <number> \
  -t "<title>" \
  -d <difficulty> \
  -l <your_preferred_language> \
  -g "<tags>"
```

### Step 3: Implement Your Solution

1. Open the created solution file
2. Replace the placeholder method with your actual solution
3. Update the time and space complexity comments
4. Add your approach description
5. Add test cases

### Step 4: Document Your Solution

1. Open the README.md file
2. Copy the problem description from LeetCode
3. Fill in your approach explanation
4. Document the algorithm steps
5. Add complexity analysis
6. Include test cases
7. Add any notes or insights

### Step 5: Test Your Solution

```bash
# For Python
python3 LeetCode/<Difficulty>/<number>-<slug>/solution.py

# For Java
cd LeetCode/<Difficulty>/<number>-<slug>
javac solution.java
java Solution

# For C++
cd LeetCode/<Difficulty>/<number>-<slug>
g++ solution.cpp -o solution
./solution

# For JavaScript
node LeetCode/<Difficulty>/<number>-<slug>/solution.js
```

### Step 6: Commit and Push

```bash
git add LeetCode/<Difficulty>/<number>-<slug>/
git commit -m "Add LeetCode #<number>: <title> (<difficulty>)"
git push
```

Or use the `-p` flag in Step 2 to automate this!

---

## 📝 Template Customization

### Solution Templates

Templates are located in `scripts/templates/`:
- `solution-template.py` - Python template
- `solution-template.java` - Java template
- `solution-template.cpp` - C++ template
- `solution-template.js` - JavaScript template

### Placeholders

Templates use these placeholders:
- `{PROBLEM_NUMBER}` - Problem number
- `{PROBLEM_TITLE}` - Problem title
- `{DIFFICULTY}` - Easy/Medium/Hard
- `{PROBLEM_SLUG}` - URL-friendly slug
- `{TAGS}` - Comma-separated tags

### Customizing Templates

Edit the template files to match your preferred style:

```bash
# Edit Python template
nano scripts/templates/solution-template.py

# Edit Java template
nano scripts/templates/solution-template.java
```

---

## ⚙️ Advanced Usage

### Custom Slug

If the auto-generated slug is not correct:

```bash
./scripts/add-leetcode-solution.sh \
  -n 146 \
  -t "LRU Cache" \
  -d Medium \
  -s "lru-cache"
```

### Overwriting Existing Problems

If a problem folder already exists, the script will prompt you:

```
Warning: Directory already exists: LeetCode/Easy/1-two-sum
Do you want to continue and overwrite? (y/N):
```

Type `y` to overwrite or `N` to abort.

### Batch Adding Multiple Problems

Create a shell script to add multiple problems:

```bash
#!/bin/bash

# Add multiple problems at once
./scripts/add-leetcode-solution.sh -n 1 -t "Two Sum" -d Easy -g "Array,Hash Table"
./scripts/add-leetcode-solution.sh -n 2 -t "Add Two Numbers" -d Medium -g "Linked List,Math"
./scripts/add-leetcode-solution.sh -n 3 -t "Longest Substring Without Repeating Characters" -d Medium -g "Hash Table,String,Sliding Window"
```

---

## 🐛 Troubleshooting

### Script Not Executable

```bash
chmod +x scripts/add-leetcode-solution.sh
```

### sed Command Issues (macOS)

If you're on macOS and encounter sed errors, you may need to install GNU sed:

```bash
brew install gnu-sed
# Then use gsed instead of sed in the script
```

Or use an empty string with `-i`:

```bash
# In the script, change:
sed -i "s/pattern/replacement/g" file
# To:
sed -i "" "s/pattern/replacement/g" file
```

### Git Issues

Make sure you're in the repository root:

```bash
cd /path/to/DSA
./scripts/add-leetcode-solution.sh ...
```

### Permission Denied

```bash
chmod +x scripts/add-leetcode-solution.sh
```

---

## 📊 GitHub Actions

The repository includes automated workflows that run when you push changes:

### What Gets Automated

1. **Problem Counting** - Counts problems by difficulty
2. **Structure Validation** - Ensures folders have required files
3. **Problem List Generation** - Creates organized lists

### Triggering Workflows

Workflows run automatically on:
- Push to main branch (when LeetCode files change)
- Manual trigger via GitHub Actions UI

### Manual Trigger

1. Go to your repository on GitHub
2. Click "Actions" tab
3. Select "LeetCode Sync" workflow
4. Click "Run workflow"

---

## 💡 Tips and Best Practices

### 1. Consistent Naming

Always use the exact problem title from LeetCode:
```bash
# Good
-t "Two Sum"

# Avoid
-t "two sum"
-t "2Sum"
```

### 2. Accurate Tags

Use tags that match LeetCode's categorization:
```bash
-g "Array,Hash Table,Two Pointers"
```

### 3. Language Consistency

Try to maintain consistency in language choice for similar problems.

### 4. Documentation

Always fill in the README.md with:
- Complete problem description
- Your approach explanation
- Complexity analysis
- Test cases

### 5. Version Control

Commit regularly and use descriptive messages:
```bash
git commit -m "Add LeetCode #1: Two Sum (Easy) - Hash Map solution"
```

---

## 🔗 Related Documentation

- [Main README](../README.md) - Repository overview
- [LeetCode README](../LeetCode/README.md) - LeetCode section details
- [GitHub Actions Workflow](../.github/workflows/leetcode-sync.yml) - Automation workflow

---

## 📞 Support

If you encounter issues:
1. Check this guide for solutions
2. Review the script help: `./scripts/add-leetcode-solution.sh -h`
3. Open an issue on GitHub

---

**Happy Coding! 🚀**