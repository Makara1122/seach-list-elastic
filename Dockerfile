FROM ubuntu:latest
LABEL authors="makar"

ENTRYPOINT ["top", "-b"]