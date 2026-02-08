#!/bin/bash

# LeetCode Solution Addition Script
# This script helps to quickly add a new LeetCode solution to the repository
# Usage: ./add-leetcode-solution.sh [options]
#
# Note: This script uses sed -i which behaves differently on macOS vs Linux.
# On macOS, if you encounter issues, you may need to install GNU sed:
#   brew install gnu-sed
# Or the script will attempt to detect the OS and adjust accordingly.

set -e  # Exit on error

# Detect OS for sed compatibility
if [[ "$OSTYPE" == "darwin"* ]]; then
    IS_MACOS=true
else
    IS_MACOS=false
fi

# Helper function for safe sed replacement
safe_sed_replace() {
    local file="$1"
    local pattern="$2"
    local replacement="$3"
    
    # Escape special characters in replacement string
    replacement=$(printf '%s\n' "$replacement" | sed 's/[&/\]/\\&/g')
    
    if [[ "$IS_MACOS" == true ]]; then
        sed -i '' "s/$pattern/$replacement/g" "$file"
    else
        sed -i "s/$pattern/$replacement/g" "$file"
    fi
}

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Default values
AUTO_COMMIT=false
AUTO_PUSH=false
LANGUAGE="python"

# Function to display usage
usage() {
    echo -e "${BLUE}Usage:${NC} $0 [OPTIONS]"
    echo ""
    echo "Options:"
    echo "  -n, --number NUM        Problem number (required)"
    echo "  -t, --title TITLE       Problem title (required)"
    echo "  -d, --difficulty DIFF   Difficulty: Easy, Medium, or Hard (required)"
    echo "  -l, --language LANG     Programming language: python, java, cpp, js (default: python)"
    echo "  -s, --slug SLUG         Problem URL slug (optional, auto-generated from title)"
    echo "  -g, --tags TAGS         Comma-separated tags (optional)"
    echo "  -c, --commit            Auto-commit the changes (optional)"
    echo "  -p, --push              Auto-push to GitHub (implies --commit) (optional)"
    echo "  -h, --help              Display this help message"
    echo ""
    echo "Example:"
    echo "  $0 -n 1 -t \"Two Sum\" -d Easy -l python -g \"Array,Hash Table\" -c"
    echo ""
    exit 1
}

# Function to convert title to slug
title_to_slug() {
    echo "$1" | tr '[:upper:]' '[:lower:]' | sed 's/ /-/g' | sed 's/[^a-z0-9-]//g'
}

# Function to get file extension
get_extension() {
    case "$1" in
        python) echo "py" ;;
        java) echo "java" ;;
        cpp) echo "cpp" ;;
        js) echo "js" ;;
        *) echo "py" ;;
    esac
}

# Parse command line arguments
while [[ $# -gt 0 ]]; do
    case $1 in
        -n|--number)
            PROBLEM_NUMBER="$2"
            shift 2
            ;;
        -t|--title)
            PROBLEM_TITLE="$2"
            shift 2
            ;;
        -d|--difficulty)
            DIFFICULTY="$2"
            shift 2
            ;;
        -l|--language)
            LANGUAGE="$2"
            shift 2
            ;;
        -s|--slug)
            PROBLEM_SLUG="$2"
            shift 2
            ;;
        -g|--tags)
            TAGS="$2"
            shift 2
            ;;
        -c|--commit)
            AUTO_COMMIT=true
            shift
            ;;
        -p|--push)
            AUTO_PUSH=true
            AUTO_COMMIT=true
            shift
            ;;
        -h|--help)
            usage
            ;;
        *)
            echo -e "${RED}Error: Unknown option $1${NC}"
            usage
            ;;
    esac
done

# Validate required parameters
if [[ -z "$PROBLEM_NUMBER" ]] || [[ -z "$PROBLEM_TITLE" ]] || [[ -z "$DIFFICULTY" ]]; then
    echo -e "${RED}Error: Problem number, title, and difficulty are required${NC}"
    usage
fi

