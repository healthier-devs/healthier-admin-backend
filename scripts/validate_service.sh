#!/bin/bash
# validate_service.sh
if ! docker ps | grep -q <CONTAINER_NAME>; then
    echo "Docker container is not running."
    exit 1
fi