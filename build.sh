#!/bin/bash
set -ex
BASE_DIR=$(dirname "$0")
ROOT_DIR=$BASE_DIR
TARGET=$BASE_DIR/target/
mkdir -p $TARGET/renderer $TARGET/preload $TARGET/main
cp -a $ROOT_DIR/main/build/compileSync/js/main/developmentExecutable/kotlin/* $TARGET/main/
cp -a $ROOT_DIR/preload/build/compileSync/js/main/developmentExecutable/kotlin/* $TARGET/preload/
cp -a $ROOT_DIR/renderer/build/kotlin-webpack/js/developmentExecutable/renderer.js $TARGET/renderer/

cd $TARGET
npm install
npx electron --inspect=9229 .
