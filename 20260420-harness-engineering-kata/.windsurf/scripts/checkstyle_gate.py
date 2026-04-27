#!/usr/bin/env python3
"""
Checkstyle quality gate hook for Windsurf Cascade.
Runs mvn checkstyle:checkstyle and blocks if violations exist.
"""

import subprocess
import sys
import json

def main():
    # Run checkstyle
    result = subprocess.run(
        ["mvn", "checkstyle:checkstyle"],
        capture_output=True,
        text=True
    )
    
    # Check if checkstyle found violations
    # Maven checkstyle:checkstyle returns non-zero if violations found
    if result.returncode != 0:
        print("❌ Checkstyle violations detected!", file=sys.stderr)
        print(result.stdout, file=sys.stderr)
        print(result.stderr, file=sys.stderr)
        print("\nPlease fix the checkstyle violations before proceeding.", file=sys.stderr)
        sys.exit(2)  # Exit code 2 blocks the action
    else:
        print("✅ Checkstyle passed - no violations found")
        sys.exit(0)

if __name__ == "__main__":
    main()
