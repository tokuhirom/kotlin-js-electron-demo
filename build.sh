#!/bin/bash
set -ex
BASE_DIR=$(dirname "$0")

cd "$BASE_DIR/target/"
npm install
npx electron --inspect=9229 .
