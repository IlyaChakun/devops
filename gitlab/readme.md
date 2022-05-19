# Raise AWS ECR Repositories
It will provide you all the repositories that currently in use.

![img_1.png](img_1.png)

## Prepare a container image for the Runner Manager
First step is to create image of Runner Manager. This is a task inside of a ecs cluster that responisble for delegating jobs.

#### ECR repository Name it gitlab-runner-manager


Go to runner/runnermgr folder

Run commands from the ECR Repo from the step 1

aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin {AccountId}.dkr.ecr.us-east-1.amazonaws.com

docker build -t gitlab-runner-manager .

docker tag gitlab-runner-manager:latest {accountId}.dkr.ecr.us-east-1.amazonaws.com/gitlab-runner-manager:latest

docker push {accountId}.dkr.ecr.us-east-1.amazonaws.com/gitlab-runner-manager:latest

Prepare a container image for Runners
You need to create a container templates for all your jobs. Here we have the next templates:

Kaniko

Gradle

Default

Open https://gitlab.com/gatsbyfinancial/devops/-/tree/master/gitlab,

Go to runner folder

Then one by one build and push all the existing templates

Run commands from the ECR Repo from the step 1

aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin {AccountId}.dkr.ecr.us-east-1.amazonaws.com

docker build -t {repo-name} .

docker tag {repo-name}:latest {accountId}.dkr.ecr.us-east-1.amazonaws.com/{repo-name}:latest

docker push {accountId}.dkr.ecr.us-east-1.amazonaws.com/{repo-name}:latest

Raise AWS infrastructure
This template provide full infrastructure out of the box. It will create vpc, ecs cluster, ecs service for runner mgr, prepare task defenition for mg


Params:

DesiredTasks - count of runner mgrs tasks

EnvironmentName - gitlab

GitlabHost - based on where gitlab is deployed

GitlabSharedRunnerKey - The key from the gitlab repo. Must be groupRunner. Path https://gitlab.com/groups/{your_group_name}/-/runners

Create a credentials variable inside gitlab group
Create an AWS_CREDENTIALS.

![img.png](img.png)


Create a line with aws gitlab user (accesskey and accessId) and incode it with Base64 Encode and Decode - Online .

FQA
What is diffrenet between concurrent and limit inside the runner?
While concurrent defines the global concurrency limit across multiple [[runners]] workers, limit defines the maximum concurrency for a single [[runners]] worker.

More here



cache cdk-fargate-gitlab-runner/config_runner_template.toml at main · aws-samples/cdk-fargate-gitlab-runner

Useful links
config.toml options: Advanced configuration | GitLab

Autoscaling GitLab deployments using AWS Fargate

Serverless GitLab CI/CD on AWS Fargate

Autoscaling GitLab CI on AWS Fargate | GitLab

How to build containers with the AWS Fargate Custom Executor for GitLab Runner and AWS CodeBuild

Proper way to automatically start and expose ssh when running my app container

Gitlab Fargate unable to pull image during CI/CD

https://webera.blog/building-docker-images-without-docker-using-kaniko-gitlab-ci-and-aws-c85ee802a4b0

cdk-fargate-gitlab-runner/config_runner_template.toml at main · aws-samples/cdk-fargate-gitlab-runner 