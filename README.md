# 📚 Data Structures & Algorithms (DSA)

Welcome to my DSA repository! This repository contains a comprehensive collection of data structures and algorithm problems, solutions, and notes. It's meant for practice, learning, and interview preparation.

> 🎨 **New!** Check out the [Frontend Projects Guide](./FRONTEND_PROJECTS_GUIDE.md) - A comprehensive guide to the best projects for frontend developers, perfectly complementing your DSA practice!

---

## 📂 Repository Structure

```
DSA/
├── LeetCode/                    # Organized LeetCode solutions by difficulty
│   ├── Easy/                   # Easy difficulty problems
│   ├── Medium/                 # Medium difficulty problems
│   ├── Hard/                   # Hard difficulty problems
│   └── README.md               # LeetCode section documentation
├── scripts/                     # Automation scripts
│   ├── add-leetcode-solution.sh # Script to add new LeetCode solutions
│   └── templates/              # Solution and README templates
│       ├── solution-template.py
│       ├── solution-template.java
│       ├── solution-template.cpp
│       ├── solution-template.js
│       └── problem-readme-template.md
├── .github/
│   └── workflows/
│       └── leetcode-sync.yml   # GitHub Actions workflow
├── FRONTEND_PROJECTS_GUIDE.md  # 🆕 Best projects for frontend developers
└── README.md                    # This file
```

---

## 🚀 Quick Start: Adding a LeetCode Solution

### Using the Automated Script

The easiest way to add a new LeetCode solution is using the provided script:

```bash
# Navigate to repository root
cd /path/to/DSA

# Add a new solution
./scripts/add-leetcode-solution.sh -n <number> -t "<title>" -d <difficulty> -l <language>
```

**Example:**
```bash
# Add "Two Sum" in Python
./scripts/add-leetcode-solution.sh -n 1 -t "Two Sum" -d Easy -l python -g "Array,Hash Table"

# Add and auto-commit
./scripts/add-leetcode-solution.sh -n 15 -t "3Sum" -d Medium -l java -g "Array,Two Pointers" -c

# Add, commit, and push
./scripts/add-leetcode-solution.sh -n 4 -t "Median of Two Sorted Arrays" -d Hard -l cpp -p
```

### Script Options

| Option | Description | Required | Default |
|--------|-------------|----------|---------|
| `-n, --number` | Problem number | Yes | - |
| `-t, --title` | Problem title | Yes | - |
| `-d, --difficulty` | Easy, Medium, or Hard | Yes | - |
| `-l, --language` | python, java, cpp, js | No | python |
| `-s, --slug` | URL slug | No | Auto-generated |
| `-g, --tags` | Comma-separated tags | No | TODO |
| `-c, --commit` | Auto-commit changes | No | false |
| `-p, --push` | Auto-commit and push | No | false |
| `-h, --help` | Display help | No | - |

### Supported Languages

- **Python** (.py) - Default
- **Java** (.java)
- **C++** (.cpp)
- **JavaScript** (.js)

---

## 📊 LeetCode Statistics

<!-- These statistics can be automatically updated by GitHub Actions -->

### Current Progress

| Difficulty | Count |
|------------|-------|
| 🟢 Easy | 0 |
| 🟡 Medium | 0 |
| 🔴 Hard | 0 |
| **Total** | **0** |

> Run the GitHub Actions workflow or use `find LeetCode/{Easy,Medium,Hard} -mindepth 1 -maxdepth 1 -type d | wc -l` to update counts.

---

## 📝 Workflow

