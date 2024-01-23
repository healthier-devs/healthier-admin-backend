#!/bin/bash

if ! docker ps | grep -q <CONTAINER_NAME>; then
    echo "Docker container is not running."
    exit 1
fi