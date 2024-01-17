#!/bin/bash
# stop_docker.sh
echo "Stopping container: <CONTAINER_NAME>"
docker stop <CONTAINER_NAME>
if [ $? -eq 0 ]; then
    echo "Container <CONTAINER_NAME> stopped successfully."
else
    echo "Failed to stop container <CONTAINER_NAME>."
fi

echo "Removing container: <CONTAINER_NAME>"
docker rm <CONTAINER_NAME>
if [ $? -eq 0 ]; then
    echo "Container <CONTAINER_NAME> removed successfully."
else
    echo "Failed to remove container <CONTAINER_NAME>."
fi