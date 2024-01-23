#!/bin/bash

sudo yum update -y

if ! command -v docker &> /dev/null; then
    echo "Installing Docker..."
    sudo yum install docker -y
    sudo systemctl start docker
    sudo systemctl enable docker
    sudo usermod -a -G docker ec2-user
else
    echo "Docker already installed. Skipping installation."
fi