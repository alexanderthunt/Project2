pipeline{
    agent{
        kubernetes{
            // this tells Jenkins to use the pod called "devops" we defined in the jenkins-values.yaml file
            // which will give us access to the docker commands we need to build/push our docker image
            inheritFrom "planetarium"
        }
    }

    environment{
        // any environment variables we want to use can go in here
        // I recommend setting variables for the docker registry (which doubles as the image name)
        // and a variable to represent the image itself
        PLANETARIUM_REGISTRY='twcl774/planetarium'
        PLANETARIUM_IMAGE=''
    }

    stages{
        // this is where the steps of the job will be defined
        stage("build and push docker image"){
            // steps is where the actual commands go
            steps{
                echo "print something to the console"
                container("docker"){
                    // the script section is sometimes needed when using functions provided by Jenkins plugins    
                    script{
                        // build(image name and tag, location of dockerfile)
                        PLANETARIUM_IMAGE= docker.build(PLANETARIUM_REGISTRY,".") 
                    }                    
                }
            }
        }
    }

}