# Validate difficulty
if [[ ! "$DIFFICULTY" =~ ^(Easy|Medium|Hard)$ ]]; then
    echo -e "${RED}Error: Difficulty must be Easy, Medium, or Hard${NC}"
    exit 1
fi

# Generate slug if not provided
if [[ -z "$PROBLEM_SLUG" ]]; then
    PROBLEM_SLUG=$(title_to_slug "$PROBLEM_TITLE")
fi

# Set default tags if not provided
if [[ -z "$TAGS" ]]; then
    TAGS="TODO"
fi

# Get file extension
FILE_EXT=$(get_extension "$LANGUAGE")

# Define paths
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
REPO_ROOT="$(dirname "$SCRIPT_DIR")"
PROBLEM_DIR="$REPO_ROOT/LeetCode/$DIFFICULTY/$PROBLEM_NUMBER-$PROBLEM_SLUG"
TEMPLATE_DIR="$SCRIPT_DIR/templates"

echo -e "${BLUE}=====================================${NC}"
echo -e "${BLUE}LeetCode Solution Setup${NC}"
echo -e "${BLUE}=====================================${NC}"
echo -e "Problem Number: ${GREEN}$PROBLEM_NUMBER${NC}"
echo -e "Problem Title: ${GREEN}$PROBLEM_TITLE${NC}"
echo -e "Difficulty: ${GREEN}$DIFFICULTY${NC}"
echo -e "Language: ${GREEN}$LANGUAGE${NC}"
echo -e "Slug: ${GREEN}$PROBLEM_SLUG${NC}"
echo -e "Tags: ${GREEN}$TAGS${NC}"
echo -e "Folder: ${GREEN}$PROBLEM_DIR${NC}"
echo -e "${BLUE}=====================================${NC}"

# Check if directory already exists
if [[ -d "$PROBLEM_DIR" ]]; then
    echo -e "${YELLOW}Warning: Directory already exists: $PROBLEM_DIR${NC}"
    read -p "Do you want to continue and overwrite? (y/N): " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        echo -e "${RED}Aborted.${NC}"
        exit 1
    fi
else
    # Create problem directory
    mkdir -p "$PROBLEM_DIR"
    echo -e "${GREEN}✓${NC} Created directory: $PROBLEM_DIR"
fi

# Copy and customize solution template
SOLUTION_FILE="$PROBLEM_DIR/solution.$FILE_EXT"
TEMPLATE_FILE="$TEMPLATE_DIR/solution-template.$FILE_EXT"

if [[ -f "$TEMPLATE_FILE" ]]; then
    cp "$TEMPLATE_FILE" "$SOLUTION_FILE"
    
    # Replace placeholders using safe function
    safe_sed_replace "$SOLUTION_FILE" "{PROBLEM_NUMBER}" "$PROBLEM_NUMBER"
    safe_sed_replace "$SOLUTION_FILE" "{PROBLEM_TITLE}" "$PROBLEM_TITLE"
    safe_sed_replace "$SOLUTION_FILE" "{DIFFICULTY}" "$DIFFICULTY"
    safe_sed_replace "$SOLUTION_FILE" "{PROBLEM_SLUG}" "$PROBLEM_SLUG"
    safe_sed_replace "$SOLUTION_FILE" "{TAGS}" "$TAGS"
    
    echo -e "${GREEN}✓${NC} Created solution file: $SOLUTION_FILE"
else
    echo -e "${YELLOW}Warning: Template not found: $TEMPLATE_FILE${NC}"
    echo -e "Creating basic solution file..."
    touch "$SOLUTION_FILE"
fi

# Create README from template
README_FILE="$PROBLEM_DIR/README.md"
README_TEMPLATE="$TEMPLATE_DIR/problem-readme-template.md"

