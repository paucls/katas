#!/usr/bin/env python3

import sys
import json
from datetime import datetime

def main():
    # Read the JSON data from stdin
    input_data = sys.stdin.read()

    # Parse the JSON
    try:
        data = json.loads(input_data)

        if data.get("agent_action_name") == "post_cascade_response":
            tool_info = data.get("tool_info", {})
            cascade_response = tool_info.get("response", "")
            trajectory_id = data.get("trajectory_id", "unknown")
            timestamp = data.get("timestamp", datetime.now().isoformat())

            # Log to file
            with open("/Users/paulo/code/katas/20260420-harness-engineering-kata/cascade_responses.log", "a") as f:
                f.write(f"\n{'='*80}\n")
                f.write(f"Timestamp: {timestamp}\n")
                f.write(f"Trajectory ID: {trajectory_id}\n")
                f.write(f"Response:\n{cascade_response}\n")

            print(f"Logged Cascade response for trajectory {trajectory_id}")

    except json.JSONDecodeError as e:
        print(f"Error parsing JSON: {e}", file=sys.stderr)
        sys.exit(1)

if __name__ == "__main__":
    main()