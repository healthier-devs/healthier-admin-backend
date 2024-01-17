#!/bin/bash
# start_docker.sh

IMAGE_NAME="<ECR_REGISTRY>/<ECR_REPOSITORY>:<IMAGE_TAG>"
AWS_REGION="<AWS_REGION>"
ECR_REGISTRY="<ECR_REGISTRY>"

aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin $ECR_REGISTRY

docker pull $IMAGE_NAME

if docker ps -a | grep -q "<CONTAINER_NAME>"; then
    echo "Container '<CONTAINER_NAME>' already exists. Stopping and removing it."
    docker stop <CONTAINER_NAME>
    docker rm <CONTAINER_NAME>
fi

docker run -d --name <CONTAINER_NAME> -p 8080:8080 $IMAGE_NAME