if [[ -f "$README_TEMPLATE" ]]; then
    cp "$README_TEMPLATE" "$README_FILE"
    
    # Replace placeholders with safe values
    safe_sed_replace "$README_FILE" "{PROBLEM_NUMBER}" "$PROBLEM_NUMBER"
    safe_sed_replace "$README_FILE" "{PROBLEM_TITLE}" "$PROBLEM_TITLE"
    safe_sed_replace "$README_FILE" "{DIFFICULTY}" "$DIFFICULTY"
    safe_sed_replace "$README_FILE" "{PROBLEM_SLUG}" "$PROBLEM_SLUG"
    safe_sed_replace "$README_FILE" "{TAGS}" "$TAGS"
    
    # Replace other placeholders with TODO markers
    safe_sed_replace "$README_FILE" "{PROBLEM_DESCRIPTION}" "TODO: Add problem description from LeetCode"
    safe_sed_replace "$README_FILE" "{APPROACH_DESCRIPTION}" "TODO: Describe your approach"
    safe_sed_replace "$README_FILE" "{STEP_1}" "TODO: Add step 1"
    safe_sed_replace "$README_FILE" "{STEP_2}" "TODO: Add step 2"
    safe_sed_replace "$README_FILE" "{STEP_3}" "TODO: Add step 3"
    safe_sed_replace "$README_FILE" "{TIME_COMPLEXITY_EXPLANATION}" "TODO: Explain time complexity"
    safe_sed_replace "$README_FILE" "{SPACE_COMPLEXITY_EXPLANATION}" "TODO: Explain space complexity"
    safe_sed_replace "$README_FILE" "{SOLUTION_1_NAME}" "Main Solution"
    safe_sed_replace "$README_FILE" "{LANGUAGE}" "$LANGUAGE"
    safe_sed_replace "$README_FILE" "{ext}" "$FILE_EXT"
    safe_sed_replace "$README_FILE" "{SOLUTION_1_EXPLANATION}" "TODO: Add explanation"
    safe_sed_replace "$README_FILE" "{INPUT_1}" "TODO"
    safe_sed_replace "$README_FILE" "{OUTPUT_1}" "TODO"
    safe_sed_replace "$README_FILE" "{EXPECTED_1}" "TODO"
    safe_sed_replace "$README_FILE" "{INPUT_2}" "TODO"
    safe_sed_replace "$README_FILE" "{OUTPUT_2}" "TODO"
    safe_sed_replace "$README_FILE" "{EXPECTED_2}" "TODO"
    safe_sed_replace "$README_FILE" "{NOTE_1}" "TODO: Add notes"
    safe_sed_replace "$README_FILE" "{NOTE_2}" "TODO: Add more notes"
    
    echo -e "${GREEN}✓${NC} Created README file: $README_FILE"
else
    echo -e "${YELLOW}Warning: README template not found${NC}"
    echo "# $PROBLEM_NUMBER. $PROBLEM_TITLE" > "$README_FILE"
    echo "" >> "$README_FILE"
    echo "**Difficulty:** $DIFFICULTY" >> "$README_FILE"
    echo "**Link:** https://leetcode.com/problems/$PROBLEM_SLUG/" >> "$README_FILE"
    echo "**Tags:** $TAGS" >> "$README_FILE"
fi

echo -e "${GREEN}=====================================${NC}"
echo -e "${GREEN}✓ Successfully created problem structure!${NC}"
echo -e "${GREEN}=====================================${NC}"
echo ""
echo -e "Next steps:"
echo -e "1. Edit the solution file: ${BLUE}$SOLUTION_FILE${NC}"
echo -e "2. Update the README: ${BLUE}$README_FILE${NC}"
echo -e "3. Add problem description and test cases"
echo ""

# Git operations
if [[ "$AUTO_COMMIT" == true ]]; then
    cd "$REPO_ROOT"
    git add "$PROBLEM_DIR"
    git commit -m "Add LeetCode #$PROBLEM_NUMBER: $PROBLEM_TITLE ($DIFFICULTY)"
    echo -e "${GREEN}✓${NC} Changes committed"
    
    if [[ "$AUTO_PUSH" == true ]]; then
        git push
        echo -e "${GREEN}✓${NC} Changes pushed to GitHub"
    fi
fi

echo -e "${GREEN}Done!${NC}"
