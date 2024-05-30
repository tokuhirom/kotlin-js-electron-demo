#!/usr/bin/env python
import subprocess
import signal
import sys
import os
import shutil
from time import sleep

def main():
    print("Hello from debug.py")

    script_dir = os.path.dirname(os.path.abspath(__file__))
    target_dir = os.path.join(script_dir, "target")

    # clean the old files...
    for d in ["preload", "renderer", "main"]:
        print(f"Cleaning target/{d} directory")
        shutil.rmtree(os.path.join(target_dir, d), ignore_errors=True)

    tasks = [':preload:jsBrowserDevelopmentWebpack', 'jsDevelopmentExecutableCompileSync']

    # Run the gradle task to compile the Kotlin/JS code
    subprocess.run(["./gradlew"] + tasks,
        stdout=sys.stdout, stderr=sys.stderr, cwd=script_dir)

    # Run the gradle task to compile the Kotlin/JS code, continuously
    gradle = subprocess.Popen(["./gradlew","-t"] + tasks,
        stdout=sys.stdout, stderr=sys.stderr, cwd=script_dir)

    # start the electron app in target/ directory
    electron = subprocess.Popen(["npx", "electron", "."],
        stdout=sys.stdout, stderr=sys.stderr, cwd=target_dir)

    gradle.wait()

if __name__ == "__main__":
    main()