### 1. Solve on LeetCode
- Go to [LeetCode](https://leetcode.com/)
- Solve the problem
- Test with multiple test cases

### 2. Add to Repository
```bash
./scripts/add-leetcode-solution.sh \
  -n <problem_number> \
  -t "<Problem Title>" \
  -d <Easy|Medium|Hard> \
  -l <language> \
  -g "Tag1,Tag2"
```

### 3. Implement Solution
The script creates:
- `LeetCode/{Difficulty}/{number}-{slug}/solution.{ext}`
- `LeetCode/{Difficulty}/{number}-{slug}/README.md`

Edit these files with your solution and documentation.

### 4. Complete Documentation
Fill in the README.md with:
- Problem description (copy from LeetCode)
- Your approach and algorithm
- Complexity analysis
- Test cases
- Notes and related problems

### 5. Commit and Push
```bash
git add LeetCode/
git commit -m "Add LeetCode #<number>: <Title> (<Difficulty>)"
git push
```

Or use the `-p` flag with the script to do this automatically!

---

## 🎯 Solution Template Features

Each solution includes:

### Code Template
- Header with problem metadata
- Time and space complexity placeholders
- Approach description section
- Well-structured solution method
- Test cases section

### README Template
- Problem description
- Approach explanation
- Step-by-step algorithm
- Complexity analysis with explanations
- Multiple solution approaches
- Test cases with expected outputs
- Notes and tips
- Related problems

---

## 🤖 GitHub Actions Automation

The repository includes a GitHub Actions workflow that:

1. **Validates Structure** - Ensures all problems have required files
2. **Counts Problems** - Tracks problems by difficulty
3. **Generates Lists** - Creates organized problem lists
4. **Updates Statistics** - Keeps README stats current (optional)

Workflow runs on:
- Push to main branch (when LeetCode files change)
- Manual trigger via GitHub Actions UI
- Scheduled daily updates (optional, can be enabled)

---

## 💡 Best Practices

### Before Adding a Solution
1. ✅ Solve the problem on LeetCode
2. ✅ Understand time and space complexity
3. ✅ Test with edge cases
4. ✅ Consider alternative approaches

### When Writing Code
1. 📝 Use meaningful variable names
2. 💬 Add comments for complex logic
3. 🎨 Follow language-specific conventions
4. 🧪 Include comprehensive test cases

### Documentation
1. 📖 Explain your thought process
2. 🔍 Document alternative approaches
3. 📊 Analyze time and space complexity
4. ⚠️ Note edge cases and constraints

---

## 📁 Directory Organization

### LeetCode Problems
Organized by difficulty in the `LeetCode/` directory:
- **Easy/** - Foundational problems, basic algorithms
- **Medium/** - Common interview problems, intermediate concepts
- **Hard/** - Advanced algorithms, complex data structures

Each problem follows the structure:
```
{number}-{slug}/
├── solution.{ext}   # Your solution code
└── README.md        # Problem documentation
```

### Scripts
The `scripts/` directory contains:
- `add-leetcode-solution.sh` - Main automation script
- `templates/` - Code and documentation templates

---

## 🏷️ Common Problem Categories

- **Arrays & Strings:** Manipulation, searching, sorting
- **Linked Lists:** Traversal, reversal, cycle detection
- **Trees & Graphs:** Traversal (DFS/BFS), searching
- **Dynamic Programming:** Memoization, tabulation
- **Greedy Algorithms:** Optimization problems
- **Backtracking:** Permutations, combinations
- **Binary Search:** Searching, optimization
- **Two Pointers:** Array problems, string problems
- **Sliding Window:** Subarray problems
- **Hash Tables:** Fast lookups, counting

---

## 📚 Learning Resources

### Platforms
- [LeetCode](https://leetcode.com/) - Practice platform
- [NeetCode](https://neetcode.io/) - Curated problem lists
- [LeetCode Patterns](https://seanprashad.com/leetcode-patterns/) - Common patterns

### Study Guides
- [Blind 75](https://www.teamblind.com/post/New-Year-Gift---Curated-List-of-Top-75-LeetCode-Questions-to-Save-Your-Time-OaM1orEU) - Essential interview questions
- [Grind 75](https://www.techinterviewhandbook.org/grind75) - Structured study plan

---

## 🎨 Frontend Developer Projects

Looking to build practical projects alongside your DSA practice? Check out our comprehensive **[Frontend Projects Guide](./FRONTEND_PROJECTS_GUIDE.md)**!

### Why Build Frontend Projects?

While mastering DSA is crucial for technical interviews, building real-world projects demonstrates:
- **Practical application** of algorithms and data structures
- **Problem-solving skills** in real scenarios
- **Full development cycle** experience
- **Portfolio pieces** for job applications

### What's Inside the Guide?

✨ **17+ Project Ideas** organized by difficulty:
- 🌱 Beginner: Portfolio, Todo App, Weather App, Calculator, Quiz App
- 🚀 Intermediate: E-commerce, Movie Database, Kanban Board, Chat App
- 💎 Advanced: Code Editor, Video Platform, Google Maps Clone, Collaborative Tools

📚 **For Each Project:**
- Required technologies and tech stack
- Key features to implement
- Skills you'll learn
- DSA concepts applied
- Timeline estimates

🛠️ **Additional Resources:**
- Best practices and coding standards
- Recommended tech stack
- Deployment strategies
- Learning path recommendations
- Project planning templates

**[👉 View the Complete Guide](./FRONTEND_PROJECTS_GUIDE.md)**

---

## 🤝 Contributing

This is a personal learning repository, but contributions and suggestions are welcome!

To contribute:
1. Fork the repository
2. Create a feature branch
3. Add your solution using the provided scripts
4. Submit a pull request

---

## 📜 License

This repository is for educational purposes. All LeetCode problems are property of LeetCode LLC.

---

## 🎓 About

This repository is maintained by [@vikashkumar016](https://github.com/vikashkumar016) as part of continuous learning and interview preparation.

**Happy Coding! 🚀**

---

## 📞 Contact

For questions or suggestions, please open an issue or reach out via GitHub.

---

*Last Updated: January 2026*